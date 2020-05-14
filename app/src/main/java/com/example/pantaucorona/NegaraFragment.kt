package com.example.pantaucorona

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.pantaucorona.data.NegaraService
import com.example.pantaucorona.data.apiRequest
import com.example.pantaucorona.data.httpClient
import com.example.pantaucorona.util.dismissLoading
import com.example.pantaucorona.util.showLoading
import com.example.pantaucorona.util.tampilToast
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_negara.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NegaraFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_negara,container, false)
    }
    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callApiGetGithubUser()
    }

    private fun callApiGetGithubUser() {
        showLoading(context!!, swipeRefreshLayout)
        val httpClient = httpClient()
        val apiRequest = apiRequest<NegaraService>(httpClient)
        val call = apiRequest.getUsers()
        call.enqueue(object : Callback<List<NegaraApiItem>> {
            override fun onFailure(call: Call<List<NegaraApiItem>>, t: Throwable) {
                dismissLoading(swipeRefreshLayout)
            }
            override fun onResponse(call: Call<List<NegaraApiItem>>, response:
            Response<List<NegaraApiItem>>) {
            dismissLoading(swipeRefreshLayout)
            when {
                response.isSuccessful ->
                    when {
                        response.body()?.size != 0 ->
                            tampilNegaraApis(response.body()!!)
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

    private fun tampilNegaraApis(NegaraApis: List<NegaraApiItem>) {
        listNegaraItem.layoutManager = LinearLayoutManager(context)
        listNegaraItem.adapter = NegaraApiAdapter(context!!, NegaraApis) {
            val NegaraApi = it
            tampilToast(
                context!!,
                NegaraApi.attributes.countryRegion
            )
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }

}
