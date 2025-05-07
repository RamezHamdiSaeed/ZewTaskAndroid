package com.example.zewtaskandroid.presentation.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.zewtaskandroid.data.model.MenuSection
import com.example.zewtaskandroid.utils.loadJsonAsset
import com.example.zewtaskandroid.presentation.component.CategoryButton
import com.example.zewtaskandroid.presentation.component.DishRow

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen() {
    val context = LocalContext.current
    val menuSections: List<MenuSection> = remember {
        context.loadJsonAsset("menu.json")
    }
    var searchText by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Column {
                        Text("DELIVER TO", style = MaterialTheme.typography.labelSmall, color = Color(0xFFFF9800))
                        Text("Ramez Office", style = MaterialTheme.typography.bodySmall)
                    }
                },
                navigationIcon = {
                    Icon(
                        imageVector = Icons.Default.Menu,
                        contentDescription = null,
                        modifier = Modifier
                            .padding(12.dp)
                            .background(Color.LightGray, shape = CircleShape)
                            .padding(10.dp)
                    )
                },
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .verticalScroll(rememberScrollState())
                .padding(16.dp)
        ) {
            // Welcome Message
            Text("Zeew,", color = Color.Green)
            Row {
                Text("Hey Ramez, ", style = MaterialTheme.typography.bodyLarge)
                Text("Good Afternoon!", style = MaterialTheme.typography.bodyLarge.copy(fontWeight = FontWeight.Bold))
            }

            Spacer(Modifier.height(12.dp))

            // Search field
            OutlinedTextField(
                value = searchText,
                onValueChange = { searchText = it },
                placeholder = { Text("Search dishes") },
                leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(10.dp),
                colors = OutlinedTextFieldDefaults.colors( // ✅ use this in Material3
                    focusedContainerColor = Color.LightGray.copy(alpha = 0.2f),
                    unfocusedContainerColor = Color.LightGray.copy(alpha = 0.1f)
                )
            )

            Spacer(Modifier.height(20.dp))

            // All Categories
            Text("All Categories", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            LazyRow {
                items(menuSections) { section ->
                    section.items.firstOrNull()?.let { item ->
                        CategoryButton(title = section.name, imageName = item.thumbnailImage)
                    }
                }
            }

            Spacer(Modifier.height(20.dp))

            // Trending Dishes
            Text("Trending", style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
            Column {
                menuSections.forEach { section ->
                    section.items.forEach { item ->
                        DishRow(item)
                    }
                }
            }
        }
    }
}