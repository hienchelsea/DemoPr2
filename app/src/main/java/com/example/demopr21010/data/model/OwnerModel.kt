package com.example.demopr21010.data.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = OwnerModel.TABLE_NAME
)

data class OwnerModel(
    @NonNull
    @ColumnInfo(name = "reputation")
    @SerializedName("reputation")
    @Expose
    val reputation: Int,

    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "user_id")
    @SerializedName("user_id")
    @Expose
    val user_id: Int,

    @NonNull
    @ColumnInfo(name = "user_type")
    @SerializedName("user_type")
    @Expose
    val user_type: String,

    @NonNull
    @ColumnInfo(name = "profile_image")
    @SerializedName("profile_image")
    @Expose
    val profile_image: String,

    @NonNull
    @ColumnInfo(name = "display_name")
    @SerializedName("display_name")
    @Expose
    val display_name: String,

    @NonNull
    @ColumnInfo(name = "link")
    @SerializedName("link")
    @Expose
    val link: String
){
    companion object {
        const val TABLE_NAME = "owner"
    }
}
