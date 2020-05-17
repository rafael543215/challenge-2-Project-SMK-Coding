package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.data.*
import com.example.myapplication.item.Article
import com.example.myapplication.item.BeritaCovid
import com.example.myapplication.util.dissmissLoading
import com.example.myapplication.util.showLoading
import com.example.myapplication.util.tampilToast
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.activity_berita1.*
import kotlinx.android.synthetic.main.fragment_1.*
import kotlinx.android.synthetic.main.fragment_2.*
import kotlinx.android.synthetic.main.fragment_3.*
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback
import retrofit2.http.Body

/**
 * A simple [Fragment] subclass.
 */
class Fragment2 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        click_news1.setOnClickListener {
            val intent = Intent (view.context, Berita1::class.java)
            val  bundle = Bundle()
            bundle.putString("judul1", judul1)
            bundle.putString("source1", source1)
            bundle.putString("kutip1", kutip1)


            intent.putExtras(bundle)
            startActivity(intent)
        }
        click_news2.setOnClickListener {
            val intent = Intent (view.context, Berita2::class.java)
            val  bundle = Bundle()
            bundle.putString("judul2", judul2)
            bundle.putString("source2", source2)
            bundle.putString("kutip2", kutip2)


            intent.putExtras(bundle)
            startActivity(intent)
        }
        click_news3.setOnClickListener {
            val intent = Intent (view.context, Berita3::class.java)
            val  bundle = Bundle()
            bundle.putString("judul3", judul3)
            bundle.putString("source3", source3)
            bundle.putString("kutip3", kutip3)


            intent.putExtras(bundle)
            startActivity(intent)
        }
    }


    private var judul1 : String = "Berita 1 Covid"
    private var source1 : String = "Seputar Putar Indonesia"
    private var kutip1 : String = "17/05/2020"
    private var judul2 : String =  "Berita 2 Covid"
    private var source2 : String = "Liputan 5 Subuh"
    private var kutip2 : String =  "16/05/2020"
    private var judul3 : String = "Berita 3 Covid"
    private var source3 : String = "Buletin Bumi Bundar"
    private var kutip3 : String = "15/05/2020"


        /*
        private fun callBeritaIndonesia(){
            showLoading(context!!, swipeRefreshLayout)

            val httpClient = httpClient()
            val apiRequest = apiRequest<DataService>(httpClient, Constant.url_newsApi)
            val call = apiRequest.getNews("id", "health", Constant.token_newsApi)
            call.enqueue(object : Callback<BeritaCovid>{
                override fun onFailure(call: Call<BeritaCovid>, t: Throwable) {
                    tampilToast(context!!, "Gagal!")
                    dissmissLoading(swipeRefreshLayout)
                }

                override fun onResponse(call: Call<BeritaCovid>, response: Response<BeritaCovid>) {
                    dissmissLoading(swipeRefreshLayout)

                    when{
                        response.isSuccessful->{
                            tampilData(response.body()!!.articles)
                        }
                        else->{
                            tampilToast(context!!, "Gagal")
                        }
                    }
                }
            })
            }
        private fun tampilData(list: List<Article>) {
            listBerita.layoutManager = LinearLayoutManager(context)
            listBerita.adapter = DataAdapter2(context!!, list){
                DataCountry.Session(context)
                DataCountry["urlNews"] = it.url
                DataCountry["source"] = it.source.name
                val intent = Intent(context, DetailBeritaActivity::class.java)
                startActivity(intent)
            }
        }

        override fun onDestroy() {
            super.onDestroy()
            this.clearFindViewByIdCache()
        }
    */
}
