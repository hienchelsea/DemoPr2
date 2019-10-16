package com.example.demopr21010.ui.retrofit

import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.demopr21010.R
import com.example.demopr21010.data.model.OwnerModel
import com.example.demopr21010.databinding.RetrofitFragmentBinding
import com.example.demopr21010.ui.base.BaseFragment
import kotlinx.android.synthetic.main.data_room_fragment.*
import kotlinx.android.synthetic.main.retrofit_fragment.*
import kotlinx.android.synthetic.main.retrofit_fragment.progressBar
import kotlinx.android.synthetic.main.retrofit_fragment.recyclerViewRetrofit
import org.koin.androidx.viewmodel.ext.android.viewModel

class RetrofitFragment : BaseFragment<RetrofitFragmentBinding, RetrofitViewModel>(),
    RetrofitAdapter.OnItemClickListener {

    override val viewModel: RetrofitViewModel by viewModel()
    override val layoutId: Int = R.layout.retrofit_fragment

    private val retrofitAdapter: RetrofitAdapter by lazy {
        RetrofitAdapter(this)
    }

    override fun initData() {
        recyclerViewRetrofit.run {
            layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(true)
            adapter = retrofitAdapter
        }
    }

    override fun initView() {

    }

    override fun observeViewModel() {
        viewModel.item.observe(this, Observer {
            progressBar.visibility= View.GONE
            retrofitAdapter.updateData(it)
        })
    }

    override fun setBindingVariables() {
        //viewBinding.bindingViewModel = this@RetrofitFragment.viewModel
        //  viewBinding.viewModel = this@RetrofitFragment.viewModel
    }

    override fun onInsert(ownerModel: OwnerModel) {
        viewModel.insert(ownerModel)
        viewModel.owner.observe(this, Observer {
            toast(it)
        })
    }

    companion object {
        fun newInstance() = RetrofitFragment()
    }
}
