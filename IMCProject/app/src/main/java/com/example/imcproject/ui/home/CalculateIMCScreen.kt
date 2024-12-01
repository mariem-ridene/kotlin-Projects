package com.example.imcproject.ui.home


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import java.util.*
import com.google.firebase.auth.FirebaseAuth




@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalculateIMCScreen(
    onBack: () -> Unit,
    viewModel: CalculateIMCViewModel = androidx.lifecycle.viewmodel.compose.viewModel() // Ajout correct
) {
    var age by remember { mutableStateOf("") }
    var height by remember { mutableStateOf("") }
    var weight by remember { mutableStateOf("") }
    var selectedGender by remember { mutableStateOf("Masculin") }
    var showDialog by remember { mutableStateOf(false) }
    var imcResult by remember { mutableStateOf(0.0) }
    var imcCategory by remember { mutableStateOf("") }

    val userId = FirebaseAuth.getInstance().currentUser?.uid ?: "Invité"

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Calcul IMC") },
                navigationIcon = {
                    IconButton(onClick = { onBack() }) {
                        Icon(Icons.Default.ArrowBack, contentDescription = "Retour")
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(20.dp)
                .fillMaxSize()
        ) {
            OutlinedTextField(
                value = age,
                onValueChange = { age = it },
                label = { Text("Âge") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = height,
                onValueChange = { height = it },
                label = { Text("Taille (cm)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = weight,
                onValueChange = { weight = it },
                label = { Text("Poids (kg)") },
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text("Sexe")
            Row {
                RadioButton(
                    selected = selectedGender == "Masculin",
                    onClick = { selectedGender = "Masculin" }
                )
                Text("Masculin", modifier = Modifier.padding(start = 8.dp))
                Spacer(modifier = Modifier.width(16.dp))
                RadioButton(
                    selected = selectedGender == "Féminin",
                    onClick = { selectedGender = "Féminin" }
                )
                Text("Féminin", modifier = Modifier.padding(start = 8.dp))
            }
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                val heightInMeters = height.toFloat() / 100
                val weightInKg = weight.toFloat()
                imcResult = (weightInKg / (heightInMeters * heightInMeters)).toDouble()
                imcCategory = when {
                    imcResult < 18.5 -> "Insuffisance pondérale"
                    imcResult < 24.9 -> "Poids normal"
                    imcResult < 29.9 -> "Surpoids"
                    else -> "Obésité"
                }

                // Sauvegarde dans Firebase via le ViewModel
                viewModel.saveIMCData(
                    age = age,
                    height = height,
                    weight = weight,
                    gender = selectedGender,
                    imc = imcResult,
                    category = imcCategory,
                    userId = userId
                )
                showDialog = true
            }) {
                Text("Calculer IMC")
            }

            if (showDialog) {
                AlertDialog(
                    onDismissRequest = { showDialog = false },
                    title = { Text("Résultat de l'IMC") },
                    text = {
                        Text("IMC : ${String.format("%.2f", imcResult)} \nCatégorie : $imcCategory")
                    },
                    confirmButton = {
                        TextButton(onClick = { showDialog = false }) {
                            Text("OK")
                        }
                    }
                )
            }
        }
    }
}
