package com.binar.cc_storage

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Memo::class], version = 1)
abstract class MemoDatabase : RoomDatabase() {
    abstract fun memoDao(): MemoDao

    companion object {
        private var INSTANCE: MemoDatabase? = null

        fun getInstance(context: Context): MemoDatabase? {
            if (INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(
                    context, MemoDatabase::class.java,
                    "memo_db"
                ).build()
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }
}