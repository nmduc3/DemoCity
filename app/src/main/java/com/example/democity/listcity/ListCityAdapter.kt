package com.example.democity.listcity

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.democity.R
import com.example.democity.data.model.SearchLocationItem
import com.example.democity.databinding.ItemCityBinding
import com.example.democity.extension.inflate

/**
 * Created by nmduc3 on 3/30/21
 */
class ListCityAdapter :
    ListAdapter<SearchLocationItem, ListCityAdapter.ItemVH>(SearchLocationItemDiffCallback()) {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemVH =
        ItemVH(parent.inflate(R.layout.item_city))

    override fun onBindViewHolder(holder: ItemVH, position: Int) {
        holder.bind(position)
    }

    inner class ItemVH(view: View) : RecyclerView.ViewHolder(view) {
        private val binding = ItemCityBinding.bind(view)
        fun bind(position: Int) {
            getItem(position).let {
                binding.run {
                    tvTitle.text = it.title
                    tvLatLong.text = it.lattLong
                    tvType.text = it.locationType
                }
            }
        }
    }

    class SearchLocationItemDiffCallback : DiffUtil.ItemCallback<SearchLocationItem>() {
        override fun areItemsTheSame(
            oldItem: SearchLocationItem,
            newItem: SearchLocationItem
        ): Boolean = oldItem.woeid == newItem.woeid

        override fun areContentsTheSame(
            oldItem: SearchLocationItem,
            newItem: SearchLocationItem
        ): Boolean = oldItem.title == newItem.title &&
                oldItem.lattLong == newItem.lattLong &&
                oldItem.locationType == newItem.locationType
    }
}
