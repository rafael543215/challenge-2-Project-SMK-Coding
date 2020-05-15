package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_gejala.*
import kotlinx.android.synthetic.main.dialog_negatif.view.*
import kotlinx.android.synthetic.main.dialog_positif.view.*

class GejalaActivity : AppCompatActivity() {

    var pilihan = 2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gejala)

        btn_submitGejala.setOnClickListener { pilihanGejala() }
    }

    private fun pilih1(){

    }

    private fun tampilToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
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
}
