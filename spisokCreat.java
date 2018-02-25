package com.example.nady.lesson;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.EditText;

public class spisokCreat extends AppCompatActivity {

    private static final String TAG ="NV" ;
    Spisok group=new Spisok();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.spisok_creat);
        group.onCreate();
    }


    public void readChild(View view) {

        EditText famEd=(EditText)findViewById(R.id.editTextSp);
        EditText gr=(EditText) findViewById(R.id.editTextGr);
        String grfam=gr.getText().toString()+"  "+famEd.getText().toString();
        group.addChild(grfam);
        famEd.setText("");

    }

    public void all_child(View view) {
         Intent intent= new Intent(this, GroupReader.class);
         String sp[]=group.getChildes();
         intent.putExtra("spisok", sp);
         int kol=group.getkol();
         intent.putExtra("kol",kol);
         startActivity(intent);
         finish();
    }
}
