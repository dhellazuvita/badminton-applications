package com.example.badmintonapps;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class teknik extends AppCompatActivity {

    //Data-Data yang Akan dimasukan Pada ListView
    private String[] mahasiswa = {"Teknik Pegangan Racket (Grip)","Forehand Grip","BackhandGrip","Teknik Dasar Footwork","Teknik Dasar Service",
            "Service Forehand","Service Backhand","Flick Service","Teknik Dasar Underhand","Teknik Dasar Lob","Teknik Dasar Smash","Teknik Dasar Dropshot","Teknik Dasar Netting","Teknik Dasar Drive"};

    //ArrayList digunakan Untuk menampung Data mahasiswa
    private ArrayList<String> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teknik);
        ListView listView = findViewById(R.id.list);
        data = new ArrayList<>();
        getData();
        ArrayAdapter adapter = new ArrayAdapter<>(this, R.layout.activity_gaya_baru, data);
        listView.setAdapter(adapter);
    }

    private void getData(){
        //Memasukan Semua Data mahasiswa kedalam ArrayList
        Collections.addAll(data, mahasiswa);
    }


}


