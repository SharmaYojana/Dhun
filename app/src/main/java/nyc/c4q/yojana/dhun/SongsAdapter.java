package nyc.c4q.yojana.dhun;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yojanasharma on 10/27/16.
 */
public class SongsAdapter extends RecyclerView.Adapter {

    List<Song> songList = Arrays.asList(
            new Song("Pal Aaucha Pal Janchha by Hemanta Rana...", R.raw.track_11),
            new Song("Gayo Maya Gayo by Amit Babu Rokaya, Kastup Bista & Tulsi Gharti...", R.raw.track_4),
            new Song("Yi Nayan Le Timro Muhar by Nabin K. Bhattarai...", R.raw.track_5),
            new Song("Timi Malai Bhulideu by Adrin Pradhan...", R.raw.track_1),
            new Song("Timilai Dekhera by Yash Kumar...", R.raw.track_7),
            new Song("Hausala Buland Bhaidinchaa (Gajal) by Shiv Pariyar...", R.raw.track_8),
            new Song("Ma Ta Roye Roye by Jaljala Pariyar...", R.raw.track_9),
            new Song("Jadai chhu by Sugam Pokhrel...", R.raw.track_6)
    );

    Context context;
    MediaPlayer mediaPlayer = new MediaPlayer();
    ImageButton playButton;
    int lastPlayed;


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        return new SongViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SongViewHolder vh = (SongViewHolder) holder;
        final Song song = songList.get(position);
        vh.bind(song);
        playButton = (ImageButton) holder.itemView.findViewById(R.id.on_click);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(mediaPlayer.isPlaying()){
                   mediaPlayer.pause();
               }else{
                   playSample(song.getResId());
               }
            }
        });
        vh.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }

    @Override
    public int getItemCount() {
        return songList.size();
    }
    private void playSample(int resid) {
        AssetFileDescriptor afd = context.getResources().openRawResourceFd(resid);

        try {
                mediaPlayer.reset();
                mediaPlayer.setDataSource(afd.getFileDescriptor(), afd.getStartOffset(), afd.getDeclaredLength());
                mediaPlayer.prepare();
                mediaPlayer.start();
            afd.close();

        } catch (IllegalArgumentException e) {
            Log.e("MediaPlayer", "Unable to play audio queue do to exception: " + e.getMessage(), e);
        } catch (IllegalStateException e) {
            Log.e("MediaPlayer", "Unable to play audio queue do to exception: " + e.getMessage(), e);
        } catch (IOException e) {
            Log.e("MediaPlayer", "Unable to play audio queue do to exception: " + e.getMessage(), e);
        }
    }
}
