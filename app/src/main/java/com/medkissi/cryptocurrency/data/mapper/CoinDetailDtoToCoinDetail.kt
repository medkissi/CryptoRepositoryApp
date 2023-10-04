package com.medkissi.cryptocurrency.data.mapper

import com.medkissi.cryptocurrency.data.dto.CoinDetailDto
import com.medkissi.cryptocurrency.domain.model.CoinDetail


fun CoinDetailDto.toCoinDetail():CoinDetail{
    return CoinDetail(
        coinId = id,
        name = name,
        description = description,
        symbol = symbol,
        rank =rank,
        isActive = isActive,
        tags = tags.map { it.name },
        team =team.map { it.toTeamMember() }

    )
}