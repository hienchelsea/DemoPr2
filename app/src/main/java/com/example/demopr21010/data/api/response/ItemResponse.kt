package com.example.demopr21010.data.api.response

import com.example.demopr21010.data.model.ItemModel
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ItemResponse(
    @SerializedName("items")
    @Expose
    val items: List<ItemModel>,
    @SerializedName("has_more")
    @Expose
    val has_more: Boolean,
    @SerializedName("quota_max")
    @Expose
    val quota_max: Int,
    @SerializedName("quota_remaining")
    @Expose
    val quota_remaining: Int
)
