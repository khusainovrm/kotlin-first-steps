package com.example.firstkotlin

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide


class ActorAdapter(
    context: Context,
    private val actors: List<Actor>
) : RecyclerView.Adapter<ActorAdapter.ActorViewHolder>() {
    private val inflater = LayoutInflater.from(context)
    private fun getItem(positin: Int): Actor = actors[positin]

    class ActorViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val v = view
        private val actorImage = view.findViewById<ImageView>(R.id.actorImage)
        private val actorName = view.findViewById<TextView>(R.id.actorName)
        private val osarImage = view.findViewById<ImageView>(R.id.oscarImage)

        fun bind(actor: Actor) {
            actorName.text = actor.name
            Glide.with(v).load(actor.avatar).into(actorImage);
            if (actor.hasOscar) osarImage.visibility = View.VISIBLE else osarImage.visibility =
                View.INVISIBLE
        }
    }

    override fun getItemCount(): Int = actors.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ActorViewHolder {
        return ActorViewHolder(inflater.inflate(R.layout.list_item_actor, parent, false))
    }

    override fun onBindViewHolder(holder: ActorViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

