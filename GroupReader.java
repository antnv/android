package com.example.nady.lesson;

import android.content.Intent;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class GroupReader extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        NestedScrollView nsv = new NestedScrollView(this);
        NestedScrollView.LayoutParams nparam = new NestedScrollView.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        setContentView(nsv, nparam);
        LinearLayout linlo = new LinearLayout(this);
        linlo.setOrientation(LinearLayout.VERTICAL);
        LinearLayout.LayoutParams lparam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        nsv.addView(linlo, lparam);

        LinearLayout.LayoutParams lsparam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams butfparam = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);


        String sp[]= getIntent().getStringArrayExtra("spisok");
        int kol= getIntent().getIntExtra("kol",1);



        Button mbutf[] = new Button[kol];
        TextView mtextmark[] = new TextView[kol];

        View.OnClickListener listenF = new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             String sp[]= getIntent().getStringArrayExtra("spisok");
             int kol= getIntent().getIntExtra("kol",1);
             Intent inmark = new Intent(GroupReader.this, setMark.class);
            String sfam;
            Button bc=(Button) view;
            sfam=bc.getText().toString();
            inmark.putExtra("sp",sp);
            inmark.putExtra("kol",kol);
            inmark.putExtra("fam",sfam);
            String markes[] = new String [30];
            startActivity(inmark);
            finish();
         }
     };



        for (int k = 0; k < kol; k++) {
            LinearLayout linlos = new LinearLayout(this);
            linlos.setOrientation(LinearLayout.HORIZONTAL);
            linlo.addView(linlos, lsparam);

            Button but = new Button(this);
            but.setText(sp[k]);
            but.setOnClickListener(listenF);
            mbutf[k] = but;
            linlos.addView(but, butfparam);

            TextView markT = new TextView(this);
            markT.setText("");
            mtextmark[k] = markT;
            linlos.addView(markT, butfparam);
            }
    }

}
