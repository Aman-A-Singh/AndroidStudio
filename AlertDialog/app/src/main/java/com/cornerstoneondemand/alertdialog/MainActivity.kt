package com.cornerstoneondemand.alertdialog

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Dialog Title")
            .setMessage("Dialog message")
            .setPositiveButton("OK") { dialog, which ->
                // Handle positive button click
                // Do not include dialog.dismiss() here
            }
            .setNegativeButton("Cancel"){dialog,which->

            }
        val dialog = builder.create()

        dialog.setOnShowListener {
            dialog.getButton(DialogInterface.BUTTON_POSITIVE).setOnClickListener {
                // Handle positive button click
                // Do not include dialog.dismiss() here
            }
            dialog.getButton(DialogInterface.BUTTON_NEGATIVE).setOnClickListener {
                // Handle positive button click
                // Do not include dialog.dismiss() here
            }
        }

        dialog.show()

    }
}