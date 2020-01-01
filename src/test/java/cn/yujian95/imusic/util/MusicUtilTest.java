package cn.yujian95.imusic.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @file: MusicUtilTest
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description:
 * @date: Created in 1/1/20  1:12 AM
 * @version: 1.0
 */
public class MusicUtilTest {

    /**
     * 音乐文件播放目录
     */
    private static final String MUSIC_FILE_PATH = "/home/yujian/Project/imusic/src/main/resource/Amy Deasismont - Heartbeats.mp3";

    @Test
    public void getMusicInfo() {
        System.out.println(MusicUtil.getMusicInfo(MUSIC_FILE_PATH));
    }
}