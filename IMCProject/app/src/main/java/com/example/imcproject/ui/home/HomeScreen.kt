package com.example.imcproject.ui.home



import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*

import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.shape.RoundedCornerShape


@Composable
fun HomeScreen(
    fullName: String,
    weight: String,
    height: String,
    sex: String,
    previousIMCs: List<Float>,
    onCalculateIMC: () -> Unit,
    onAboutIMC: () -> Unit
) {
    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Header avec message d'accueil
            Text(
                text = "Bienvenue, $fullName",
                style = MaterialTheme.typography.headlineLarge,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 24.dp)
            )

            // Informations actuelles dans une carte
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text(
                        text = "Vos informations actuelles",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(bottom = 12.dp)
                    )
                    Text(text = "Poids : $weight kg", style = MaterialTheme.typography.bodyLarge)
                    Text(text = "Taille : $height cm", style = MaterialTheme.typography.bodyLarge)
                    Text(text = "Sexe : $sex", style = MaterialTheme.typography.bodyLarge)
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Analyse des derniers IMC
            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(16.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ) {
                    Text(
                        text = "Analyse des derniers IMC",
                        style = MaterialTheme.typography.titleMedium,
                        modifier = Modifier.padding(bottom = 12.dp)
                    )
                    // Composant graphique
                    AnalysisGraph(imcData = previousIMCs)
                }
            }

            // Boutons en bas
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 20.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Button(
                    onClick = onCalculateIMC,
                    modifier = Modifier.weight(1f).padding(end = 10.dp),
                    shape = RoundedCornerShape(50) // Bouton arrondi
                ) {
                    Text("Calculer IMC", fontSize = 16.sp)
                }
                Button(
                    onClick = onAboutIMC,
                    modifier = Modifier.weight(1f).padding(start = 10.dp),
                    shape = RoundedCornerShape(50) // Bouton arrondi
                ) {
                    Text("À propos d'IMC", fontSize = 16.sp)
                }
            }
        }
    }
}

