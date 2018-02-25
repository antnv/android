package com.example.nady.lesson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.io.File;

public class setMark extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_mark);
        String fam=getIntent().getStringExtra("fam");
        TextView textfam=(TextView) findViewById(R.id.textViewFam);
        textfam.setText(fam);

    }

    public void send_mark(View view) {
        Button but =(Button) view;
        String m=but.getText().toString();
        String fam=getIntent().getStringExtra("fam");
        String sp[]= getIntent().getStringArrayExtra("sp");
        int kol= getIntent().getIntExtra("kol",1);
        Spisok spis=new Spisok();
        spis.setChildes(sp,kol);

        //удаление из списка и запись в файл
        String fname="Marks";
        File mfile=new File(getApplicationContext().getFilesDir(),fname);
        spis.delfam(fam, m,mfile);

              //Log.d("NNNNNNNVVVVVV",fam);
        sp=spis.getChildes();
        int kolm=spis.getkol();
        Intent intentm;
        if (kolm==0){
               intentm=new Intent(this, MainActivity .class);
        }
        else {
               intentm = new Intent(this, GroupReader.class);
            intentm.putExtra("spisok", sp);
            intentm.putExtra("kol", kolm);
        }

        startActivity(intentm);
        finish();
    }
}
