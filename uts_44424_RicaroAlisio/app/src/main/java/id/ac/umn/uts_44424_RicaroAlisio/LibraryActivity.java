package id.ac.umn.uts_44424_RicaroAlisio;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class LibraryActivity extends AppCompatActivity {
    TextView txt;
    RecyclerView recyclerView;
    ArrayList<Video> videoList = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.library);

        Intent intent = getIntent();
        String new_name = intent.getStringExtra(id.ac.umn.uts_44424_RicaroAlisio.loginjava.EXTRA_NAME);
        Toast.makeText(getApplicationContext(),"Welcome, "+new_name, Toast.LENGTH_SHORT).show();
        getSupportActionBar().setTitle("Hello, "+new_name);
        seedVideo();
        recyclerView = findViewById(R.id.recyclerView);
        Video1 videoAdapter = new Video1(this, videoList);
        recyclerView.setAdapter(videoAdapter);
        videoAdapter.setOnItemClickListener(new Video1.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                videoList.remove(position);
                videoAdapter.notifyItemRemoved(position);
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


    }
    public void seedVideo() {
        videoList.add(new Video("Video Kuda", "Kuda Berlari Heyy Heyyy", "https://www.youtube.com/watch?v=a3ICNMQW7Ok" , R.raw.videokuda));
        videoList.add(new Video("Video Molekul", "Molekul Bergerak gerak everybody", "https://www.youtube.com/watch?v=K4TOrB7at0Y",  R.raw.videomolekul));

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_option, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item){
        switch(item.getItemId()){
            case R.id.menu_profile:
                Intent intent = new Intent(LibraryActivity.this, id.ac.umn.uts_44424_RicaroAlisio.ProfileActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_main:
                Intent intent1 = new Intent(LibraryActivity.this, MainActivity.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
