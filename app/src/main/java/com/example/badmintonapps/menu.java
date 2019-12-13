package com.example.badmintonapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
    }

    public void pengertian (View view) {
        Intent i1= new Intent(getApplicationContext(),pengertian.class);
        startActivity(i1);

    }

    public void sejarah (View view) {
        Intent i1= new Intent(getApplicationContext(),sejarah.class);
        startActivity(i1);

    }

    public void  aturan (View view) {
        Intent i1= new Intent(getApplicationContext(),aturan.class);
        startActivity(i1);

    }
    public void teknik (View view) {
        Intent i1= new Intent(getApplicationContext(),teknik.class);
        startActivity(i1);

    }
    public void tournament (View view) {
        Intent i1= new Intent(getApplicationContext(),tournament.class);
        startActivity(i1);
        Intent intent= new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://bwf.tournamentsoftware.com/"));
        startActivity(intent);

    }

    public void daftar (View view) {
        Intent i1= new Intent(getApplicationContext(),daftarr.class);
        startActivity(i1);

    }
}
