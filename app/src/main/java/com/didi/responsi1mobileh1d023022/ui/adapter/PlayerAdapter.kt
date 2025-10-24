package com.didi.responsi1mobileh1d023022.ui.adapter

import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.didi.responsi1mobileh1d023022.R
import com.didi.responsi1mobileh1d023022.data.model.Player
import com.google.android.material.bottomsheet.BottomSheetDialog

class PlayerAdapter(private val players: List<Player>) :
    RecyclerView.Adapter<PlayerAdapter.PlayerViewHolder>() {

    class PlayerViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val name: TextView = view.findViewById(R.id.tvPlayerName)
        val nationality: TextView = view.findViewById(R.id.tvPlayerNationality)
        val card: View = view.findViewById(R.id.cardPlayer)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlayerViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_player, parent, false)
        return PlayerViewHolder(view)
    }

    override fun onBindViewHolder(holder: PlayerViewHolder, position: Int) {
        val player = players[position]
        holder.name.text = player.name ?: "-"
        holder.nationality.text = player.nationality ?: "-"

        val pos = player.position?.lowercase() ?: ""

        val isGoalkeeper = listOf("goalkeeper", "keeper", "goal keeper", "gk").any { pos.contains(it) }

        val defenderKeywords = listOf(
            "defender", "back", "centre-back", "centre back", "center-back", "center back",
            "left back", "right back", "fullback", "full-back", "wing-back", "wing back",
            "cb", "lb", "rb", "rback", "lback"
        )
        val isDefender = defenderKeywords.any { pos.contains(it) }

        val midfieldKeywords = listOf(
            "midfield", "midfielder", "central", "cm", "cdm", "c dm", "cam", "attacking midfield",
            "defensive midfield", "mid", "midfield/forward", "midfielder/forward", "midfield/defense"
        )
        val isMidfielder = midfieldKeywords.any { pos.contains(it) }

        val forwardKeywords = listOf(
            "forward", "striker", "winger", "attacker", "attack", "fw", "st", "ss", "second striker"
        )
        val isForward = forwardKeywords.any { pos.contains(it) }

        val color = when {
            isGoalkeeper -> Color.parseColor("#FFF176")
            isDefender -> Color.parseColor("#64B5F6")
            isMidfielder -> Color.parseColor("#81C784")
            isForward -> Color.parseColor("#E57373")

            pos.contains("back") || pos.contains("cb") -> Color.parseColor("#64B5F6")
            pos.contains("mid") || pos.contains("cm") -> Color.parseColor("#81C784")
            pos.contains("att") || pos.contains("st") || pos.contains("fw") -> Color.parseColor("#E57373")
            else -> Color.parseColor("#64B5F6")
        }

        holder.card.setBackgroundColor(color)

        holder.itemView.setOnClickListener {
            showPlayerDetail(holder.itemView.context, player)
        }
    }

    override fun getItemCount() = players.size

    private fun showPlayerDetail(context: Context, player: Player) {
        val dialog = BottomSheetDialog(context)
        val view = LayoutInflater.from(context).inflate(R.layout.bottom_sheet_player, null)
        dialog.setContentView(view)

        val name = view.findViewById<TextView>(R.id.tvBottomName)
        val dob = view.findViewById<TextView>(R.id.tvBottomDob)
        val nationality = view.findViewById<TextView>(R.id.tvBottomNationality)
        val position = view.findViewById<TextView>(R.id.tvBottomPosition)

        name.text = player.name ?: "-"
        dob.text = player.dateOfBirth ?: "-"
        nationality.text = player.nationality ?: "-"
        position.text = player.position ?: "-"

        dialog.show()
    }
}
