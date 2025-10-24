package com.didi.responsi1mobileh1d023022.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.didi.responsi1mobileh1d023022.data.model.Coach
import com.didi.responsi1mobileh1d023022.data.model.Player
import com.didi.responsi1mobileh1d023022.data.network.ApiClient
import kotlinx.coroutines.launch

class TeamViewModel : ViewModel() {
    private val _coach = MutableLiveData<Coach>()
    val coach: LiveData<Coach> = _coach

    private val _squad = MutableLiveData<List<Player>>()
    val squad: LiveData<List<Player>> = _squad

    fun fetchTeamData() {
        viewModelScope.launch {
            try {
                val response = ApiClient.apiService.getTeamData()
                if (response.isSuccessful) {
                    val body = response.body()
                    _coach.value = body?.coach
                    _squad.value = body?.squad
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}
