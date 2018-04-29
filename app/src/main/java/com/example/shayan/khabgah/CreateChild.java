package com.example.shayan.khabgah;


import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.os.Environment;
import android.provider.Settings;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Space;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class CreateChild {


    public int countere=0;

    public int countert=1;



    private TextView textView;

    private     SeekBar seekBar;

     private     EditText editText;

    public void setshow(LinearLayout lr, final Context context, final String dialog,

                        int x) {

//find item by test 2 and then save them va baraye mavared mokhtalef file joda bezan

        seekBar=new SeekBar(context);

        seekBar.setProgress(x);

        editText=new EditText(context);

        editText.setText(String.valueOf(x));

        editText.setId(countere);


        set_widget(seekBar,editText,lr,context,dialog);



        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pross=0;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                pross =progress;


            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

                editText.setText(String.valueOf(pross));


            }
        });


        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }



            @Override
            public void afterTextChanged(Editable s) {

                try{
                    //Update Seekbar value after entering a number
                    int sbar=Integer.parseInt(s.toString());


                  //  Log.e("ggg", String.valueOf(editText.getId()));

                    Log.e("id", String.valueOf(editText.getId()));
                    Log.e("dialog",dialog);
                    Log.e("valiu", String.valueOf(sbar));

                    MainActivity.arr[editText.getId()]=dialog;
                    MainActivity.amount[editText.getId()]=sbar;






                    seekBar.setProgress(sbar);
                } catch(Exception ex) {


                }


            }
        });
    }





    @SuppressLint("ResourceAsColor")
    private void set_widget(SeekBar seekBar, EditText editText,
                            LinearLayout lr, Context context, String dialog) {



        textView=new TextView(context);




        editText.setBackgroundColor(0);

     //   seekBar.setPadding(20,0,60,0);



   //     editText.setPadding(0,0,30,0);

        textView.setPadding(10,35,0,0);
        Button b=new Button(context);


        textView.setTextSize(20);

        editText.setId(MainActivity.counterid);

        lr.setBackgroundColor(4);


        String g= String.valueOf(textView.getId());



        LinearLayout linearLayout=new LinearLayout(context);
        linearLayout.setGravity(Gravity.CENTER);

        linearLayout.isHorizontalScrollBarEnabled();

        Space space=new Space(context);

        linearLayout.setBackgroundColor(R.color.items);

        LinearLayout.LayoutParams pr=new LinearLayout.LayoutParams(

                LinearLayout.LayoutParams.MATCH_PARENT,

                LinearLayout.LayoutParams.WRAP_CONTENT);

        lr.addView(linearLayout,pr);

        lr.addView(space,5,10);

        textView.setText(dialog);


            TextView vv=new TextView(context);

            vv.setText("fd");
        linearLayout.addView(textView,200,150);
      //  linearLayout.addView(vv,200,150);

        linearLayout.addView(seekBar,700,150);

        linearLayout.addView(editText,150,150);




    }




}
