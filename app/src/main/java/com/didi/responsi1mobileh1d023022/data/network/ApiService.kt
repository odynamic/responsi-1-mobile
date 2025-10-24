package com.didi.responsi1mobileh1d023022.data.network

import com.didi.responsi1mobileh1d023022.data.model.TeamResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Headers

interface ApiService {
    @Headers("X-Auth-Token: 271192d09da547eea6d404304157038d")
    @GET("teams/516")
    suspend fun getTeamData(): Response<TeamResponse>
}
