package com.example.shayan.khabgah;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;

import android.os.Bundle;

import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;

public class dialog extends DialogFragment{


    private  EditText editText;

    public LinearLayout lin;
    public Context cont;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();


        View view=inflater.inflate(R.layout.fragment_dialog,null);
        editText=view.findViewById(R.id.editText);
        builder.setView(view)
                // Add action buttons
                .setPositiveButton("create", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {





                        String username=editText.getText().toString();

                        CreateChild createChild=new CreateChild();



                        createChild.setshow(lin,cont,username,0);

                        MainActivity.counterid+=1;


                    }
                });



        return builder.create();
    }








}
