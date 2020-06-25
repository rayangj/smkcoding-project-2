package com.example.pantaucorona

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.fragment_tips.*

class TipsFragment : Fragment() {
//    , TipsAdapter.dataListener
//    lateinit var ref : DatabaseReference
//    lateinit var auth: FirebaseAuth
//    lateinit var dataTip: ArrayList<Tips>
    //lateinit var listTips : ArrayList<MyTips>

//    private fun DataTips() {
//        listTips = ArrayList()
//        listTips.add(Tips("Mencuci tangan dengan benar"))
//        listTips.add(Tips("Menggunakan Masker"))
//        listTips.add(Tips("Menjaga daya tahan tubuh"))
//        listTips.add(Tips("Tidak pergi ke negara/tempat terjangkit"))
//        listTips.add(Tips("Menghindari kontak dengan sesama"))
//        listTips.add(Tips("Selalu jaga kesehatan"))
//        listTips.add(Tips("Mengikuti aturan pemerintah"))
//        listTips.add(Tips("Minum Extrajoss"))
//        listTips.add(Tips("Nonton Anime"))
//    }

//    private fun tampilTips() {
//        rv_listTips.layoutManager = LinearLayoutManager(activity)
//        rv_listTips.adapter = TipsAdapter(activity!!, listTips)
//    }
//
//    private fun initView() {
//        DataTips()
//        tampilTips()
//    }

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
       // getData()
        fab.setOnClickListener {
            val intent = Intent (getActivity(), TipsActivity::class.java)
            getActivity()?.startActivity(intent)
        }
//        initView()
    }

//    private fun getData() {
//        //Mendapatkan Referensi Database
//        Toast.makeText(getContext(), "Mohon Tunggu Sebentar...", Toast.LENGTH_LONG).show()
//        auth = FirebaseAuth.getInstance()
//        val getUserID: String = auth?.getCurrentUser()?.getUid().toString()
//        ref = FirebaseDatabase.getInstance().getReference()
//        ref.child(getUserID).child("Teman").addValueEventListener(object :
//            ValueEventListener {
//            override fun onCancelled(p0: DatabaseError) {
//                Toast.makeText(getContext(), "Database Error yaa...",
//                    Toast.LENGTH_LONG).show()
//            }
//            override fun onDataChange(dataSnapshot: DataSnapshot) {
//                //Inisialisasi ArrayList
//                dataTip = java.util.ArrayList<Tips>()
//                for (snapshot in dataSnapshot.children) {
//                    //Mapping data pada DataSnapshot ke dalam objek mahasiswa
//                    val teman = snapshot.getValue(Tips::class.java)
//                    //Mengambil Primary Key, digunakan untuk proses Update dan Delete
//                    teman?.setKey(snapshot.key)
//                    dataTip.add(teman!!)
//                }
//                //Memasang Adapter pada RecyclerView
//                rv_listTips.layoutManager = LinearLayoutManager(context)
//                rv_listTips.adapter = TipsAdapter(context!!, dataTip)
//                Toast.makeText(getContext(), "Data Berhasil Dimuat", Toast.LENGTH_LONG).show()
//            }
//        })
//    }


    override fun onDestroy() {
        super.onDestroy()
        this.clearFindViewByIdCache()
    }

}
