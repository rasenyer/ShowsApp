package com.rasenyer.showsapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.rasenyer.showsapp.R
import com.rasenyer.showsapp.databinding.ItemShowBinding
import com.rasenyer.showsapp.datasource.remote.models.Show

class ShowAdapter : RecyclerView.Adapter<ShowAdapter.MyViewHolder>() {

    inner class MyViewHolder(val binding: ItemShowBinding) : RecyclerView.ViewHolder(binding.root)

    private val diffCallback = object : DiffUtil.ItemCallback<Show>() {

        override fun areItemsTheSame(oldShow: Show, newShow: Show): Boolean {
            return oldShow.id == newShow.id
        }

        override fun areContentsTheSame(oldShow: Show, newShow: Show): Boolean {
            return newShow == oldShow
        }

    }

    private val differ = AsyncListDiffer(this, diffCallback)

    var showList: List<Show>
        get() = differ.currentList
        set(value) { differ.submitList(value) }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return MyViewHolder(ItemShowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        val show = showList[position]

        holder.binding.apply {

            mImageView.load(show.image.original) {
                placeholder(R.drawable.ic_image)
                crossfade(true)
                crossfade(1000)
            }

            mTextViewName.text = show.name

        }

    }

    override fun getItemCount() = showList.size

}