package com.thioponiman.recycleview12.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.thioponiman.recycleview12.databinding.ListItemBuahBinding
import com.thioponiman.recycleview12.model.Buah

class AdapterBuah(private val context : Context,
                  private var data : List<Buah>?
                  private val itemclick : OnClickListener)
    : RecyclerView.Adapter<AdapterBuah.>() {
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val binding = ListItemBuahBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return RecyclerView.ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val item = data?.get(position)
        holder.foto.setImageResource(item.foto ?: 0)
        holder.nama.text = item?.nama

        holder.itemView.setOnClickListener {
            itemclick.detailData(item)
        }
    }

    override fun getItemCount(): Int = data?.size ?: 0

    inner class ViewHolder(val binding: ListItemBuahBinding) : RecyclerView.ViewHolder(binding.root) {
        var foto = binding.image
        var nama = binding.txtnama

    }

    inner class viewHolder( val view): RecyclerView.ViewHolder(view) {

    }
    interface OnClickListener {
        fun detailData(item : Buah)
}