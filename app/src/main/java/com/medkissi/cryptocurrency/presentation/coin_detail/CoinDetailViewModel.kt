package com.medkissi.cryptocurrency.presentation.coin_detail


import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.medkissi.cryptocurrency.domain.model.CoinDetail
import com.medkissi.cryptocurrency.domain.usecases.GetCoinUseCase
import com.medkissi.cryptocurrency.presentation.state.CoinDetailState
import com.medkissi.cryptocurrencyapp.common.Constants
import com.medkissi.cryptocurrencyapp.common.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinDetailViewModel @Inject constructor(
    private val getCoinUseCase: GetCoinUseCase,
    savedStateHandle :SavedStateHandle
    ) :
    ViewModel() {

    var state = MutableStateFlow<CoinDetailState>(CoinDetailState())
        private set

    init {
        savedStateHandle.get<String>(Constants.PARAM_COIN_ID)?.let {  coinId->
            getCoinById(coinId)
        }
    }



    fun getCoinById(coinId:String ) {
        getCoinUseCase(coinId).onEach { resource ->
            when (resource) {
                is Resource.Loading -> {
                    state.value = CoinDetailState(isLoading = true)

                }

                is Resource.Success -> {
                    state.value =
                        CoinDetailState(isLoading = false, coin = resource.data )

                }

                is Resource.Error -> {

                    state.value = CoinDetailState(
                        isLoading = false,
                        error = resource.message ?: "An unexpected error occured "
                    )

                }
            }
        }.launchIn(viewModelScope)

    }

}

