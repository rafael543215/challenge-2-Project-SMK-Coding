package com.example.myapplication

import Attributes
import CovidDataItem
import android.os.Bundle
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import androidx.annotation.Nullable
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.data.DataService
import com.example.myapplication.data.apiRequest
import com.example.myapplication.data.httpClient
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
        callApiGetCovidData()
    }

    private fun callApiGetCovidData(){
        showLoading(context!!, swipeRefreshLayout)
        val httpClient = httpClient()
        val apiRequest = apiRequest<DataService>(httpClient)
        val call = apiRequest.getAttributes()
        call.enqueue(object :Callback<List<Attributes>> {
            override fun onFailure(call: Call<List<Attributes>>, t: Throwable) {
                dissmissLoading(swipeRefreshLayout)

            }

            override fun onResponse(
                call: Call<List<Attributes>>,
                response: Response<List<Attributes>>
            ) {
                dissmissLoading(swipeRefreshLayout)
                when {
                    response.isSuccessful->
                        when{
                            response.body()?.size!=0->
                                tampilCovidData(response.body()!!)
                            else -> {
                                tampilToast(context!!,"Berhasil!")
                            }
                        }
                    else->{
                        tampilToast(context!!,"Gagal!")
                    }
                }
            }

        })
    }

    private fun tampilCovidData(covidData: List<Attributes>){
        listAttributes.layoutManager = LinearLayoutManager(context)
        listAttributes.adapter = DataAdapter(context!!,covidData){
            val covidData = it
            tampilToast(context!!, covidData.countryRegion )
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }
}
