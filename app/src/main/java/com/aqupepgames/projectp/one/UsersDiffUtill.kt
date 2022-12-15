package com.aqupepgames.projectp.one
import androidx.recyclerview.widget.DiffUtil

class UsersDiffUtill: DiffUtil.ItemCallback<SingleUser>() {
    override fun areItemsTheSame(oldItem: SingleUser, newItem: SingleUser): Boolean {
        return oldItem.idddd == newItem.idddd
    }

    override fun areContentsTheSame(oldItem: SingleUser, newItem: SingleUser): Boolean {
        return oldItem == newItem
    }
}