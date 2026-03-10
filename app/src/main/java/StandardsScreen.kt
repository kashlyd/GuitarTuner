package com.example.guitartuner

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun StandardsScreen(innerPadding: PaddingValues) {
    var a4 by remember { mutableStateOf(440f) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = "Tuning Standards",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        ElevatedCard(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(Modifier.padding(18.dp)) {
                Text(
                    text = "Reference Pitch (A4)",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "${a4.roundToInt()} Hz",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))

                Slider(
                    value = a4,
                    onValueChange = { a4 = it },
                    valueRange = 415f..466f
                )

                Spacer(modifier = Modifier.height(8.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    AssistChip(onClick = { a4 = 415f }, label = { Text("415") })
                    AssistChip(onClick = { a4 = 432f }, label = { Text("432") })
                    AssistChip(onClick = { a4 = 440f }, label = { Text("440") })
                    AssistChip(onClick = { a4 = 442f }, label = { Text("442") })
                }
            }
        }

        ElevatedCard(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(Modifier.padding(18.dp)) {
                Text(
                    text = "Temperament",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(8.dp))
                Text("Equal Temperament (default)")
                Text("Advanced temperaments can be added later.")
            }
        }
    }
}