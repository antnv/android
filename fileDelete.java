package com.example.nady.lesson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.io.File;

public class fileDelete extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_delete);
        ListView lv=(ListView) findViewById(R.id.listViewFile);
        String files[] = fileList();
        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,files);
        lv.setAdapter(adapter);
    }

    public void delMark(View view) {
      //  File dirf =new File(getApplicationContext().getFilesDir(),"Marks");
        deleteFile("Marks");
        ListView lv=(ListView) findViewById(R.id.listViewFile);
        String files[] = fileList();
        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,files);
        lv.setAdapter(adapter);



    }

    public void DelFile(View view) {
        EditText efn= (EditText) findViewById(R.id.editTextFileDelN);
        String FileN=efn.getText().toString();
        deleteFile(FileN);
        efn.setText("");
        ListView lv=(ListView) findViewById(R.id.listViewFile);
        String files[] = fileList();
        ArrayAdapter<String> adapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1,files);
        lv.setAdapter(adapter);
    }
}
