package com.medkissi.cryptocurrency.domain.usecases

import com.medkissi.cryptocurrency.domain.repository.CoinRepository
import com.medkissi.cryptocurrencyapp.common.Resource
import com.medkissi.cryptocurrencyapp.domain.model.Coin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetCoinsUseCase @Inject constructor (private val repository: CoinRepository) {

    operator fun invoke():Flow<Resource<List<Coin>>>{
        return  flow {

            try {
                emit(Resource.Loading())
                val data = repository.getCoins()
                emit(Resource.Success(data))

            }catch (e:HttpException){
                emit(Resource.Error(e.message()))

            }catch (e:IOException){
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occured"))

            }
        }


    }
}