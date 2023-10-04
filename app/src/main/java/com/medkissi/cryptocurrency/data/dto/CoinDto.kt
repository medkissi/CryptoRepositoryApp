package com.medkissi.cryptocurrencyapp.data.dto

data class CoinDto (
    val id:String,
    val isActive:Boolean,
    val isNew:Boolean,
    val name :String,
    val rank:Int,
    val symbol : String,
    val type:String

        )