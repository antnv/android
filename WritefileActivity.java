package com.example.nady.lesson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import java.io.File;

public class WritefileActivity extends AppCompatActivity {
    Spisok group=new Spisok();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.writefile);
    }

    public void ClickCreat(View view) {
        EditText famEd= (EditText) findViewById(R.id.editTextFam);
        EditText gr=(EditText) findViewById(R.id.editTextGr);
        String grfam=gr.getText().toString()+"  "+famEd.getText().toString();
        group.addChild(grfam);
        famEd.setText("");
    }

    public void InputFile(View view) {

        EditText famEd= (EditText) findViewById(R.id.editTextFam);
        EditText gr=(EditText) findViewById(R.id.editTextGr);
        EditText fileEd =(EditText) findViewById(R.id.editTextFile);
        String filen=fileEd.getText().toString();
        File dirf =new File(getApplicationContext().getFilesDir(),filen);
        if  (!filen.equals("")){
             group.writefile(dirf);
             Intent  intent=new Intent(this,MainActivity.class);
             startActivity(intent);
            finish();
        }

    }


}
