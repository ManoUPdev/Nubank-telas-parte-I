package com.example.nubankk
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InvestimentosApp()
        }
    }
}

@Composable
fun InvestimentosApp() {
    MaterialTheme {
        Surface(modifier = Modifier.fillMaxSize()) {

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF7B1FA2))
            ) {
                InvestimentosScreen()
            }
        }
    }
}

@Composable
fun InvestimentosScreen() {
    val scroll = rememberScrollState()
    Column(
        modifier = Modifier
            .verticalScroll(scroll)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            "Investimentos",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
        Text(
            "Seu dinheiro rendendo de verdade",
            fontSize = 14.sp,
            color = Color.White.copy(alpha = 0.9f)
        )

        Spacer(Modifier.height(8.dp))


        FeatureCardInvestimentos(
            title = "Investimentos",
            subtitle = "Patrimônio acumulado",
            value = "R$ 0,00",
            options = listOf("Explorar", "Aprender", "Simular")
        )


        FeatureCardMenu("Tesouro Direto", "Renda fixa do governo", listOf("Ver opções", "Simular"))
        FeatureCardMenu("CDBs", "Renda fixa de bancos", listOf("Explorar", "Simular"))
        FeatureCardMenu("Fundos de Investimento", "Diversificação de carteira", listOf("Explorar", "Aprender"))
        FeatureCardMenu("Renda Variável", "Ações e ETFs", listOf("Explorar", "Simular"))
    }
}

@Composable
fun FeatureCardInvestimentos(
    title: String,
    subtitle: String,
    value: String,
    options: List<String>
) {
    ElevatedCard(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.elevatedCardColors(containerColor = Color(830082 ))
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(title, fontWeight = FontWeight.SemiBold, fontSize = 20.sp, color = Color.White)
            Text(subtitle, fontSize = 12.sp, color = Color.White.copy(alpha = 0.8f))
            Spacer(Modifier.height(8.dp))
            Text(value, fontSize = 20.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Spacer(Modifier.height(12.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                options.forEach { opt ->
                    OutlinedButton(
                        onClick = { /* sem ação */ },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
                    ) {
                        Text(opt, fontSize = 12.sp)
                    }
                }
            }
        }
    }
}

@Composable
fun FeatureCardMenu(
    title: String,
    subtitle: String,
    options: List<String>
) {
    ElevatedCard(
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.elevatedCardColors(containerColor = Color(830082 ))
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(title, fontWeight = FontWeight.SemiBold, fontSize = 18.sp, color = Color.White)
            Text(subtitle, fontSize = 12.sp, color = Color.White.copy(alpha = 0.8f))
            Spacer(Modifier.height(8.dp))
            Row(
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = Modifier.fillMaxWidth()
            ) {
                options.forEach { opt ->
                    OutlinedButton(
                        onClick = { /* sem ação */ },
                        shape = RoundedCornerShape(12.dp),
                        modifier = Modifier.weight(1f),
                        colors = ButtonDefaults.outlinedButtonColors(contentColor = Color.White)
                    ) {
                        Text(opt, fontSize = 12.sp)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewInvestimentos() {
    InvestimentosApp()
}
