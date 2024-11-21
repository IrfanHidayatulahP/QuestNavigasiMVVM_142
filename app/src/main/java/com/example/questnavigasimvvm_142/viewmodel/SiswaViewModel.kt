package com.example.questnavigasimvvm_142.viewmodel

import androidx.lifecycle.ViewModel
import com.example.questnavigasimvvm_142.models.DataSiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SiswaViewModel : ViewModel(){
    private val _statusUI = MutableStateFlow(DataSiswa())
    val statusUI: StateFlow<DataSiswa> = _statusUI.asStateFlow()

    fun saveDataSiswa(ls: MutableList<String>) {
        _statusUI.update { statusSaatIni ->
            statusSaatIni.copy(
                nim = ls[0],
                nama = ls[1],
                gender = ls[2],
                email = ls[3],
                alamat = ls[4],
                notelepon = ls[5]
            )
        }
    }
}