package com.example.questnavigasimvvm_142.viewmodel

import com.example.questnavigasimvvm_142.models.DataSiswa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class SiswaViewModel {
    private val _statusUI = MutableStateFlow(DataSiswa())
    val statusUI: StateFlow<DataSiswa> = _statusUI.asStateFlow()

    fun saveDataSiswa(ls: MutableList<String>) {
        _statusUI.update { statusSaatIni ->
            statusSaatIni.copy(
                nama = ls[0],
                gender = ls[1],
                email = ls[2],
                alamat = ls[3],
                notelepon = ls[4]
            )
        }
    }
}