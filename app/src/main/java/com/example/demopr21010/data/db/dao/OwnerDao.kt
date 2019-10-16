package com.example.demopr21010.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.demopr21010.data.model.OwnerModel

@Dao
interface OwnerDao {
    @Query("SELECT * FROM $TABLE_NAME")
    fun getAllUser(): List<OwnerModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(ownerModel: OwnerModel): Long

    companion object {
        private const val TABLE_NAME = OwnerModel.TABLE_NAME
    }
}
