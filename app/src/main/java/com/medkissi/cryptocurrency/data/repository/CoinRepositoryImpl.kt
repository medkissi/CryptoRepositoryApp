package com.medkissi.cryptocurrency.data.repository

import com.medkissi.cryptocurrency.data.mapper.toCoinDetail
import com.medkissi.cryptocurrency.domain.model.CoinDetail
import com.medkissi.cryptocurrency.domain.repository.CoinRepository
import com.medkissi.cryptocurrencyapp.data.CoinPaprikaApI
import com.medkissi.cryptocurrencyapp.data.mapper.toCoin
import com.medkissi.cryptocurrencyapp.domain.model.Coin
import javax.inject.Inject

class CoinRepositoryImpl @Inject constructor ( private val api:CoinPaprikaApI): CoinRepository {
    override suspend fun getCoins(): List<Coin> {
        return  api.getCoins().map { it.toCoin() }
    }

    override suspend fun getCoinById(coinId: String): CoinDetail {
       return api.getCoinById(coinId).toCoinDetail()
    }
}