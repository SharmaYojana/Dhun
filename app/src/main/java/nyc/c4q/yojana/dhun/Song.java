package nyc.c4q.yojana.dhun;

/**
 * Created by yojanasharma on 10/27/16.
 */

public class Song {
    private String songName;

    public Integer getResId() {
        return resId;
    }

    public String getSongName() {
        return songName;
    }

    private Integer resId;

    public Song(String songName, Integer resId) {
        this.songName = songName;
        this.resId = resId;
    }
}
