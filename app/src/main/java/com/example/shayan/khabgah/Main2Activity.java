package com.example.shayan.khabgah;

import android.os.Environment;
import android.support.v4.app.FragmentManager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.File;


public class Main2Activity extends AppCompatActivity {

   // private Context contx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);




        Button button=(Button)findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                   mkdl();
            }
        });



        Button button3=(Button)findViewById(R.id.save_instant);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //create dialog
                android.app.FragmentManager fragmentManager=Main2Activity.this.getFragmentManager();
                dialog_save dialog_s=new dialog_save();
                dialog_s.context=Main2Activity.this;
                dialog_s.show(fragmentManager,"dialog_save");

            }
        });

    }




    private void mkdl() {
        LinearLayout lr=(LinearLayout)findViewById(R.id.linear);
        FragmentManager manager=getSupportFragmentManager();
        dialog dl=new dialog();
        dl.cont=Main2Activity.this;
        dl.lin=lr;
        dl.show(manager,"dialog");

    }


}
