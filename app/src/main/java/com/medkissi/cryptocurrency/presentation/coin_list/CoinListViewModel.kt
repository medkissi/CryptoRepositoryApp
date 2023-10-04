package com.medkissi.cryptocurrency.presentation.coin_list


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.medkissi.cryptocurrency.domain.usecases.GetCoinsUseCase
import com.medkissi.cryptocurrency.presentation.state.CoinListState
import com.medkissi.cryptocurrencyapp.common.Resource
import com.medkissi.cryptocurrencyapp.domain.model.Coin
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CoinListViewModel @Inject constructor(private val getCoinsUseCase: GetCoinsUseCase) :
    ViewModel() {

    var state = MutableStateFlow<CoinListState>(CoinListState())
        private set

    init {
        getCoins()
    }

    fun getCoins() {
        getCoinsUseCase().onEach { resource ->
            when (resource) {
                is Resource.Loading -> {
                    state.value = CoinListState(isLoading = true)

                }

                is Resource.Success -> {
                    state.value =
                        CoinListState(isLoading = false, coins = resource.data ?: emptyList())

                }

                is Resource.Error -> {

                    state.value = CoinListState(
                        isLoading = false,
                        error = resource.message ?: "An unexpected error occured "
                    )

                }
            }
        }.launchIn(viewModelScope)

    }

}

