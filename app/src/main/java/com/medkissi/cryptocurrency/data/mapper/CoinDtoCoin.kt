package com.medkissi.cryptocurrencyapp.data.mapper

import com.medkissi.cryptocurrencyapp.data.dto.CoinDto
import com.medkissi.cryptocurrencyapp.domain.model.Coin

fun  CoinDto.toCoin(): Coin{
    return Coin(
        id = id ,
        isActive = isActive,
        name = name,
        rank = rank,
        symbol = symbol
    )
}