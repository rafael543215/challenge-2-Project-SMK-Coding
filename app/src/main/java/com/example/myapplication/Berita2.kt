package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_berita2.*

class Berita2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berita2)
        ambilData()
    }
    private fun ambilData(){
        val bundle = intent.extras

        val judul2 = bundle?.getString("judul2")
        val source2 = bundle?.getString("source2")
        val kutip2 = bundle?.getString("kutip2")


        tv_judulBerita2.text = judul2
        tv_sourceBerita2.text = "Sumber Dari :  " + source2
        tv_kutipBerita2.text = "Dikutip Tanggal :  " + kutip2
    }
}
