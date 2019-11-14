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
        videoList.add(new VideoEntity("https://p1.pstatp.com/large/tos-cn-p-0015/a6de53f…_1571919762.jpg",
                "https://aweme.snssdk.com/aweme/v1/playwm/?s_vid=93f1b41336a8b7a442dbf1c29c6bbc5676b1fb0871e913368e93f9d55ca170a4948bd4794c23134dc8bbd12c6d8556e9a524587af82c9feff62abaec9b276785&line=0", 1066, 384));
        videoList.add(new VideoEntity("https://p1.pstatp.com/large/tos-cn-p-0015/3d87d5b084fb41a6b8059519de76e9cb_1572838860.jpg",
                "https://aweme.snssdk.com/aweme/v1/playwm/?s_vid=93f1b41336a8b7a442dbf1c29c6bbc56f0b557626abd3fd7599a871310d6df211dc974af61c6c577fe934e431659c2e907821064cb46c85e503527e8202af25e&line=0", 720, 1280));
        return videoList;
    }
}
