package com.rushi.unittest_ld_cr_1.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.rushi.unittest_ld_cr_1.databinding.RvItemBinding
import com.rushi.unittest_ld_cr_1.domain.model.PostItem

class MyAdapter() : RecyclerView.Adapter<MyAdapter.ViewHolder>() {

    private var itemList: List<PostItem> = emptyList()

    fun submitList(itemList1 : List<PostItem>){
        itemList = itemList1
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: RvItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: PostItem) {
            binding.titleTv.text = item.title
            binding.bodyTv.text = item.body
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = RvItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = itemList[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return itemList.size
    }
}




