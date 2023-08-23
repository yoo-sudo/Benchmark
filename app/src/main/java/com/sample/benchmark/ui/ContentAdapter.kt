package com.sample.benchmark.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.sample.benchmark.R
import com.sample.benchmark.data.Content

class ContentViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val content: TextView = itemView.findViewById(R.id.content)
}

class ContentAdapter(private val entries: List<Content>) : RecyclerView.Adapter<ContentViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContentViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val itemView = inflater.inflate(R.layout.item_row, parent, false)
        itemView.findViewById<View>(R.id.card).setOnClickListener {
//            ClickTrace.onClickPerformed()
            AlertDialog.Builder(parent.context)
                .setMessage("Item clicked")
                .show()
        }
        return ContentViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ContentViewHolder, position: Int) {
        val entry = entries[position]
        holder.content.text = entry.contents
    }

    override fun getItemCount(): Int = entries.size
}
