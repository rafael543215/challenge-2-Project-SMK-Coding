package com.example.myapplication

fun main(args:Array<String>){

    print("Masukkan Banyak gejala yang anda alami : ")
    var pilih: Int = readLine()!!.toInt()

    if(pilih > 2){
        println("Anda mungkin harus segera pergi ke dokter untuk konsultasi lebih lanjut")
    }else {
        println("Anda masih aman, tapi jika gejala bertambah segera lakukan tindakan yaa #StayHome ")
    }


}