package com.binar.cc_storage

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.memo_layout.view.*
import java.text.SimpleDateFormat
import java.util.*

class MemoAdapter(private val listMemo: List<Memo>) :
    RecyclerView.Adapter<MemoAdapter.ViewHolder>() {

    private lateinit var db: MemoDatabase

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val activity = itemView.context as ProfileActivity
        fun bind(listMemo: List<Memo>) {
            val listMemo = listMemo[adapterPosition]

            val tvDate = itemView.tvDate
            val tvMemo = itemView.tvMemo

            tvDate.setText(listMemo.isDate)
            tvMemo.setText(listMemo.isiMemo)
            itemView.setOnClickListener {

                activity?.showEditDialog(listMemo)
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.memo_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listMemo.size
    }

    override fun onBindViewHolder(holder: MemoAdapter.ViewHolder, position: Int) {
        holder.bind(listMemo)

    }
}