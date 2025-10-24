package com.didi.responsi1mobileh1d023022.ui.activity

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.didi.responsi1mobileh1d023022.databinding.ActivityCoachBinding
import com.didi.responsi1mobileh1d023022.ui.viewmodel.TeamViewModel

class CoachActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCoachBinding
    private val viewModel: TeamViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCoachBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.fetchTeamData()
        viewModel.coach.observe(this) { coach ->
            if (coach != null) {
                binding.tvCoachName.text = coach.name
                binding.tvCoachBirth.text = coach.dateOfBirth
                binding.tvCoachNationality.text = coach.nationality
            }
        }
    }
}
