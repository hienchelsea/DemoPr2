package com.example.demopr21010.ui.dataRoom

import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.demopr21010.R
import com.example.demopr21010.data.model.OwnerModel
import com.example.demopr21010.databinding.DataRoomFragmentBinding
import com.example.demopr21010.ui.base.BaseFragment
import com.example.demopr21010.ui.retrofit.RetrofitAdapter
import kotlinx.android.synthetic.main.data_room_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class DataRoomFragment : BaseFragment<DataRoomFragmentBinding, DataRoomViewModel>(),
    RetrofitAdapter.OnItemClickListener {

    override val viewModel: DataRoomViewModel by viewModel()
    override val layoutId: Int = R.layout.data_room_fragment

    private val retrofitAdapter: RetrofitAdapter by lazy {
        RetrofitAdapter(this)
    }

    override fun initData() {
        // TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun initView() {
         recyclerViewRetrofit.run {
            layoutManager = StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL)
            setHasFixedSize(true)
            adapter = retrofitAdapter
        }
    }

    override fun observeViewModel() {
        viewModel.item.observe(this, Observer {
            progressBar.visibility= View.GONE
            retrofitAdapter.updateData(it)
        })
    }

    override fun onInsert(ownerModel: OwnerModel) {
        //TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    companion object {
        fun newInstance() = DataRoomFragment()
    }

}