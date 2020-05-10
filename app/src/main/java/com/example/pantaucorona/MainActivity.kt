package com.example.pantaucorona

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.tabs.TabLayoutMediator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val menuTeks = arrayOf("Teman", "Github", "Profil")
    val manuIcon = arrayOf(R.drawable.ic_home_black_24dp, R.drawable.ic_supervisor_account_black_24dp,
        R.drawable.ic_person_black_24dp)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = ViewPagerAdapter(this)
        view_pager.setAdapter(adapter);
        TabLayoutMediator(tab_layout, view_pager,
            TabLayoutMediator.TabConfigurationStrategy { tab, position ->
                tab.text = menuTeks[position]
                tab.icon = ResourcesCompat.getDrawable(
                    resources,
                    manuIcon[position], null
                )
            }).attach()
    }

}
