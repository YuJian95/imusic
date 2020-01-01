package cn.yujian95.imusic.model;

import java.io.Serializable;
import java.util.Objects;


/**
 * @file: Music
 * @author: <a href="https://yujian95.cn/about/">YuJian</a>
 * @description: 音乐信息实体类
 * @date: Created in 1/1/20  1:04 AM
 * @version: 1.0
 */

public class Music implements Serializable {

    /**
     * 音乐编号
     */
    private int id;
    /**
     * 音乐名称
     */
    private String name;
    /**
     * 歌手名称
     */
    private String singer;
    /**
     * 专辑名称
     */
    private String album;
    /**
     * 播放时长
     */
    private int duration;
    /**
     * 音乐文件存放路径
     */
    private String path;

    public Music() {

    }

    public Music(String name, String singer, String album, int duration, String path) {
        this.name = name;
        this.singer = singer;
        this.album = album;
        this.duration = duration;
        this.path = path;
    }

    public Music(int id, String name, String singer, String album, int duration, String path) {

        this.id = id;
        this.name = name;
        this.singer = singer;
        this.album = album;
        this.duration = duration;
        this.path = path;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Music)) {
            return false;
        }
        Music music = (Music) o;
        return getId() == music.getId() &&
                getDuration() == music.getDuration() &&
                getName().equals(music.getName()) &&
                getSinger().equals(music.getSinger()) &&
                getAlbum().equals(music.getAlbum()) &&
                getPath().equals(music.getPath());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getSinger(), getAlbum(), getDuration(), getPath());
    }
}