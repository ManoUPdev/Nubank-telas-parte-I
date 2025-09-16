package com.example.nubank

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NubankMainApp()
        }
    }
}

@Composable
fun NubankMainApp() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF7B1FA2))
            ) {
                NubankMainScreen()
            }
        }
    }
}

@Composable
fun NubankMainScreen() {
    val scroll = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(scroll)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        // Top Bar
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "R$ 5.000,00",
                fontSize = 24.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                modifier = Modifier.weight(1f)
            )
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(Color.White.copy(alpha = 0.3f), CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text("P", color = Color.White, fontWeight = FontWeight.Bold)
            }
        }

        // Card do Cartão
        ElevatedCard(
            shape = RoundedCornerShape(16.dp),
            modifier = Modifier.fillMaxWidth(),
            colors = CardDefaults.elevatedCardColors(containerColor = Color(0xFF8A05BE))
        ) {
            Column(Modifier.padding(16.dp)) {
                Text("Cartão Nubank", fontWeight = FontWeight.SemiBold, fontSize = 16.sp, color = Color.White)
                Spacer(Modifier.height(8.dp))
                Text("•••• 1234", fontWeight = FontWeight.Bold, fontSize = 24.sp, color = Color.White)
                Spacer(Modifier.height(12.dp))
                Button(
                    onClick = { /* Sem ação */ },
                    colors = ButtonDefaults.buttonColors(containerColor = Color.White)
                ) {
                    Text("Ver fatura", color = Color(0xFF8A05BE))
                }
            }
        }

        // Ações rápidas
        val scrollHorizontal = rememberScrollState()
        Row(
            modifier = Modifier
                .horizontalScroll(scrollHorizontal)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            QuickActionCard("Pagar")
            QuickActionCard("Transferir")
            QuickActionCard("Recarga")
            QuickActionCard("Cobrar")
        }

        // Histórico de transações
        Text("Últimas transações", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.White)
        TransactionCard("Mercado", "Compra com cartão", "- R$ 120,00")
        TransactionCard("Netflix", "Assinatura", "- R$ 34,90")
        TransactionCard("Salário", "Crédito", "+ R$ 2.500,00")
    }
}

@Composable
fun QuickActionCard(name: String) {
    ElevatedCard(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.size(100.dp),
        colors = CardDefaults.elevatedCardColors(containerColor = Color.White.copy(alpha = 0.1f))
    ) {
        Box(contentAlignment = Alignment.Center, modifier = Modifier.fillMaxSize()) {
            Text(name, color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)
        }
    }
}

@Composable
fun TransactionCard(title: String, subtitle: String, value: String) {
    ElevatedCard(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.elevatedCardColors(containerColor = Color.White.copy(alpha = 0.1f))
    ) {
        Row(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column {
                Text(title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
                Text(subtitle, color = Color.White.copy(alpha = 0.8f), fontSize = 12.sp)
            }
            Text(value, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 16.sp)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNubankMain() {
    NubankMainApp()
}
