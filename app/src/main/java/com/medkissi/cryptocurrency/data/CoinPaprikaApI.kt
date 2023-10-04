package com.medkissi.cryptocurrencyapp.data

import com.medkissi.cryptocurrency.data.dto.CoinDetailDto
import com.medkissi.cryptocurrencyapp.data.dto.CoinDto
import retrofit2.http.GET
import retrofit2.http.Path

interface CoinPaprikaApI {

    @GET("v1/coins")
    suspend fun  getCoins():List<CoinDto>
    @GET("v1/coins/{coinId}")
    suspend fun  getCoinById(@Path("coinId") coinId : String): CoinDetailDto

}