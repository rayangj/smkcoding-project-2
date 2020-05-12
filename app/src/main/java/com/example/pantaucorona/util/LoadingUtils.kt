package com.example.pantaucorona.util

import android.content.Context
import androidx.core.content.ContextCompat
import com.example.pantaucorona.R
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout


    fun showLoading(context: Context, swipeRefreshLayout: SwipeRefreshLayout) {
        swipeRefreshLayout.setColorSchemeColors(
            ContextCompat.getColor(context,
            R.color.colorPrimary))
        swipeRefreshLayout.isEnabled = true
        swipeRefreshLayout.isRefreshing = true
    }
    fun dismissLoading(swipeRefreshLayout: SwipeRefreshLayout) {
        swipeRefreshLayout.isRefreshing = false
        swipeRefreshLayout.isEnabled = false
    }
