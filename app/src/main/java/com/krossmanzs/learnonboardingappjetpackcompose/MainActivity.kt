package com.krossmanzs.learnonboardingappjetpackcompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
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
    val abrilface = FontFamily(
        Font(R.font.abrilfatface)
    )
    val pacifico = FontFamily(
        Font(R.font.pacifico)
    )


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
                Column(
                    verticalArrangement = Arrangement.Top,
                    horizontalAlignment = Alignment.Start,
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(10.dp)
                ) {
                    Text(
                        text = "Searching for a job?",
                        textAlign = TextAlign.Start,
                        fontFamily = abrilface,
                        fontWeight = FontWeight.Bold,
                        fontSize = 35.sp,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier
                        .padding(bottom = 15.dp)
                    )
                    Text(
                        text = "Undoubtedly you're in the right place",
                        textAlign = TextAlign.Start,
                        fontFamily = pacifico,
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color(0xBAFFFFFF)
                    )
                }
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 100.dp)
                ) {
                    Button(onClick = { /*TODO*/ },
                        border = BorderStroke(2.dp, Color.White),
                        modifier = Modifier
                            .width(150.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = primaryColor
                        )
                    ) {
                        Text(text = "LOGIN", color = Color.White)
                    }
                    Button(onClick = { /*TODO*/ },
                        border = BorderStroke(2.dp, primaryColor),
                        modifier = Modifier
                            .width(150.dp),
                        shape = RoundedCornerShape(8.dp),
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.White
                        )
                    ) {
                        Text(text = "JOIN NOW", color = primaryColor)
                    }
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