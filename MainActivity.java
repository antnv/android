package com.example.nady.lesson;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
// загрузка списка из файла
    public void click_read(View view) {
        Intent inread=new Intent(this, ReadfileActivity.class);
        startActivity(inread);
    }


    public void click_creat(View view) {
        Intent increat= new Intent(this,WritefileActivity.class);
        startActivity(increat);
    }
// создание  и работа с временным списком
    public void click_read_but(View view) {
        Intent intent=new Intent(this, spisokCreat.class);
        startActivity(intent);
    }

    public void click_delete(View view) {
        Intent intent=new Intent(this,fileDelete.class);
        startActivity(intent);
    }

    public void FileMarksRead(View view) {
        Intent intent=new Intent(this,FileMarksReader.class);
        startActivity(intent);

    }
}
