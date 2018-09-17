package net.archeryc.douyinvideolist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.view.SimpleDraweeView;

import net.archeryc.douyinvideolist.entity.VideoEntity;
import net.archeryc.douyinvideolist.wedgit.listvideo.ListVideoView;
import net.archeryc.douyinvideolist.wedgit.listvideo.VideoUtils;

import java.util.ArrayList;
import java.util.List;

import tv.danmaku.ijk.media.player.IMediaPlayer;

/**
 * @author ArcherYc
 * @date on 2018/9/12  下午3:19
 * @mail 247067345@qq.com
 */
public class VideoAdapter extends RecyclerView.Adapter {

    private List<VideoEntity> dataList = new ArrayList<>();

    private Context mContext;

    private RecyclerView recyclerView;

    public VideoAdapter(Context context, RecyclerView recyclerView) {
        this.mContext = context;
        this.recyclerView = recyclerView;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_item_video, parent, false);
        return new VideoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        VideoEntity videoEntity = dataList.get(position);
        VideoViewHolder viewHolder = (VideoViewHolder) holder;
        viewHolder.sdvCover.setImageURI(videoEntity.getCoverUrl());
        fitVideoScaleType(viewHolder, videoEntity);
    }

    private void fitVideoScaleType(VideoViewHolder viewHolder, VideoEntity videoEntity) {
        int contentWidth = recyclerView.getWidth();
        int contentHeight = recyclerView.getHeight();

        VideoUtils.ScaleType scaleType = VideoUtils.getImageCropType(new Pair<>(contentWidth, contentHeight),
                new Pair<>(videoEntity.getWidth(), videoEntity.getHeight()));
        if (scaleType == VideoUtils.ScaleType.CENTER_CROP) {
            viewHolder.sdvCover.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.CENTER_CROP);
        } else if (scaleType == VideoUtils.ScaleType.FIT_CENTER) {
            viewHolder.sdvCover.getHierarchy().setActualImageScaleType(ScalingUtils.ScaleType.FIT_CENTER);
        }
    }


    @Override
    public int getItemCount() {
        return dataList.size();
    }

    public void addData(List<VideoEntity> newDataList) {
        this.dataList.addAll(newDataList);
    }

    public VideoEntity getDataByPosition(int position) {
        return dataList.get(position);
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder {

        public ListVideoView videoView;
        public SimpleDraweeView sdvCover;

        public VideoViewHolder(View itemView) {
            super(itemView);
            videoView = itemView.findViewById(R.id.videoView);
            sdvCover = itemView.findViewById(R.id.sdv_cover);
        }
    }
}
