package net.archeryc.douyinvideolist.entity;

/**
 * @author ArcherYc
 * @date on 2018/9/12  下午3:43
 * @mail 247067345@qq.com
 */
public class VideoEntity {

    private String coverUrl;

    private String videoUrl;

    private int width;

    private int height;

    private VideoEntity() {

    }

    public VideoEntity(String coverUrl, String videoUrl, int width, int height) {
        this.coverUrl = coverUrl;
        this.videoUrl = videoUrl;
        this.width = width;
        this.height = height;
    }

    public String getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(String coverUrl) {
        this.coverUrl = coverUrl;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
