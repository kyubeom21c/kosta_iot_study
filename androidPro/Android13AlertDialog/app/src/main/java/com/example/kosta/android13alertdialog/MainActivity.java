package com.example.kosta.android13alertdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final int DIALOG_YES_NO_MESSAGE = 1;
    private static final int DIALOG_YES_NO_LONG_MESSAGE = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button twoButtonsTitle = findViewById(R.id.two_buttons);
        twoButtonsTitle.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DIALOG_YES_NO_MESSAGE);
            }
        });

        Button twoButtons2Title = findViewById(R.id.two_buttons2);
        twoButtons2Title.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                showDialog(DIALOG_YES_NO_LONG_MESSAGE);
            }
        });

    }

    @Override
    protected Dialog onCreateDialog(int id) {

        switch (id){
            case DIALOG_YES_NO_MESSAGE :

                return new AlertDialog.Builder(this)
                        .setIconAttribute(android.R.attr.alertDialogIcon)
                        .setTitle(R.string.alert_dialog_two_buttons_title)
                        .setPositiveButton(R.string.alert_dialog_ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                Log.i("dialog","setPositiveButton");
                                /* User clicked OK so do some stuff */
                            }
                        })
                        .setNegativeButton(R.string.alert_dialog_cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                Log.i("dialog","setNegativeButton");
                                /* User clicked Cancel so do some stuff */
                            }
                        })
                        .create();
            case DIALOG_YES_NO_LONG_MESSAGE:
                return new AlertDialog.Builder(this)
                        .setIconAttribute(android.R.attr.alertDialogIcon)
                        .setTitle(R.string.alert_dialog_two_buttons_msg)
                        .setMessage(R.string.alert_dialog_two_buttons2_msg)
                        .setPositiveButton(R.string.alert_dialog_ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                Log.i("dialog","setPositiveButton");
                                /* User clicked OK so do some stuff */
                            }
                        })
                        .setNeutralButton(R.string.alert_dialog_something, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                Log.i("dialog","setNeutralButton");
                                /* User clicked Something so do some stuff */
                            }
                        })
                        .setNegativeButton(R.string.alert_dialog_cancel, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                Log.i("dialog","setNegativeButton");
                                /* User clicked Cancel so do some stuff */
                            }
                        })
                        .create();
        }


        return super.onCreateDialog(id);
    }
}
