package com.example.questnavigasimvvm_142.ui.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.questnavigasimvvm_142.models.DataSiswa

@Composable
fun TampilDataView(
    modifier: Modifier = Modifier,
    uiState: DataSiswa,
    onBackButton: () -> Boolean
) {
    Column(
        modifier = modifier.padding(16.dp) // Apply the modifier with padding here
    ) {
        TampilData(param = "Nama", argu = uiState.nama)
        TampilData(param = "Jenis Kelamin", argu = uiState.gender)
        TampilData(param = "Email", argu = uiState.email)
        TampilData(param = "Alamat", argu = uiState.alamat)
        TampilData(param = "No Telepon", argu = uiState.notelepon)

        Button(onClick = { onBackButton() }) {
            Text(text = "Kembali")
        }
    }
}
