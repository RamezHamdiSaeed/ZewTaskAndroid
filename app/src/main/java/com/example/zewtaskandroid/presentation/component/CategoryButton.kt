package com.example.zewtaskandroid.presentation.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.zewtaskandroid.R

@Composable
fun CategoryButton(title: String, imageName: String) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .background(Color.Yellow.copy(alpha = if (title == "All") 1f else 0.2f), RoundedCornerShape(30.dp))
            .padding(horizontal = 16.dp, vertical = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            painter = painterResource(getImageId(imageName)),
            contentDescription = null,
            modifier = Modifier
                .size(40.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(title, fontWeight = FontWeight.Bold)
    }
}

fun getImageId(name: String): Int {
    return when (name.lowercase()) {
        "maple-french-toast-thumb" -> R.drawable.cheese_toastie_thumb
        // Add other mappings here
        else -> R.drawable.cheese_toastie_thumb
    }
}