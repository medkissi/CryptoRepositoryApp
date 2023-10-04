package com.medkissi.cryptocurrency

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.medkissi.cryptocurrency.presentation.Screen
import com.medkissi.cryptocurrency.presentation.coin_detail.CoinDetailScreen
import com.medkissi.cryptocurrency.presentation.coin_list.components.CoinListScreen
import com.medkissi.cryptocurrency.presentation.ui.theme.CryptoCurrencyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CryptoCurrencyTheme {

                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = Screen.CoinListScreen.route){
                    composable(Screen.CoinListScreen.route){
                        CoinListScreen(navController = navController)
                    }
                    composable(Screen.CoinScreen.route + "/{coinId}"){
                        CoinDetailScreen()

                    }
                }


            }
        }
    }
}


