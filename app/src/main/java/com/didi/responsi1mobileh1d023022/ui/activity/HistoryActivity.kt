package com.didi.responsi1mobileh1d023022.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.didi.responsi1mobileh1d023022.databinding.ActivityHistoryBinding

class HistoryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHistoryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHistoryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.tvHistoryText.text = getString(com.didi.responsi1mobileh1d023022.R.string.club_history_text)
    }
}
