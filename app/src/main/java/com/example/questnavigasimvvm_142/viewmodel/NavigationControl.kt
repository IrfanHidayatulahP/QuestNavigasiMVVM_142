package com.example.questnavigasimvvm_142.viewmodel

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.questnavigasimvvm_142.models.JenisKelamin
import com.example.questnavigasimvvm_142.ui.view.FormulirView
import com.example.questnavigasimvvm_142.ui.view.TampilDataView


enum class Halaman {
    FORMULIR,
    TAMPILDATA
}

@Composable
fun NavigationControl(
    viewModel: SiswaViewModel = viewModel(),
    navHost: NavHostController = rememberNavController(),
    modifier: Any
) {
    val uiState by viewModel.statusUI.collectAsState()
    NavHost(
        navController = navHost,
        startDestination = Halaman.FORMULIR.name
    ) {
        composable(
            route = Halaman.FORMULIR.name
        ){
            val konteks = LocalContext.current
            FormulirView(
                listJK = JenisKelamin.JenisK.map { id -> konteks.getString(id) },
                onSubmitClicked = {
                    viewModel.saveDataSiswa(it)
                    navHost.navigate(Halaman.TAMPILDATA.name)
                }
            )
        }

        composable(route = Halaman.TAMPILDATA.name) {
            TampilDataView(
                uiState = uiState,
                onBackButton = { navHost.popBackStack() }
            )
        }
    }
}
