package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_berita1.*
import kotlinx.android.synthetic.main.fragment_2.*

class Berita1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berita1)


        ambilData()
    }

    private fun ambilData(){
        val bundle = intent.extras

        val judul1 = bundle?.getString("judul1")
        val source1 = bundle?.getString("source1")
        val kutip1 = bundle?.getString("kutip1")


        tv_judulBerita1.text = judul1
        tv_sourceBerita1.text = "Sumber Dari :  " + source1
        tv_kutipBerita1.text = "Dikutip Tanggal :  " + kutip1
    }
}
