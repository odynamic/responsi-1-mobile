package com.didi.responsi1mobileh1d023022.ui.activity

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.didi.responsi1mobileh1d023022.databinding.ActivitySquadBinding
import com.didi.responsi1mobileh1d023022.ui.adapter.PlayerAdapter
import com.didi.responsi1mobileh1d023022.ui.viewmodel.TeamViewModel

class SquadActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySquadBinding
    private val viewModel: TeamViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySquadBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rvSquad.layoutManager = LinearLayoutManager(this)
        viewModel.fetchTeamData()

        viewModel.squad.observe(this) { list ->
            if (list != null) {
                binding.rvSquad.adapter = PlayerAdapter(list)
            }
        }
    }
}
