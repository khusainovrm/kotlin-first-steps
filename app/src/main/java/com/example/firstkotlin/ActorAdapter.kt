package com.example.firstkotlin

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide


class ActorAdapter(
    context: Context, private val actors: List<Actor>
) : RecyclerView.Adapter<ViewHolder>() {

    private val inflater = LayoutInflater.from(context)

    private fun getItem(positin: Int): Actor = actors[positin - 1]

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> TYPE_HEADER
            itemCount - 1 -> TYPE_FOOTER
            else -> TYPE_ACTOR
        }
    }

    override fun getItemCount(): Int = actors.size + 2

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            TYPE_HEADER -> HeaderViewHolder(inflater.inflate(R.layout.list_header, parent, false))
            TYPE_ACTOR -> ActorViewHolder(inflater.inflate(R.layout.list_item_actor, parent, false))
            TYPE_FOOTER -> FooterViewHolder(inflater.inflate(R.layout.list_footer, parent, false))
            else -> throw IllegalArgumentException()
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is ActorViewHolder -> holder.bind(getItem(position))
//            is HeaderViewHolder -> holder.bind()
            is FooterViewHolder -> holder.bind(actors.size)
        }
    }

    companion object {
        const val TYPE_HEADER = 0
        const val TYPE_ACTOR = 1
        const val TYPE_FOOTER = 2
    }

    class ActorViewHolder(view: View) : ViewHolder(view) {
        private val v = view
        private val actorImage = view.findViewById<ImageView>(R.id.actorImage)
        private val actorName = view.findViewById<TextView>(R.id.actorName)
        private val osarImage = view.findViewById<ImageView>(R.id.oscarImage)
        val l = view.apply {
            setOnClickListener {
                Log.i("INFO click", "view clicked ${view}")
            }
        }

        fun bind(actor: Actor) {
            actorName.text = actor.name
            Glide.with(v).load("https://robohash.org/" + (0..100).random()).into(actorImage)
            if (actor.hasOscar) osarImage.visibility = View.VISIBLE else osarImage.visibility =
                View.INVISIBLE
        }
    }

    class HeaderViewHolder(itemView: View) : ViewHolder(itemView) {
//        private val counterView = itemView.findViewById<TextView>(R.id.headerText)
//        fun bind() {
//        }
    }

    class FooterViewHolder(itemView: View) : ViewHolder(itemView) {
        private val footerTextView = itemView.findViewById<TextView>(R.id.headerText)

        fun bind(count: Int) {
            footerTextView.text = "Total name: $count"
        }
    }
}

