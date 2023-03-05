package com.krossmanzs.learnonboardingappjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.krossmanzs.learnonboardingappjetpackcompose.ui.theme.LearnOnboardingAppJetpackComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainLayout()
        }
    }
}

@Composable
fun MainLayout() {

    val primaryColor = Color(26,32,53,255)

    LearnOnboardingAppJetpackComposeTheme {
        // A surface container using the 'background' color from the theme
        Surface(
            color = MaterialTheme.colors.background
        ) {
            Column(
                modifier = Modifier
                    .background(color = primaryColor)
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 100.dp)
                ) {
                    Image(
                        painter = painterResource(R.drawable.ic_baseline_accessible_24),
                        contentDescription = null,
                        alignment = Alignment.TopEnd,
                        modifier = Modifier
                            .size(300.dp)
                    )
                }
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                    modifier = Modifier
                        .fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier
                        .background(color = Color.White)
                        .height(3.dp)
                        .width(150.dp)
                        .padding(bottom = 20.dp)
                    )
                    Spacer(modifier = Modifier
                        .padding(bottom = 20.dp)
                    )
                    Spacer(modifier = Modifier
                        .background(color = Color.White)
                        .height(3.dp)
                        .width(240.dp)
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    LearnOnboardingAppJetpackComposeTheme {
        MainLayout()
    }
}