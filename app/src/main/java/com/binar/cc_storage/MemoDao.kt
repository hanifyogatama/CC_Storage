package com.binar.cc_storage

import androidx.room.*

@Dao
interface MemoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addItem(memo: Memo): Long

    @Query("SELECT * FROM Memo ")
    fun readAllItem(): List<Memo>

    @Update
    fun updateItem(memo: Memo): Int

    @Delete
    fun deleteItem(memo: Memo): Int
}