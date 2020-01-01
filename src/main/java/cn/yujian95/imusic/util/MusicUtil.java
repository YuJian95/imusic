package cn.yujian95.imusic.util;

import cn.yujian95.imusic.model.Music;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.mp3.MP3AudioHeader;
import org.jaudiotagger.audio.mp3.MP3File;
import org.jaudiotagger.tag.id3.ID3v23Frame;

import java.io.File;

/**
 * @file: MusicUtil
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 音乐相关工具方法
 * @date: Created in 1/1/20  1:05 AM
 * @version: 1.0
 */

class MusicUtil {

    private static final String SONG_NAME_KEY = "TIT2";
    private static final String ARTIST_KEY = "TPE1";
    private static final String ALBUM_KEY = "TALB";

    /**
     * 通过歌曲文件地址, 获取歌曲信息
     *
     * @param filePath 歌曲文件地址
     * @return 歌曲信息
     * @throws Exception 可能抛出空指针异常
     */
    static Music getMusicInfo(String filePath) throws Exception {

        Music music = null;

        try {

            MP3File mp3File = (MP3File) AudioFileIO.read(new File(filePath));

            MP3AudioHeader audioHeader = (MP3AudioHeader) mp3File.getAudioHeader();

            // 歌曲名称
            String songName = getInfoFromFrameMap(mp3File, SONG_NAME_KEY);
            // 歌手名称
            String artist = getInfoFromFrameMap(mp3File, ARTIST_KEY);
            // 歌曲专辑
            String album = getInfoFromFrameMap(mp3File, ALBUM_KEY);
            // 播放时长
            int duration = audioHeader.getTrackLength();

            // 封装到music对象
            music = new Music(songName, artist, album, duration, filePath);

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("文件读取失败！" + e);
        }

        return music;
    }

    /**
     * 通过键值,获取歌曲中对应的字段信息
     *
     * @param mp3File mp3音乐文件
     * @param key     键值
     * @return 歌曲信息
     * @throws Exception 可能抛出空指针异常
     */
    private static String getInfoFromFrameMap(MP3File mp3File, String key) throws Exception {
        ID3v23Frame frame = (ID3v23Frame) mp3File.getID3v2Tag().frameMap.get(key);
        return frame.getContent();
    }
}
