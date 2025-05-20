package com.galvezsh.quotes_provider.view

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.galvezsh.quotes_provider.ui.theme.MVVM_1Theme
import com.galvezsh.quotes_provider.viewModel.QuoteViewModel
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import com.galvezsh.quotes_provider.ui.theme.Purple80
import androidx.lifecycle.viewmodel.compose.viewModel


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MVVM_1Theme {
                val quoteViewModel: QuoteViewModel = viewModel()
                Graphics( quoteViewModel )
            }
        }
    }
}

@Composable
fun Graphics(quoteViewModel: QuoteViewModel) {
    val quoteModel by quoteViewModel.quoteModel.collectAsState()

    Box( modifier = Modifier
        .fillMaxSize()
        .background(color = Purple80)
        .padding(16.dp)) {

        IconButton( onClick = { quoteViewModel.randomAdvice() }, modifier = Modifier
            .align(Alignment.BottomEnd)
            .padding(end = 8.dp)
            .padding(bottom = 12.dp)
            .size(48.dp),
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = Color.White
            )) {
            Icon(
                imageVector = Icons.Default.Refresh,
                contentDescription = "Reload",
                tint = Color.Black
            )
        }

        Text(
            text = quoteModel.quote,
            fontSize = 32.sp,
            lineHeight = 32.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier.align(Alignment.Center)
        )

        Text(
            text = quoteModel.author,
            fontSize = 18.sp,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        )
    }
}
