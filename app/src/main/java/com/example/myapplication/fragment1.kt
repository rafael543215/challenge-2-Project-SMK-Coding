package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.data.*
import com.example.myapplication.item.CovidConfirmedItem
import com.example.myapplication.util.dissmissLoading
import com.example.myapplication.util.showLoading
import com.example.myapplication.util.tampilToast
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_1.*

/**
 * A simple [Fragment] subclass.
 */

class Fragment1 : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_1, container, false)
    }

    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        DataCountry.Session(context)
        DataCountry["Sorted"] = "Confirmed"
        ApiGetConfirm()
    }

    private fun ApiGetConfirm(){
        showLoading(context!!, swipeRefreshLayout)

        val httpClient = httpClient()
        val apiRequest = apiRequest<DataService>(httpClient, Constant.URL_covid)
        val call =  apiRequest.getRecovered()
                    apiRequest.getDeaths()
                    apiRequest.getConfirmed()

        call.enqueue(object : Callback<List<CovidConfirmedItem>>{
            override fun onFailure(call: Call<List<CovidConfirmedItem>>, t: Throwable) {
                tampilToast(context!!, "Gagal" + t.message)
                dissmissLoading(swipeRefreshLayout)
            }

            override fun onResponse(
                call: Call<List<CovidConfirmedItem>>,
                response: Response<List<CovidConfirmedItem>>
            ) {
                dissmissLoading(swipeRefreshLayout)
                when{
                    response.isSuccessful ->{
                        when {
                            response.body()?.size != 0 -> {
                                tampilData(response.body()!!)
                            }
                            else -> {
                                tampilToast(context!!, "Berhasil")
                            }
                        }
                    }
                    else -> {
                        tampilToast(context!!, "Gagal")
                    }
                }
            }
        })
    }

    private fun tampilData(body: List<CovidConfirmedItem>){
        listAttributes.layoutManager = LinearLayoutManager(context)
        listAttributes.adapter = DataAdapter1(context!!, body) {
            DataCountry.Session(context)
            DataCountry["country"] = it.countryRegion
            val intent = Intent(context, Fragment1::class.java)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }
}
