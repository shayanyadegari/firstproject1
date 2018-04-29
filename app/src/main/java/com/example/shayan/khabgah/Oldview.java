package com.example.shayan.khabgah;

import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Oldview extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_oldview);

        Intent intent=getIntent();

        final String filename=intent.getExtras().getString("name");



        final String path = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS).toString()+"/AppDoc";

        File file=new File(path);

        File main=new File(file,filename);

        StringBuilder text=new StringBuilder();

        final String array[]=new String[40];


        int a=0;


        try {
            BufferedReader bufferedReader=new BufferedReader(new FileReader(main));

            while ((array[a] = bufferedReader.readLine()) != null) {





                Toast.makeText(this, array[a], Toast.LENGTH_SHORT).show();
                text.append('\n');
                a++;
            } } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e1) {
            e1.printStackTrace();
        }



        LinearLayout linearLayout=(LinearLayout)findViewById(R.id.oldlin);

        int f=Integer.parseInt(array[1]);



        int count2=0;
        for (int count=1;count<=a;count+=2){



            CreateChild createChild=new CreateChild();



            createChild.setshow(linearLayout,Oldview.this,array[count2],Integer.parseInt(array[count]) );

            MainActivity.counterid++;

            count2+=2;
        }


        Button button=(Button)findViewById(R.id.finalsave);
        final int finalA = a;
        final int finalA1 = a/2;



        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                File file1=new File(path);
                File text=new File(file1,filename);



                try {



                    OutputStreamWriter Writer=new OutputStreamWriter(new FileOutputStream(text,false));
                    for (int y = 0; y< finalA1; y++){

                        Writer.write(MainActivity.arr[y]+"\n");

                        Log.e("shit",MainActivity.arr[y]);

                        Log.e("shit", String.valueOf(y));

                        Writer.write(MainActivity.amount[y]+"\n");

                        Log.e("shit", String.valueOf(MainActivity.amount[y]));


                    }
                    Writer.close();



                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        });

    }

    @Override
    protected void onResume() {
        MainActivity.counterid=0;

        super.onResume();
    }
}
