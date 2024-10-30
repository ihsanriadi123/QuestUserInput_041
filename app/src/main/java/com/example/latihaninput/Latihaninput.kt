package com.example.latihainput

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

data class FormState(
    var nama: String = "",
    var email: String = "",
    var alamat: String = "",
    var noTelepon: String = "",
    var memilihJK: String = ""
)

@Preview(showBackground = true)
@Composable
fun LatihanInput(modifier: Modifier = Modifier) {
    var formState by remember { mutableStateOf(FormState()) }
    val listJK = listOf("Laki-Laki", "Perempuan")
    var savedForm by remember { mutableStateOf(FormState()) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Biodata",
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )

        TextField(
            value = formState.nama,
            onValueChange = { formState = formState.copy(nama = it) },
            label = { Text(text = "Nama") },
            placeholder = { Text(text = "Isi nama anda") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        Row(modifier = Modifier.fillMaxWidth()) {
            listJK.forEach { selectedGender ->
                Row(verticalAlignment = Alignment.CenterVertically) {
                    RadioButton(
                        selected = formState.memilihJK == selectedGender,
                        onClick = { formState = formState.copy(memilihJK = selectedGender) }
                    )
                    Text(text = selectedGender)
                }
            }
        }

        TextField(
            value = formState.email,
            onValueChange = { formState = formState.copy(email = it) },
            label = { Text(text = "Email") },
            placeholder = { Text(text = "Isi email anda") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        TextField(
            value = formState.alamat,
            onValueChange = { formState = formState.copy(alamat = it) },
            label = { Text(text = "Alamat") },
            placeholder = { Text(text = "Isi alamat anda") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp)
        )

        TextField(
            value = formState.noTelepon,
            onValueChange = { formState = formState.copy(noTelepon = it) },
            label = { Text(text = "No Telepon") },
            placeholder = { Text(text = "Isi No Telepon anda") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(5.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Button(onClick = { savedForm = formState }) {
            Text(text = "Simpan")
        }

        DetailMessage(param = "Nama", argum = savedForm.nama)
        DetailMessage(param = "Email", argum = savedForm.email)
        DetailMessage(param = "Alamat", argum = savedForm.alamat)
        DetailMessage(param = "No Telepon", argum = savedForm.noTelepon)
        DetailMessage(param = "Jenis Kelamin", argum = savedForm.memilihJK)
    }
}

@Composable
fun DetailMessage(param: String, argum: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = param, modifier = Modifier.weight(0.8f))
            Text(text = ":", modifier = Modifier.weight(0.2f))
            Text(text = argum, modifier = Modifier.weight(2f))
        }
    }
}