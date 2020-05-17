package com.example.myapplication

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_gejala.*
import kotlinx.android.synthetic.main.dialog_negatif.view.*
import kotlinx.android.synthetic.main.dialog_positif.view.*


class GejalaActivity : AppCompatActivity() {

    var pilihan : Int? = 0
    val angka : Int? = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gejala)

        btn_submitGejala.setOnClickListener { pilihanGejala()
            if (pilihan == 1){
                val mDialogNegatif = LayoutInflater.from(this).inflate(R.layout.dialog_negatif, null)
                val mBuilder = AlertDialog.Builder(this)
                    .setView(mDialogNegatif)
                    .setTitle("Negatif")
                val mAlertDialog = mBuilder.show()
                mDialogNegatif.btn_dialogNegatif.setOnClickListener {
                    mAlertDialog.dismiss()
                }
            }else {
                val mDialogPositif = LayoutInflater.from(this).inflate(R.layout.dialog_positif, null)
                val mBuilder = AlertDialog.Builder(this)
                    .setView(mDialogPositif)
                    .setTitle("Positif")
                val mAlertDialog = mBuilder.show()
                mDialogPositif.btn_dialogPositif.setOnClickListener {
                    mAlertDialog.dismiss()
                }
            }
        }
    }

    private fun pilihanGejala(){

        var i = pilihan
        while (pilihan == i) {
            radioGroup1.setOnCheckedChangeListener { group, checkedId ->
                if (checkedId == R.id.radioButton1)
                    pilihan = pilihan?.inc()
            }
            radioGroup2.setOnCheckedChangeListener { group, checkedId ->
                if (checkedId == R.id.radioButton3)
                    pilihan = pilihan?.inc()
            }
            radioGroup3.setOnCheckedChangeListener { group, checkedId ->
                if (checkedId == R.id.radioButton5)
                    pilihan = pilihan?.inc()
            }
            radioGroup4.setOnCheckedChangeListener { group, checkedId ->
                if (checkedId == R.id.radioButton7)
                    pilihan = pilihan?.inc()
            }
            radioGroup5.setOnCheckedChangeListener { group, checkedId ->
                if (checkedId == R.id.radioButton9)
                    pilihan = pilihan?.inc()
            }
        }

    }


}
