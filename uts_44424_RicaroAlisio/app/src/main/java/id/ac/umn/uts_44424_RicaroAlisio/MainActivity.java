package id.ac.umn.uts_44424_RicaroAlisio;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    TextView txtNama;
    public void openLogin(View view){
        id.ac.umn.uts_44424_RicaroAlisio.loginjava loginn = new id.ac.umn.uts_44424_RicaroAlisio.loginjava();
        loginn.show(getSupportFragmentManager(), "Login");
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        txtNama = findViewById(R.id.loginNama);

        Button buttonprofile = findViewById(R.id.btnProfile);
        Button buttonlibrary = findViewById(R.id.btnLibrary);
        buttonlibrary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                openLogin(view);

            }
        });
        buttonprofile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, id.ac.umn.uts_44424_RicaroAlisio.ProfileActivity.class);
                startActivity(intent);
            }
        }

        );

    }
}