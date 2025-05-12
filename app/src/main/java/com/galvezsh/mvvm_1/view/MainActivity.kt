package com.galvezsh.mvvm_1.view

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
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.galvezsh.mvvm_1.ui.theme.MVVM_1Theme
import com.galvezsh.mvvm_1.viewModel.AdviceViewModel
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import com.galvezsh.mvvm_1.ui.theme.Purple80


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            MVVM_1Theme {
                Graphics( AdviceViewModel() )
            }
        }
    }
}

@Composable
fun Graphics(adviceViewModel: AdviceViewModel) {

    val state by adviceViewModel.adviceModel.observeAsState()

    Box( modifier = Modifier
        .fillMaxSize()
        .background(color = Purple80)
        .padding(16.dp)) {

        IconButton( onClick = { adviceViewModel.randomAdvice() }, modifier = Modifier
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

        state?.let { adviceModel ->

            Text(
                text = adviceModel.advice,
                fontSize = 32.sp,
                lineHeight = 32.sp,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                modifier = Modifier.align(Alignment.Center)
            )

            Text(
                text = adviceModel.author,
                fontSize = 18.sp,
                fontStyle = FontStyle.Italic,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(bottom = 24.dp)
            )
        }
    }
}

@Preview
@Composable
fun Preview() {
    Graphics( AdviceViewModel() )
}
