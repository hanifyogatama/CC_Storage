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

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {}


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemoAdapter.ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.memo_layout, parent, false)
        return ViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return listMemo.size
    }

    override fun onBindViewHolder(holder: MemoAdapter.ViewHolder, position: Int) {
        holder.itemView.tvDate.text = listMemo[position].isDate
        holder.itemView.tvMemo.text = listMemo[position].isiMemo

        MemoDatabase.getInstance(holder.itemView.context)?.let{
            db= it
        }

        holder.itemView.cvCardView.setOnClickListener {
            val editActivityIntent = Intent(it.context, ProfileActivity::class.java)
            editActivityIntent.putExtra("memo", listMemo[position])
            it.context.startActivity(editActivityIntent)
        }

    }
}