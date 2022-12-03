package id.ac.umn.uts_44424_RicaroAlisio;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class VideoPropertiesActivit extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_det_xml);
        TextView judul, deskripsi, link;
        VideoView vv;
        vv = (VideoView) findViewById(R.id.thumbnail);
        Video v;
        Intent intent = getIntent();
        v = (Video) intent.getSerializableExtra("video");
        Uri u;
        u = Uri.parse("android.resource://" + getPackageName() + "/" + v.getUri());
        MediaController media;
        media = new MediaController(this);
        media.setMediaPlayer(vv);
        vv.setMediaController(media);
        vv.setVideoURI(u);
        vv.start();
        judul = findViewById(R.id.title);
        judul.setText(v.getJudul());

        deskripsi= findViewById(R.id.description);
        deskripsi.setText(v.getDesc());

        link = findViewById(R.id.resource);
        link.setText(v.getLink());


    }
}

