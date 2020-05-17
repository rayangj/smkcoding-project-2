package com.example.pantaucorona

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.pantaucorona.data.*
import com.example.pantaucorona.util.dismissLoading
import com.example.pantaucorona.util.showLoading
import com.example.pantaucorona.util.tampilToast
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_home.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home,container, false)
    }
    override fun onViewCreated(view: View,@Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callApiGetGithubUser()
        callApiGetGithubUser2()
    }

    private fun tampilApiInd(IndonesiaApis : List<IndonesiaApiItem>) {
        val response = IndonesiaApis[0]
        txtSembuhI.setText(" : ${response.sembuh} Sembuh")
        txtPositifI.setText(" : ${response.positif} Positif")
        txtMeninggalI.setText(" : ${response.meninggal} Meninggal")
    }
    private fun tampilApiSembuh(GlobalSembuh : List<GlobalSembuhApiItem>){
        val response = GlobalSembuh[0]
        txtSembuhG.setText(" : ${response.totalRecovered} Sembuh")
    }
    private fun tampilApiPositif(GlobalPositif : List<GlobalPositifApiItem>) {
        val response = GlobalPositif[0]
        txtPositifG.setText(" : ${response.totalConfirmed} Positif")
    }
    private fun tampilApiMeninggal(GlobalMeninggal : List<GlobalMeninggalApiItem>) {
        val response = GlobalMeninggal[0]
        txtMeninggalG.setText(" : ${response.totalDeaths} Meninggal")
    }

    private fun callApiGetGithubUser() {
        showLoading(context!!, swipeRefreshLayoutInd)
        val httpClient = httpClient()
        val apiRequest = apiRequest<IndonesiaService>(httpClient)
        val call = apiRequest.getUsers()
        call.enqueue(object : Callback<List<IndonesiaApiItem>> {
            override fun onFailure(call: Call<List<IndonesiaApiItem>>, t: Throwable) {
                dismissLoading(swipeRefreshLayoutInd)
            }
            override fun onResponse(call: Call<List<IndonesiaApiItem>>, response:
            Response<List<IndonesiaApiItem>>
            ) {
                dismissLoading(swipeRefreshLayoutInd)
                when {
                    response.isSuccessful ->
                        when {
                            response.body()?.size != 0 ->
                                tampilApiInd(response.body()!!)
                            else -> {
                                tampilToast(
                                    context!!,
                                    "Berhasil"
                                )
                            }
                        }
                    else -> {
                        tampilToast(
                            context!!,
                            "Gagal Bjir"
                        )
                    }
                }
            }
        })
    }
    private fun callApiGetGithubUser2() {
        showLoading(context!!, swipeRefreshLayoutGlo)
        val httpClient = httpClient()
        val apiRequest1 = apiRequest<GlobalSembuhService>(httpClient)
        val apiRequest2 = apiRequest<GlobalPositifService>(httpClient)
        val apiRequest3 = apiRequest<GlobalMeninggalService>(httpClient)
        val call1 = apiRequest1.getUsers()
        val call2 = apiRequest2.getUsers()
        val call3 = apiRequest3.getUsers()
        call1.enqueue(object : Callback<List<GlobalSembuhApiItem>> {
            override fun onFailure(call: Call<List<GlobalSembuhApiItem>>, t: Throwable) {
                dismissLoading(swipeRefreshLayoutGlo)
            }
            override fun onResponse(call: Call<List<GlobalSembuhApiItem>>, response:
            Response<List<GlobalSembuhApiItem>>
            ) {
                dismissLoading(swipeRefreshLayoutGlo)
                when {
                    response.isSuccessful ->
                        when {
                            response.body()?.size != 0 ->
                                tampilApiSembuh(response.body()!!)
                            else -> {
                                tampilToast(
                                    context!!,
                                    "Berhasil"
                                )
                            }
                        }
                    else -> {
                        tampilToast(
                            context!!,
                            "Gagal Bjir"
                        )
                    }
                }
            }
        })
        call2.enqueue(object : Callback<List<GlobalPositifApiItem>> {
            override fun onFailure(call: Call<List<GlobalPositifApiItem>>, t: Throwable) {

            }
            override fun onResponse(call: Call<List<GlobalPositifApiItem>>, response:
            Response<List<GlobalPositifApiItem>>
            ) {

                when {
                    response.isSuccessful ->
                        when {
                            response.body()?.size != 0 ->
                                tampilApiPositif(response.body()!!)
                            else -> {
                                tampilToast(
                                    context!!,
                                    "Berhasil"
                                )
                            }
                        }
                    else -> {
                        tampilToast(
                            context!!,
                            "Gagal tampil positif"
                        )
                    }
                }
            }
        })
        call3.enqueue(object : Callback<List<GlobalMeninggalApiItem>> {
            override fun onFailure(call: Call<List<GlobalMeninggalApiItem>>, t: Throwable) {

            }
            override fun onResponse(call: Call<List<GlobalMeninggalApiItem>>, response:
            Response<List<GlobalMeninggalApiItem>>
            ) {

                when {
                    response.isSuccessful ->
                        when {
                            response.body()?.size != 0 ->
                                tampilApiMeninggal(response.body()!!)
                            else -> {
                                tampilToast(
                                    context!!,
                                    "Berhasil"
                                )
                            }
                        }
                    else -> {
                        tampilToast(
                            context!!,
                            "Gagal tampil meinggal"
                        )
                    }
                }
            }
        })
    }
    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }
}














