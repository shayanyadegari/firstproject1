package com.example.shayan.khabgah;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 * Created by shayan on 3/29/2018.
 */

public class dialog_save extends DialogFragment {

    private EditText editText;

    public Context context;



    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {



        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();


        builder.setMessage("enter user id");

        View view=inflater.inflate(R.layout.dialog_ssave,null);
        editText =view.findViewById(R.id.dialedit);
        builder.setView(view)
                // Add action buttons
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @RequiresApi(api = Build.VERSION_CODES.O)
                    @Override
                    public void onClick(DialogInterface dialog, int id) {



                    File file=new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS)+"/AppDoc");



                    if(!file.exists()) {
                        file.mkdirs();
                        Log.e("tag","create");

                    }
                    Log.e("tag",Environment.getExternalStorageDirectory().toString());
                    File text=new File(file,editText.getText().toString());

                        try {


                            OutputStreamWriter outputStreamWriter=new OutputStreamWriter(new FileOutputStream(text,false));



                            for (int cnt=0;cnt<MainActivity.counterid;cnt++){

                                outputStreamWriter.write(MainActivity.arr[cnt]+"\n");
                                outputStreamWriter.write(MainActivity.amount[cnt]+"\n");

                            }
                            outputStreamWriter.close();










                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        } catch (IOException e) {
                            e.printStackTrace();
                        }


                    }
                });



        return builder.create();

    }


}
