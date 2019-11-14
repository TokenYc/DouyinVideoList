package net.archeryc.douyinvideolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.facebook.drawee.backends.pipeline.Fresco;

import net.archeryc.douyinvideolist.entity.VideoEntity;
import net.archeryc.douyinvideolist.wedgit.listvideo.ListVideoView;
import net.archeryc.douyinvideolist.wedgit.pagerlayoutmanager.OnViewPagerListener;
import net.archeryc.douyinvideolist.wedgit.pagerlayoutmanager.ViewPagerLayoutManager;

import tv.danmaku.ijk.media.player.IMediaPlayer;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

public class MainActivity extends AppCompatActivity implements OnViewPagerListener {

    RecyclerView recyclerView;
    ViewPagerLayoutManager pagerLayoutManager;
    VideoAdapter videoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Fresco.initialize(this);

        IjkMediaPlayer.loadLibrariesOnce(null);
        IjkMediaPlayer.native_profileBegin("libijkplayer.so");

        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent e) {
                final int action = e.getActionMasked();
                switch (action) {
                    case MotionEvent.ACTION_DOWN://手指按下
                        break;
                    case MotionEvent.ACTION_CANCEL:
                        break;
                    case MotionEvent.ACTION_MOVE://手指移动（从手指按下到抬起 move多次执行）
                        break;
                    case MotionEvent.ACTION_UP://手指抬起
                        if (recyclerView.getScrollState() == RecyclerView.SCROLL_STATE_DRAGGING &&
                                pagerLayoutManager.findSnapPosition() == 0) {
                            if (recyclerView.getChildAt(0).getY() == 0 &&
                                    recyclerView.canScrollVertically(1)) {//下滑操作
                                recyclerView.stopScroll();
                            }
                        }
                        break;
                    default:
                        break;
                }

                return false;
            }
        });

        pagerLayoutManager = new ViewPagerLayoutManager(this, LinearLayoutManager.VERTICAL);
        pagerLayoutManager.setOnViewPagerListener(this);
        videoAdapter = new VideoAdapter(this, recyclerView);

        recyclerView.setLayoutManager(pagerLayoutManager);
        recyclerView.setAdapter(videoAdapter);

        videoAdapter.addData(MockData.getMockVideoData());
    }

    @Override
    public void onInitComplete() {
        playVideo(0);
    }

    @Override
    public void onPageSelected(int position, boolean isBottom) {
        playVideo(position);
    }

    @Override
    public void onPageRelease(boolean isNext, int position) {
        releaseVideo(position);
    }

    private void playVideo(int position) {
        final VideoAdapter.VideoViewHolder viewHolder = (VideoAdapter.VideoViewHolder) recyclerView.findViewHolderForLayoutPosition(position);
        VideoEntity videoEntity = videoAdapter.getDataByPosition(position);
        if (viewHolder != null && !viewHolder.videoView.isPlaying()) {
            viewHolder.videoView.setVideoPath(videoEntity.getVideoUrl());
            viewHolder.videoView.getMediaPlayer().setOnInfoListener(new IMediaPlayer.OnInfoListener() {
                @Override
                public boolean onInfo(IMediaPlayer iMediaPlayer, int what, int extra) {
                    if (what == IMediaPlayer.MEDIA_INFO_VIDEO_RENDERING_START) {
                        viewHolder.sdvCover.setVisibility(View.INVISIBLE);
                    }
                    return false;
                }
            });
            viewHolder.videoView.setOnVideoProgressUpdateListener(new ListVideoView.OnVideoProgressListener() {
                @Override
                public void onProgress(float progress, long currentTime) {
                    Log.d("youzai", "progresss---->" + progress + "\t" + "currentTime---->" + currentTime);
                }
            });
            viewHolder.videoView.setLooping(true);
            viewHolder.videoView.prepareAsync();
        }
    }

    private void releaseVideo(int position) {
        VideoAdapter.VideoViewHolder viewHolder = (VideoAdapter.VideoViewHolder) recyclerView.findViewHolderForLayoutPosition(position);
        if (viewHolder != null) {
            viewHolder.videoView.stopPlayback();
            viewHolder.sdvCover.setVisibility(View.VISIBLE);
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        pauseVideo();
    }

    @Override
    protected void onResume() {
        super.onResume();
        restartVideo();
    }

    /**
     * 暂停视频
     */
    private void pauseVideo() {
        int snapPosition = pagerLayoutManager.findSnapPosition();
        if (snapPosition >= 0) {
            VideoAdapter.VideoViewHolder viewHolder =
                    (VideoAdapter.VideoViewHolder) recyclerView.findViewHolderForLayoutPosition(snapPosition);
            if (viewHolder != null) {
                viewHolder.videoView.pause();
            }
        }
    }

    /**
     * 暂停后重新播放视频
     */
    private void restartVideo() {
        int snapPosition = pagerLayoutManager.findSnapPosition();
        if (snapPosition >= 0) {
            VideoAdapter.VideoViewHolder viewHolder =
                    (VideoAdapter.VideoViewHolder) recyclerView.findViewHolderForLayoutPosition(snapPosition);
            if (viewHolder != null) {
                viewHolder.videoView.start();
            }
        }
    }
}
