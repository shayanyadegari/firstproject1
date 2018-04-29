package com.example.shayan.khabgah;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class myfile extends AppCompatActivity {



    @SuppressLint({"ClickableViewAccessibility", "ResourceAsColor"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myfile);

        String j;
        Log.e("tag",Environment.getExternalStorageDirectory().toString());
      //  try {

         //  FileInputStream fileInputStream=new FileInputStream(new File(Environment.getExternalStoragePublicDirectory(Environment
           //         .DIRECTORY_DOCUMENTS)+"/AppDoc/aaa.txt"));

      //      InputStreamReader inputStreamReader=new InputStreamReader(fileInputStream);
          //  BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
            String recives="";
            StringBuilder stringBuilder=new StringBuilder();
         //   while ((recives=bufferedReader.readLine())!=null){
                stringBuilder.append(recives+"\n");
         //   }
       //     fileInputStream.close();
        //   j=stringBuilder.toString();
        //    Toast.makeText(this,j , Toast.LENGTH_SHORT).show();


            String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString()+"/AppDoc";//list file ha
            Log.e("Files", "Path: " + path);
            File directory = new File(path);
            final File[] files = directory.listFiles();

        if (files==null){
            AlertDialog.Builder a=new AlertDialog.Builder(this);
            a.setMessage("cant find any file");
            a.create();
            a.show();

        }
        else {
            Log.e("Files", "Size: " + files.length);

            LinearLayout linearLayout1 = (LinearLayout) findViewById(R.id.myfilelyout);

            ScrollView scrollView = new ScrollView(myfile.this);

            LinearLayout linearLayout = new LinearLayout(myfile.this);

            linearLayout1.addView(scrollView, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);

            scrollView.addView(linearLayout, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);




            for ( int i= 0; i< files.length; i++) {
                //   Log.e("Files", "FileName:" + files[i].getName());

                Button button = new Button(myfile.this);

                LinearLayout linearLayout2=new LinearLayout(myfile.this);
                button.setText(files[i].getName());
                button.setId(i);
                LinearLayout.LayoutParams pr=new LinearLayout.LayoutParams(

                        LinearLayout.LayoutParams.MATCH_PARENT,

                        LinearLayout.LayoutParams.WRAP_CONTENT);
                linearLayout.setBackgroundColor(R.color.items);
                linearLayout.addView(button, pr);

                linearLayout.setOrientation(LinearLayout.VERTICAL);


            }


            for (int i = 0; i < files.length; i++) {
                Button button = (Button) findViewById(i);


                final int finalI = i;
                Log.e("irt", String.valueOf(finalI));
                button.setOnTouchListener(new View.OnTouchListener() {
                    @Override
                    public boolean onTouch(View v, MotionEvent event) {


                        //   Toast.makeText(myfile.this, String.valueOf(finalI), Toast.LENGTH_SHORT).show();


                        final Button button1 = (Button) findViewById(finalI);

                        button1.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {

                                String filename = button1.getText().toString();


                                Intent intent = new Intent(myfile.this, Oldview.class);

                                intent.putExtra("name", filename);

                                startActivity(intent);
                            }
                        });


                        return false;
                    }
                });


            }


        }





    }
}
