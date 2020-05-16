package com.example.pantaucorona

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_tips.*

class TipsFragment : Fragment() {

    lateinit var listTips : ArrayList<Tips>
    private fun DataTips() {
        listTips = ArrayList()
        listTips.add(Tips("Mencuci tangan dengan benar"))
        listTips.add(Tips("Menggunakan Masker"))
        listTips.add(Tips("Menjaga daya tahan tubuh"))
        listTips.add(Tips("Tidak pergi ke negara/tempat terjangkit"))
        listTips.add(Tips("Menghindari kontak dengan sesama"))
        listTips.add(Tips("Selalu jaga kesehatan"))
        listTips.add(Tips("Mengikuti aturan pemerintah"))
        listTips.add(Tips("Minum Extrajoss"))
        listTips.add(Tips("Nonton Anime"))
    }

    private fun tampilTips() {
        rv_listTips.layoutManager = LinearLayoutManager(activity)
        rv_listTips.adapter = TipsAdapter(activity!!, listTips)
    }

    private fun initView() {
        DataTips()
        tampilTips()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tips,container, false)
    }
    override fun onViewCreated(
        view: View,@Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }

}
