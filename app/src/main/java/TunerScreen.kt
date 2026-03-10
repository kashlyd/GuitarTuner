package com.example.guitartuner

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import kotlin.math.abs

@Composable
fun TunerScreen(innerPadding: PaddingValues) {
    var detectedNote by remember { mutableStateOf("E") }
    var octave by remember { mutableStateOf(2) }
    var frequency by remember { mutableStateOf(82.41f) }
    var cents by remember { mutableStateOf(-12) }

    val strings = listOf("E2", "A2", "D3", "G3", "B3", "E4")
    val inTune = abs(cents) <= 3

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        ElevatedCard(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(Modifier.padding(18.dp)) {
                Row(verticalAlignment = Alignment.Bottom) {
                    Text(
                        text = detectedNote,
                        style = MaterialTheme.typography.displayLarge,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Spacer(modifier = Modifier.width(8.dp))
                    Text(
                        text = octave.toString(),
                        style = MaterialTheme.typography.headlineMedium
                    )
                }

                Spacer(modifier = Modifier.height(6.dp))

                Text("${"%.2f".format(frequency)} Hz")

                Spacer(modifier = Modifier.height(8.dp))

                AssistChip(
                    onClick = {},
                    label = {
                        Text(
                            if (inTune) "IN TUNE"
                            else if (cents < 0) "FLAT"
                            else "SHARP"
                        )
                    }
                )
            }
        }

        ElevatedCard(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(16.dp)
        ) {
            Column(Modifier.padding(18.dp)) {
                Text(
                    text = "Cents Meter",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(10.dp))

                CentsGauge(cents)

                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    text = "$cents¢",
                    style = MaterialTheme.typography.titleLarge,
                    fontWeight = FontWeight.Bold
                )

                Spacer(modifier = Modifier.height(12.dp))

                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedButton(onClick = { cents -= 5 }) { Text("-5") }
                    OutlinedButton(onClick = { cents -= 1 }) { Text("-1") }
                    Button(onClick = { cents = 0 }) { Text("Center") }
                    OutlinedButton(onClick = { cents += 1 }) { Text("+1") }
                    OutlinedButton(onClick = { cents += 5 }) { Text("+5") }
                }
            }
        }

        Text(
            text = "Target Strings",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        LazyRow(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            items(strings) { item ->
                AssistChip(
                    onClick = {},
                    label = { Text(item) }
                )
            }
        }

        Text(
            text = "Demo Notes",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )

        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
            OutlinedButton(onClick = {
                detectedNote = "E"; octave = 2; frequency = 82.41f
            }) { Text("E2") }

            OutlinedButton(onClick = {
                detectedNote = "A"; octave = 2; frequency = 110.00f
            }) { Text("A2") }

            OutlinedButton(onClick = {
                detectedNote = "D"; octave = 3; frequency = 146.83f
            }) { Text("D3") }
        }
    }
}

@Composable
fun CentsGauge(cents: Int) {
    val clamped = cents.coerceIn(-50, 50)
    val inTune = abs(clamped) <= 3
    val xRatio = (clamped + 50) / 100f

    val onSurfaceVariant = MaterialTheme.colorScheme.onSurfaceVariant
    val primary = MaterialTheme.colorScheme.primary
    val error = MaterialTheme.colorScheme.error

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
            .background(
                MaterialTheme.colorScheme.surfaceVariant,
                RoundedCornerShape(12.dp)
            )
            .padding(12.dp)
    ) {
        Canvas(modifier = Modifier.fillMaxSize()) {
            val midY = size.height * 0.55f
            val leftX = size.width * 0.08f
            val rightX = size.width * 0.92f
            val centerX = (leftX + rightX) / 2f
            val needleX = leftX + (rightX - leftX) * xRatio

            drawLine(
                color = onSurfaceVariant,
                start = Offset(leftX, midY),
                end = Offset(rightX, midY),
                strokeWidth = 10f
            )

            drawLine(
                color = onSurfaceVariant,
                start = Offset(centerX, midY - 24f),
                end = Offset(centerX, midY + 24f),
                strokeWidth = 6f
            )

            drawLine(
                color = if (inTune) primary else error,
                start = Offset(needleX, midY - 28f),
                end = Offset(needleX, midY + 28f),
                strokeWidth = 8f
            )
        }

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text("-50")
            Text("0", fontWeight = FontWeight.Bold)
            Text("+50")
        }
    }
}
