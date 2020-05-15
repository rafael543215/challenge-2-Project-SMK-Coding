package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_1.*
import kotlinx.android.synthetic.main.fragment_3.*

/**
 * A simple [Fragment] subclass.
 */
class Fragment3 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_3, container, false)

        btn_periksaMandiri.setOnClickListener{goToGejalaActivity()}
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    }

    private fun goToGejalaActivity(){
        val intent = context!!.startIntentSender(this, GejalaActivity().intent::class.java)
        startActivity(intent)
    }
}
