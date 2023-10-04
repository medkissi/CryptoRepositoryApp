package com.medkissi.cryptocurrency.presentation

sealed class Screen(val route:String){
    object CoinScreen:Screen("coin_detail")
    object CoinListScreen:Screen("coin_list")
}
