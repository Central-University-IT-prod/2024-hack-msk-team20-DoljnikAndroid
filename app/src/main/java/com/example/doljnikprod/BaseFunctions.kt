package com.example.doljnikprod

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun BackButton(onClick: () -> Unit) {
    Spacer(Modifier.fillMaxWidth().size(5.dp))
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .size(100.dp)
    ) {
        IconButton(modifier = Modifier.size(80.dp),

            onClick = { onClick() }) {
            Icon(Icons.AutoMirrored.Filled.ArrowBack, contentDescription = "", modifier = Modifier.size(35.dp))
        }
    }
}

