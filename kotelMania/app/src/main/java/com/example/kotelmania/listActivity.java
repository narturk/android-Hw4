package com.example.kotelmania;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class listActivity extends AppCompatActivity {

    ListView lst;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        lst = (ListView) findViewById(R.id.NoteList);
        ArrayAdapter<T> arrayAdapter = new ArrayAdapter<T>()

    }
}
