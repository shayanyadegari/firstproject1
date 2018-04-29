package com.example.shayan.khabgah;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static int counterid=0;


    public static String[] arr=new String[100];

    public static int[] amount=new int[100];

    int p;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Button newthem=(Button)findViewById(R.id.newthem);
        newthem.setOnClickListener(new View.OnClickListener() {
            @Override



            public void onClick(View v) {





                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);


            }
        });

        final Button myfle=(Button)findViewById(R.id.saveobj);
        myfle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,myfile.class);
                startActivity(intent);
            }
        });

        Button writer=(Button)findViewById(R.id.writer);
        writer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
                builder.setMessage("name:\n shayan yadegari \n email:\n shayan.13761376@gmail.com");
                builder.create();
                builder.show();
            }
        });


        Button exit=(Button)findViewById(R.id.exit);
        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();

        counterid=0;
        Log.e("jj","shit is here");
    }
}
