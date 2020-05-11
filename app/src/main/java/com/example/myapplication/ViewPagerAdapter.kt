package com.example.myapplication

import android.content.Context
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity){

    private val jumlah_menu = 3

    override fun createFragment(position: Int): Fragment {
        when(position){
            0-> {return fragment_1()}
            1-> {return fragment_2()}
            2 -> {return fragment_3()}
            else ->{
                return fragment_1()
            }
        }
    }

    override fun getItemCount(): Int {
        return jumlah_menu
    }
}