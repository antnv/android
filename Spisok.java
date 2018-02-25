package com.example.nady.lesson;


import android.content.Context;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
//import java.io.PrintWriter;
//import java.io.StringReader;
import java.io.StringWriter;

public class Spisok {
    String childes[] =new String[30];
    int kol;

   void  onCreate(){
       kol=0;
    }

    public void addChild(String child) {
        childes[kol]=child;
        kol++;
    }

    public int getkol(){
       return kol;
    }

    public String[] getChildes() {
        return childes;
    }

    public  void setChildes(String[] mas, int kolp){
        kol=kolp;
        for (int i=0;i<kol;i++){
               childes[i]=mas[i];
          }
    }

   public void delfam(String sfam,String m,File mfile) {
    // запись в файл  группы,фамилии и оценки
          try{

           FileWriter f = new FileWriter(mfile,true);
           StringWriter fout = new StringWriter();
           fout.write(sfam+"  "+m+"/n");
           f.write(fout.toString());
           fout.close();
           f.close();
       } catch (IOException e) {
           e.printStackTrace();
       }

        for (int i = 0; i < kol; i++) {
           if (sfam.equals( childes[i])) {
               for (int j = i; j < kol-1; j++) {
                   childes[j] = childes[j + 1];
                  };
               kol--;
           }
       }

   }



    public void loadFile(File df){
        try {
            FileReader f =new FileReader(df);
            BufferedReader br=new BufferedReader(f);
         //   StringReader fin=new StringReader(br.readLine());

            String s="";
            kol=0;
            s=br.readLine();
            for (String si:s.split("/n"))
               {  childes[kol]=si;
                     kol++;
               }
         }
         catch (IOException e) {

        }
    }

    public  void writefile(File df)  {
        try
        {

                FileWriter f = new FileWriter(df);
                StringWriter fout = new StringWriter();
                for (int k = 0; k < kol; k++) {
                    fout.write(childes[k]+"/n");
                }
                f.write(fout.toString());
                f.close();
                fout.close();
        }
        catch (IOException e){
                            }
        }
}

