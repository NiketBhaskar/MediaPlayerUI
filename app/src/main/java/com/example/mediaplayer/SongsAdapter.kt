package com.example.mediaplayer

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.mediaplayer.model.Songs
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList


class SongsAdapter(
    val context: Context,
    private var recyclerViewItems: ArrayList<Songs>,
    private val iconsClickListener: IconsClickListener,
) : RecyclerView.Adapter<SongsAdapter.SongViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SongViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cardview_item, parent, false)
        return SongViewHolder(view)
    }

    override fun onBindViewHolder(holder: SongViewHolder, position: Int) {
        with(holder) {
            with(recyclerViewItems[position]) {
                holder.tvName.text = "${this.title}"
                holder.tvArtist.text = "${this.subTitle}"
                val timeInMillis: Long = this.length!!
                val timeSeconds = timeInMillis / 1000
                val minutes = timeSeconds / 60
                val seconds = timeSeconds % 60
                val timeString = String.format("%d:%02d", minutes, seconds)
                holder.tvLength.text = "${timeString}"
                holder.profileImage.setImageResource(this.imageView!!)
                holder.rowLinearLayout.setOnClickListener{
                    iconsClickListener.onCardClick(this)
                }
            }
        }
    }


    override fun getItemCount(): Int = recyclerViewItems.size

    inner class SongViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val tvName: TextView
        val tvArtist: TextView
        val tvLength: TextView
        val profileImage: ImageView
        val rowLinearLayout: LinearLayout
        init {
            tvName = itemView.findViewById(R.id.tvName)
            tvArtist = itemView.findViewById(R.id.tvArtist)
            tvLength = itemView.findViewById(R.id.tvLength)
            profileImage = itemView.findViewById(R.id.image)
            rowLinearLayout = itemView.findViewById(R.id.row_linearLayout)
        }
    }
}

interface IconsClickListener {
//    fun onTeamViewProfileIconClick(crmUserAlert: TeamFilteredLead)
//    fun onTeamViewCallIconClick(crmUserAlert: TeamFilteredLead)
//    fun onTeamViewMessageIconClick(crmUserAlert: TeamFilteredLead)
//    fun onTeamViewRemarkIconClick(crmUserAlert: TeamFilteredLead)
//    fun onTeamViewCardChecked(crmUserAlert: TeamFilteredLead)
//    fun onTeamViewCardUnchecked(crmUserAlert: TeamFilteredLead)
//    fun onTeamViewCardSelectAll(crmUserAlerts: List<TeamFilteredLead>)
    fun onCardClick(song: Songs)
}