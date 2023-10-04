package com.medkissi.cryptocurrency.di

import com.medkissi.cryptocurrency.data.repository.CoinRepositoryImpl
import com.medkissi.cryptocurrency.domain.repository.CoinRepository
import com.medkissi.cryptocurrencyapp.common.Constants
import com.medkissi.cryptocurrencyapp.data.CoinPaprikaApI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module()
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun providesRetrofit():Retrofit =
        Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    @Provides
    @Singleton
    fun providesCoinPaprikaApi(retrofit: Retrofit):CoinPaprikaApI =
        retrofit.create(CoinPaprikaApI::class.java)

    @Provides
    @Singleton
    fun providesCoinRepository(coinPaprikaApI: CoinPaprikaApI):CoinRepository{
        return CoinRepositoryImpl(coinPaprikaApI)
    }

}