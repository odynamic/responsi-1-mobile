package com.didi.responsi1mobileh1d023022

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.didi.responsi1mobileh1d023022.databinding.ActivityMainBinding
import com.didi.responsi1mobileh1d023022.ui.activity.CoachActivity
import com.didi.responsi1mobileh1d023022.ui.activity.HistoryActivity
import com.didi.responsi1mobileh1d023022.ui.activity.SquadActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnHistory.setOnClickListener {
            startActivity(Intent(this, HistoryActivity::class.java))
        }

        binding.btnCoach.setOnClickListener {
            startActivity(Intent(this, CoachActivity::class.java))
        }

        binding.btnSquad.setOnClickListener {
            startActivity(Intent(this, SquadActivity::class.java))
        }

        val rootView = findViewById<android.view.View>(android.R.id.content)
        rootView.alpha = 0f
        rootView.animate().alpha(1f).setDuration(900).start()
    }
}
