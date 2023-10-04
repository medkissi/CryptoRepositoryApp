package com.medkissi.cryptocurrency.domain.repository

import com.medkissi.cryptocurrency.domain.model.CoinDetail
import com.medkissi.cryptocurrencyapp.domain.model.Coin

interface CoinRepository {
    suspend fun  getCoins():List<Coin>
    suspend fun  getCoinById(coinId:String):CoinDetail
}
