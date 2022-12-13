package com.aqupepgames.projectp.one

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.aqupepgames.projectp.R
import com.aqupepgames.projectp.databinding.SingleUserLeaderBinding
import kotlin.random.Random


class UserRaitingListAdapter() :
    ListAdapter<SingleUser, UserRaitingListAdapter.UserRaitListVievHolder>(UsersDiffUtill()) {

    private var onItemClickListenerrr: ((person: SingleUser) -> Unit)? = null
    private var addToFavorite: ((recipe: SingleUser) -> Unit)? = null

    class UserRaitListVievHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val bindinggg = SingleUserLeaderBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserRaitListVievHolder {
        LayoutInflater.from(parent.context)
            .inflate(R.layout.single_user_leader, parent, false).also {
                return UserRaitListVievHolder(it)
            }
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: UserRaitListVievHolder, position: Int) {
        val currentItem = getItem(position)
        val listImagessss = listOf(
            R.drawable.sasha_superhero6,
            R.drawable.sasha_superhero5,
            R.drawable.sasha_superhero4,
            R.drawable.sasha_superhero3,
            R.drawable.sasha_superhero2,
            R.drawable.sasha_superhero1,
            R.drawable.sasha_supermom,
        )
        holder.bindinggg.apply {
            val currentImg = listImagessss.random()
            val currentScore = Random.nextInt(1, 5000)
            tvName.text = currentItem.nameeee
            tvScore.text = currentScore.toString()
            imgPersonAvataer.setImageResource(currentImg)
            root.setOnClickListener {
                onItemClickListenerrr?.invoke(currentItem)
            }

        }
    }

    fun setOnItemClickListener(listener: (person: SingleUser) -> Unit) {
        onItemClickListenerrr = listener
    }
}