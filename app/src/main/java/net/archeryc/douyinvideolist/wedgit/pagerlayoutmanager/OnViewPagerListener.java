package net.archeryc.douyinvideolist.wedgit.pagerlayoutmanager;

/**
 * Created by 钉某人
 * github: https://github.com/DingMouRen
 * email: naildingmouren@gmail.com
 * 用于ViewPagerLayoutManager的监听
 *
 * @author yc
 */

public interface OnViewPagerListener {


    /**
     * 初始化第一个View
     */
    void onInitComplete();


    /**
     * 选中的监听以及判断是否滑动到底部
     *
     * @param position
     * @param isBottom
     */
    void onPageSelected(int position, boolean isBottom);


    /**
     * 释放的监听
     *
     * @param isNext
     * @param position
     */
    void onPageRelease(boolean isNext, int position);
}
