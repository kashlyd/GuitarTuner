package com.example.guitartuner

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun PresetsScreen(innerPadding: PaddingValues) {
    val presets = listOf(
        "Standard (EADGBE)" to "E2  A2  D3  G3  B3  E4",
        "Drop D (DADGBE)" to "D2  A2  D3  G3  B3  E4",
        "Half-step Down" to "Eb2  Ab2  Db3  Gb3  Bb3  Eb4",
        "Open G" to "D2  G2  D3  G3  B3  D4",
        "DADGAD" to "D2  A2  D3  G3  A3  D4"
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp)
    ) {
        Text(
            text = "Tuning Presets",
            style = MaterialTheme.typography.headlineSmall,
            fontWeight = FontWeight.Bold
        )

        Spacer(modifier = Modifier.height(12.dp))

        LazyColumn(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            items(presets) { preset ->
                ElevatedCard(
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(16.dp)
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text(
                            text = preset.first,
                            style = MaterialTheme.typography.titleMedium,
                            fontWeight = FontWeight.Bold
                        )

                        Spacer(modifier = Modifier.height(8.dp))

                        Text(preset.second)

                        Spacer(modifier = Modifier.height(12.dp))

                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Button(onClick = {}) {
                                Text("Use")
                            }
                            OutlinedButton(onClick = {}) {
                                Text("★")
                            }
                        }
                    }
                }
            }
        }
    }
}