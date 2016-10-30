package nyc.c4q.yojana.dhun;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
public TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView myRecyclerView = (RecyclerView) findViewById(R.id.songs_recycler_view);
        myRecyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        myRecyclerView.setAdapter(new SongsAdapter());


    }
}



