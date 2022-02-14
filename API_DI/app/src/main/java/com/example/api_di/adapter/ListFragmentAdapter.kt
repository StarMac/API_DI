package com.example.api_di.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.LazyHeaders
import com.example.api_di.R
import com.example.api_di.databinding.ListItemBinding
import com.example.api_di.model.Item

class ListFragmentAdapter :
    ListAdapter<Item, ListFragmentAdapter.ItemViewHolder>(object : DiffUtil.ItemCallback<Item>() {
        override fun areItemsTheSame(oldItem: Item, newItem: Item): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Item, newItem: Item): Boolean = oldItem == newItem
    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ListItemBinding.inflate(layoutInflater, parent, false)

        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class ItemViewHolder(binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        private var itemBinding: ListItemBinding? = null

        init {
            itemBinding = binding
        }

        @SuppressLint("SetTextI18n")
        fun bind(item: Item) {
            with(itemBinding!!) {
                if (item.url == "") {
                    descriptionItem.text = "ERROR: " + item.title
                    descriptionItem.textSize = 15F
                    descriptionItem.textAlignment = TextView.TEXT_ALIGNMENT_CENTER
                    imageItem.visibility = ImageView.GONE
                } else {
                    val url = GlideUrl(
                        item.url, LazyHeaders.Builder()
                            .addHeader("User-Agent", "Android")
                            .build()
                    )
                    Glide.with(imageItem.context)
                        .load(url)
                        .centerInside()
                        .error(R.drawable.ic_broken_image_24)
                        .into(imageItem)

                    descriptionItem.text = item.title
                    imageItem.visibility = ImageView.VISIBLE
                }
            }
        }
    }
}