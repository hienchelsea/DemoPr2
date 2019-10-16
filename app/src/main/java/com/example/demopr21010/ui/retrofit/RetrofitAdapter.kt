package com.example.demopr21010.ui.retrofit

import android.view.View
import android.view.ViewGroup
import com.example.demopr21010.R
import com.example.demopr21010.data.model.OwnerModel
import com.example.demopr21010.databinding.ItemOwnerBinding
import com.example.demopr21010.ui.base.BaseRecyclerAdapter
import com.example.demopr21010.ui.base.BaseViewHolder
import com.example.demopr21010.utils.assignViews
import com.example.demopr21010.utils.setImageUrl

class RetrofitAdapter(private val onItemClickListener: OnItemClickListener) :
    BaseRecyclerAdapter<OwnerModel, ItemOwnerBinding, RetrofitAdapter.RetrofitViewHolder>() {

    override fun getItemLayoutResource(viewType: Int): Int = R.layout.item_owner

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RetrofitViewHolder =
        RetrofitViewHolder(
            binding = getViewHolderDataBinding(parent, viewType) as ItemOwnerBinding,
            onItemClickListener = onItemClickListener
        )

    class RetrofitViewHolder(
        binding: ItemOwnerBinding,
        private val onItemClickListener: OnItemClickListener
    ) : BaseViewHolder<OwnerModel, ItemOwnerBinding>(binding), View.OnClickListener {

        private lateinit var owner: OwnerModel

        init {
            assignViews(binding.imageViewAvatar)
        }

        override fun onBindData(itemData: OwnerModel) {
            super.onBindData(itemData)
            binding.viewModel = itemData
            binding.imageViewAvatar.setImageUrl(itemData.profile_image)
            owner = itemData
        }

        override fun onClick(view: View?) {
            when (view?.id) {
                R.id.imageViewAvatar -> onItemClickListener.onInsert(owner)
            }
        }
    }

    interface OnItemClickListener {
        fun onInsert(ownerModel: OwnerModel)
    }

}