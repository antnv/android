package com.example.nady.lesson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileMarksReader extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_marks_reader);
        String fname="Marks";
        ArrayList<String> allmarks=new ArrayList<String>();
        try{
        File fmarks=new File(getApplicationContext().getFilesDir(),fname);

        FileReader f = new FileReader(fmarks);
        BufferedReader br=new BufferedReader(f);
        //   StringReader fin=new StringReader(br.readLine());

        String s="";
        int k=0;
        s=br.readLine();
        for (String si:s.split("/n"))
        {
            allmarks.add(si);
            k++;
        }
         }
         catch (IOException e) {

            }

        ListView listmarks =(ListView) findViewById(R.id.listViewAllMarks);

        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, allmarks);
        listmarks.setAdapter(adapter);
    }
}
