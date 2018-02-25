package com.example.nady.lesson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.io.File;


public class ReadfileActivity extends AppCompatActivity {
    Spisok group=new Spisok();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.readfile);
    }
    public void LdFile(View view) {
        EditText fn=(EditText) findViewById(R.id.editTextF);
        String fns=fn.getText().toString();
        File dirf =new File(getApplicationContext().getFilesDir(),fns);
        group.loadFile(dirf);
        Intent intent= new Intent(this, GroupReader.class);
        String sp[]=group.getChildes();
        intent.putExtra("spisok", sp);
        int kol=group.getkol();
        intent.putExtra("kol",kol);
        startActivity(intent);
        finish();


    }
}
