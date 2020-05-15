package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_gejala.*
import kotlinx.android.synthetic.main.dialog_negatif.view.*
import kotlinx.android.synthetic.main.dialog_positif.view.*
import java.lang.reflect.Array

class GejalaActivity : AppCompatActivity() {

    val pilihan = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gejala)

        btn_submitGejala.setOnClickListener { pilihanGejala() }
    }

    private fun pilihanGejala(){
        if (pilihan > 2){
                val mDialogPositif = LayoutInflater.from(this).inflate(R.layout.dialog_positif, null)
                val mBuilder = AlertDialog.Builder(this)
                    .setView(mDialogPositif)
                    .setTitle("Positif")
                val mAlertDialog = mBuilder.show()
                mDialogPositif.btn_dialogPositif.setOnClickListener {
                    mAlertDialog.dismiss() }
        }else {
            val mDialogNegatif = LayoutInflater.from(this).inflate(R.layout.dialog_negatif, null)
            val mBuilder = AlertDialog.Builder(this)
                .setView(mDialogNegatif)
                .setTitle("Negatif")
            val mAlertDialog = mBuilder.show()
            mDialogNegatif.btn_dialogNegatif.setOnClickListener {
                mAlertDialog.dismiss() }
        }
    }

     private fun pilih1() {

        val logika1 = 0

        while (logika1 >= 2)
            radioGroup1.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId == R.id.radioButton1)
                logika1 + 1
        }
        radioGroup2.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId == R.id.radioButton3)
                logika1 + 1
        }
        radioGroup3.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId == R.id.radioButton5)
                logika1 + 1
        }
        radioGroup4.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId == R.id.radioButton7)
                logika1 + 1
        }
        radioGroup5.setOnCheckedChangeListener { group, checkedId ->
            if(checkedId == R.id.radioButton9)
                logika1 + 1
        }
         setResult(logika1)
    }


}

