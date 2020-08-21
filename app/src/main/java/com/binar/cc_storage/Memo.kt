package com.binar.cc_storage

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


@Entity
@Parcelize
data class Memo (
    @PrimaryKey(autoGenerate = true) val id: Int?,
    @ColumnInfo(name=" isDate") var isDate: String,
    @ColumnInfo(name = "isiMemo") var isiMemo: String
) : Parcelable