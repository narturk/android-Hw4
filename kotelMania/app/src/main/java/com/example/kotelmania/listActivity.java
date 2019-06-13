package com.example.kotelmania;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class listActivity extends AppCompatActivity {

    public ListView lst;
    public DBHelper dbHelper;
    private ArrayList<Note> noteList;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        noteList = new ArrayList<Note>();
//        noteList.add(new Note(1, "hello1", "world1", "send","11/06/2019"));
//        noteList.add(new Note(2, "hello2", "world2", "send","11/06/2019"));
//        noteList.add(new Note(3, "hello3", "world3", "send","11/06/2019"));
//        noteList.add(new Note(4, "hello4", "world4", "send","11/06/2019"));
//        noteList.add(new Note(5, "hello5", "world5", "send","11/06/2019"));
//        noteList.add(new Note(6, "hello6", "world6", "send","11/06/2019"));
//        noteList.add(new Note(7, "hello7", "world7", "send","11/06/2019"));
//        noteList.add(new Note(8, "hello8", "world8", "send","11/06/2019"));
//        noteList.add(new Note(9, "hello9", "world9", "send","11/06/2019"));
//        noteList.add(new Note(10, "hello10", "world10", "send","11/06/2019"));
//        noteList.add(new Note(11, "hello11", "world11", "send","11/06/2019"));
//        noteList.add(new Note(12, "hello12", "world12", "send","11/06/2019"));
//        noteList.add(new Note(13, "hello13", "world13", "send","11/06/2019"));
//        noteList.add(new Note(14, "hello14", "world14", "send","11/06/2019"));
//        noteList.add(new Note(15, "hello15", "world15", "send","11/06/2019"));


        dbHelper = DBHelper.getHelper(this);
        Cursor ret = dbHelper.getAllData();

        while(ret.moveToNext()){
            String[] columns = ret.getColumnNames();

            int id=0;
            String title="";
            String content="";
            String status="";
            String date="";

            for(int i=0; i< columns.length; i++){
                switch(i){
                    case 0: id = Integer.parseInt(ret.getString(i));
                    case 1: title = ret.getString(i);
                    case 2: content = ret.getString(i);
                    case 3: status = ret.getString(i);
                    case 4: date = ret.getString(i);
                }
            }
            Note insertNote = new Note(id,title, content, status, date);
            noteList.add(insertNote);
        }

        lst = (ListView) findViewById(R.id.NoteList);
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(),noteList);
        lst.setAdapter(customAdapter);
        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent1 = new Intent(view.getContext(), EditNote.class);
                intent1.putExtra("index", position);
                startActivityForResult(intent1, position);
            }
        });
        btn = findViewById(R.id.AddNote);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(v.getContext(), AddNote.class);
                startActivity(intent2);
            }
        });
    }
}
