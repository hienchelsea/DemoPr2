package com.example.demopr21010.ui.main

import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import com.example.demopr21010.R
import com.example.demopr21010.databinding.ActivityMainBinding
import com.example.demopr21010.ui.base.BaseActivity
import com.example.demopr21010.ui.dataRoom.DataRoomFragment
import com.example.demopr21010.ui.retrofit.RetrofitFragment
import com.example.demopr21010.utils.assignViews
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>(), View.OnClickListener {

    override val viewModel: MainViewModel by viewModel()
    override val layoutId: Int = R.layout.activity_main

    override fun initView() {
        assignViews(textViewRetrofit, textViewRomData)
    }

    override fun observeViewModel() {
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.textViewRetrofit -> addFragment(
                R.id.frameMainContent,
                RetrofitFragment.newInstance(),
                true
            )
            R.id.textViewRomData -> addFragment(
                R.id.frameMainContent,
                DataRoomFragment.newInstance(),
                true
            )
        }

    }
}
