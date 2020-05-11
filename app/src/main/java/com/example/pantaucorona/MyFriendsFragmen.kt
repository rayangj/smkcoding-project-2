package com.example.pantaucorona

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_my_friends.*

class MyFriendsFragmen : Fragment() {

    lateinit var listTeman : ArrayList<MyFriends>
    private fun simulasiDataTeman() {
        listTeman = ArrayList()
        listTeman.add(MyFriends("Fakhry", "Laki-laki", "fakhry@smkcoding.id","081123123123", "Malang"))
        listTeman.add(MyFriends("Ahmad", "Laki-laki", "ahmad@smkcoding.id","085123123123", "Malang"))
        listTeman.add(MyFriends("Ahmad", "Laki-laki", "ahmad@smkcoding.id","085123123123", "Malang"))
        listTeman.add(MyFriends("Ahmad", "Laki-laki", "ahmad@smkcoding.id","085123123123", "Malang"))
        listTeman.add(MyFriends("Ahmad", "Laki-laki", "ahmad@smkcoding.id","085123123123", "Malang"))
        listTeman.add(MyFriends("Ahmad", "Laki-laki", "ahmad@smkcoding.id","085123123123", "Malang"))
        listTeman.add(MyFriends("Ahmad", "Laki-laki", "ahmad@smkcoding.id","085123123123", "Malang"))
    }
    private fun tampilTeman() {
        rv_listMyFriends.layoutManager = LinearLayoutManager(activity)
        rv_listMyFriends.adapter = MyFriendAdapter(activity!!, listTeman)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_my_friends,container, false)
    }
    override fun onViewCreated(view: View,@Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        simulasiDataTeman()
        tampilTeman()
    }
    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }

}
