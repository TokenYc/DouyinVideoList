package net.archeryc.douyinvideolist;

import net.archeryc.douyinvideolist.entity.VideoEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ArcherYc
 * @date on 2018/9/12  下午3:47
 * @mail 247067345@qq.com
 */
public class MockData {

    public static List<VideoEntity> getMockVideoData() {
        List<VideoEntity> videoList = new ArrayList<>();

        videoList.add(new VideoEntity("https://p3.pstatp.com/large/c0b300014a9ef7257e51.jpg",
                "https://aweme.snssdk.com/aweme/v1/playwm/?video_id=v0200fd30000befl25pcgf3dsrv6mmog&line=0", 360, 640));
        videoList.add(new VideoEntity("https://p3.pstatp.com/large/b8410004ef57355b50cf.jpg",
                "https://aweme.snssdk.com/aweme/v1/playwm/?video_id=v03033ef0000be8v3bsif32ldjudh4c0&line=0", 384, 1138));
        videoList.add(new VideoEntity("https://p1.pstatp.com/large/bd8f000561db440796dd.jpg",
                "https://aweme.snssdk.com/aweme/v1/playwm/?video_id=v0200fa90000bee4qrqr863tt0o22t50&line=0", 384, 640));
        videoList.add(new VideoEntity("https://p98.pstatp.com/large/c054000328c6b3983d04.jpg",
                "https://aweme.snssdk.com/aweme/v1/playwm/?video_id=v0200f500000beff2ht1mikc0n304nog&line=0", 1066, 384));
        videoList.add(new VideoEntity("https://p98.pstatp.com/large/c0a10007f2fc822bc278.jpg",
                "https://aweme.snssdk.com/aweme/v1/playwm/?video_id=v0200f5b0000beflk4tahtm9h94n8nqg&line=0", 360, 640));
        return videoList;
    }
}
