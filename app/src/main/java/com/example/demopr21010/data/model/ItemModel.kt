package com.example.demopr21010.data.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class ItemModel(
    @SerializedName("owner")
    @Expose
    val owner: OwnerModel,
    @SerializedName("is_accepted")
    @Expose
    val is_accepted: Boolean,
    @SerializedName("score")
    @Expose
    val score: Int,
    @SerializedName("last_activity_date")
    @Expose
    val last_activity_date: Long,
    @SerializedName("creation_date")
    @Expose
    val creation_date: Long,
    @SerializedName("answer_id")
    @Expose
    val answer_id: Long,
    @SerializedName("question_id")
    @Expose
    val question_id: Long
)
