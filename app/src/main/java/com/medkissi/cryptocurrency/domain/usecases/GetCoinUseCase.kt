package com.medkissi.cryptocurrency.domain.usecases

import com.medkissi.cryptocurrency.domain.model.CoinDetail
import com.medkissi.cryptocurrency.domain.repository.CoinRepository
import com.medkissi.cryptocurrencyapp.common.Resource
import com.medkissi.cryptocurrencyapp.domain.model.Coin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinUseCase @Inject constructor (private val coinRepository: CoinRepository){
    operator  fun invoke(coinId:String):Flow<Resource<CoinDetail>>{
        return  flow{
            try {
                emit(Resource.Loading())
                val coin = coinRepository.getCoinById(coinId)
                emit(Resource.Success(coin))

            }catch (e:HttpException){
                emit(Resource.Error(e.localizedMessage ?: " An unexpected error occured"))

            }
            catch (e:IOException){
                emit(Resource.Error("Couldn't contact the server "))


            }


        }
    }
}