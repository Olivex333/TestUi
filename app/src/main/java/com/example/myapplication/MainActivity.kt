package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.myapplication.model.ServiceModel
import com.example.myapplication.model.UiState

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun GirlsProfilesStatic(uiState: UiState) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Girls Profiles") },
                actions = {
                    IconButton(onClick = {}) {
                        Icon(Icons.Default.Close, contentDescription = "Close")
                    }
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .padding(padding)
                .fillMaxSize()
        ) {
            Column(Modifier.padding(4.dp)) {
                val actions = listOf(
                    "Profiles", "Reports", "Ristorante", "Tax",
                    "Whatsapp Manager", "History Shifts", "Close / Open Shift"
                )
                actions.chunked(4).forEach { row ->
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.spacedBy(4.dp)
                    ) {
                        row.forEach {
                            Button(
                                onClick = {},
                                modifier = Modifier
                                    .weight(1f)
                                    .height(40.dp),
                                contentPadding = PaddingValues(2.dp)
                            ) {
                                Text(
                                    it,
                                    maxLines = 2,
                                    softWrap = false,
                                    overflow = TextOverflow.Clip,
                                    style = MaterialTheme.typography.caption
                                )
                            }
                        }
                    }
                    Spacer(Modifier.height(4.dp))
                }
            }

            Row(modifier = Modifier.weight(1f)) {
                Card(
                    modifier = Modifier
                        .weight(3f)
                        .fillMaxHeight()
                ) {
                    Column {
                        Text(
                            "SERVICE LISTS",
                            modifier = Modifier.padding(4.dp),
                            style = MaterialTheme.typography.caption
                        )
                        Divider()
                        LazyColumn {
                            items(uiState.services) {
                                Text(
                                    "${it.name} – ${it.cost}",
                                    Modifier.padding(4.dp),
                                    style = MaterialTheme.typography.caption
                                )
                            }
                        }
                    }
                }
                Spacer(Modifier.width(4.dp))
                Card(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {
                    Column {
                        Text(
                            "Minus shift :",
                            modifier = Modifier.padding(4.dp),
                            style = MaterialTheme.typography.caption
                        )
                        Divider()
                        Box(
                            Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(uiState.minusShift, style = MaterialTheme.typography.caption)
                        }
                    }
                }
            }

            Spacer(Modifier.height(4.dp))

            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp),
                color = MaterialTheme.colors.primary.copy(alpha = 0.1f)
            ) {
                Box(
                    Modifier.fillMaxSize(),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = String.format("%.2f", uiState.totalCost),
                        style = MaterialTheme.typography.h5,
                        fontFamily = FontFamily.Monospace
                    )
                }
            }

            Spacer(Modifier.height(4.dp))

            Column(Modifier.fillMaxWidth().padding(4.dp)) {
                Text("ADD NEW GIRL", style = MaterialTheme.typography.caption)
                Spacer(Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("Name:", style = MaterialTheme.typography.caption)
                    OutlinedTextField(
                        value = uiState.currentName,
                        onValueChange = {},
                        modifier = Modifier
                            .weight(1f)
                            .padding(horizontal = 4.dp),
                        textStyle = MaterialTheme.typography.caption
                    )
                    Button(onClick = {}, contentPadding = PaddingValues(2.dp)) {
                        Text("Add", style = MaterialTheme.typography.caption)
                    }
                    Spacer(Modifier.width(2.dp))
                    Button(onClick = {}, contentPadding = PaddingValues(2.dp)) {
                        Text("Delete", style = MaterialTheme.typography.caption)
                    }
                    Spacer(Modifier.width(2.dp))
                    Button(onClick = {}, contentPadding = PaddingValues(2.dp)) {
                        Text("Edit Girl", style = MaterialTheme.typography.caption)
                    }
                }

                Spacer(Modifier.height(4.dp))

                LazyVerticalGrid(
                    columns = GridCells.Fixed(5),
                    horizontalArrangement = Arrangement.spacedBy(2.dp),
                    verticalArrangement = Arrangement.spacedBy(2.dp),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    items(uiState.girls) {
                        OutlinedButton(
                            onClick = {},
                            modifier = Modifier.fillMaxWidth(),
                            contentPadding = PaddingValues(2.dp)
                        ) {
                            Text(
                                it,
                                maxLines = 1,
                                overflow = TextOverflow.Ellipsis,
                                style = MaterialTheme.typography.caption
                            )
                        }
                    }
                }
            }

            Spacer(Modifier.height(4.dp))

            LazyVerticalGrid(
                columns = GridCells.Fixed(6),
                horizontalArrangement = Arrangement.spacedBy(2.dp),
                verticalArrangement = Arrangement.spacedBy(2.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            ) {
                val buttons = listOf(
                    "1", "2", "3", "TWINT", "1h 150", "EXTRA SERVICE",
                    "4", "5", "6", "CARD", "30 min 110", "Manual Service",
                    "7", "8", "9", "CLEAR", "15min 100", "Chf/Eur"
                )
                items(buttons) { label ->
                    Button(
                        onClick = {},
                        modifier = Modifier
                            .fillMaxWidth()
                            .aspectRatio(1f),
                        contentPadding = PaddingValues(2.dp)
                    ) {
                        Text(
                            label,
                            maxLines = 2,
                            softWrap = false,
                            overflow = TextOverflow.Clip,
                            style = MaterialTheme.typography.caption
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360, heightDp = 800)
@Composable
fun PreviewFullUI() {
    val dummy = UiState(
        selectedTab = 0,
        services = listOf(
            ServiceModel("1h 150", 150.0),
            ServiceModel("30min 110", 110.0),
            ServiceModel("15min 100", 100.0),
            ServiceModel("1h 250", 250.0),
            ServiceModel("TWINT", 0.0),
            ServiceModel("CARD", 0.0),
            ServiceModel("EXTRA SERVICE", 0.0),
            ServiceModel("Manual Service", 0.0),
            ServiceModel("Chf/Eur", 0.0)
        ),
        minusShift = "-",
        totalCost = 123456789.12,
        currentName = "",
        girls = listOf(
            "ANNA", "SOFIA", "ELLIE", "ANA", "OLIVIA",
            "LISA", "DIANA", "JESS", "SONIA", "ALORA",
            "INNA", "DOMKA", "OLGA", "ELLA", "KASIA"
        )
    )
    GirlsProfilesStatic(dummy)
}

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PreviewFullUI()
        }
    }
}
