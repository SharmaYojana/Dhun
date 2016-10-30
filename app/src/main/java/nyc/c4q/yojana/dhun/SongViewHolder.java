package nyc.c4q.yojana.dhun;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;

/**
 * Created by yojanasharma on 10/27/16.
 */
public class SongViewHolder extends RecyclerView.ViewHolder {
    private final View mView;
    private final TextView mTextView;

    public SongViewHolder(ViewGroup parent) {
        super(inflate(parent));
        mView = itemView;
        mTextView = (TextView) mView.findViewById(R.id.track_name);
    }

    private static View inflate(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.song_view_holder, parent, false);
    }

    public void bind(final Song song) {
        mTextView.setText(song.getSongName());
    }

}

