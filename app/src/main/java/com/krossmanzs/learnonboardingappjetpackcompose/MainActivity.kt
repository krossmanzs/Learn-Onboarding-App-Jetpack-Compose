package com.krossmanzs.learnonboardingappjetpackcompose

import android.os.Bundle
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.view.ViewCompat
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.krossmanzs.learnonboardingappjetpackcompose.ui.theme.LearnOnboardingAppJetpackComposeTheme

class MainActivity : ComponentActivity() {

    private val primaryColor = Color(26,32,53,255)
    private val secondaryColor = Color(54, 66, 111, 255)
    private val abrilface = FontFamily(
        Font(R.font.abrilfatface)
    )
    private val pacifico = FontFamily(
        Font(R.font.pacifico)
    )
    private val onBoardingNav = "onBoardingScreen"
    private val loginNav = "loginScreen"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            BaseLayout()
        }
    }

    @Composable
    fun BaseLayout() {
        val naviController = rememberNavController()

        NavHost(navController = naviController, startDestination = onBoardingNav) {
            composable(route = onBoardingNav) {
                MainLayout(naviController)
            }
            composable(route = loginNav) {
                LoginLayout(naviController)
            }
        }

    }

    @Composable
    fun MainLayout(naviController: NavController) {
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
                        Button(onClick = { naviController.navigate(loginNav) },
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

    @Composable
    fun LoginLayout(naviController: NavController) {
        val inputStyle = TextFieldDefaults.textFieldColors(
            textColor = Color.White,
            cursorColor = Color.White,
            focusedLabelColor = Color.White,
            backgroundColor = primaryColor,
            placeholderColor = Color.White,
            unfocusedLabelColor = Color.White,
            unfocusedIndicatorColor = Color.White
        )

        LearnOnboardingAppJetpackComposeTheme {
            val imeState = rememberImeState()
            val scrollState = rememberScrollState()

            LaunchedEffect(key1 = imeState.value) {
                if(imeState.value) {
                    scrollState.scrollTo(scrollState.maxValue)
                }
            }

            Surface(
                color = MaterialTheme.colors.background
            ) {
                Column(
                    modifier = Modifier
                        .background(color = primaryColor)
                        .fillMaxSize()
                        .verticalScroll(scrollState),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Row (
                        horizontalArrangement = Arrangement.Start,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                            .padding(start = 10.dp)
                    ){
                        Image(
                            painterResource(id = R.drawable.back_icon),
                            contentDescription = "",
                            contentScale = ContentScale.FillWidth,
                            alignment = Alignment.TopEnd,
                            modifier = Modifier
                                .height(25.dp)
                                .width(25.dp)
                        )
                    }

                    Column(
                        horizontalAlignment = Alignment.Start,
                        verticalArrangement = Arrangement.Bottom,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
                    ) {
                        Text(text = "Welcome Back!",
                            color = Color.White,
                            fontFamily = abrilface,
                            fontSize = 30.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 8.dp)
                        )
                        Text(text = "Login yo your account",
                            color = Color.White,
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(bottom = 15.dp)
                        )

                        // textField username
                        var userName by remember() {
                            mutableStateOf("")
                        }

                        TextField(
                            value = userName,
                            onValueChange = {userName = it},
                            label = { Text(text = "UserName")},
                            colors = inputStyle,
                            modifier = Modifier.fillMaxWidth()
                        )

                        // textField password
                        var password by remember() {
                            mutableStateOf("")
                        }

                        TextField(
                            value = password,
                            onValueChange = {password = it},
                            label = { Text(text = "Password")},
                            colors = inputStyle,
                            modifier = Modifier.fillMaxWidth()
                        )

                        // Forgot password text button
                        Row(
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 8.dp, bottom = 8.dp)
                        ) {
                            TextButton(onClick = {}) {
                                Text(
                                    text = "Forgot Password?",
                                    color = secondaryColor
                                )
                            }
                        }

                        // continue button
                        Button(
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(secondaryColor),
                            border = BorderStroke(width = 1.dp, color = Color.White),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(50.dp)
                        ) {
                            Text(
                                text = "CONTINUE",
                                color = Color.White,
                                fontSize = 18.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }

                        // "dont have an account?" text button
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(top = 24.dp)
                        ) {
                            TextButton(onClick = {}) {
                                Text(
                                    text = "Don't have an Account?",
                                    color = secondaryColor,
                                    fontSize = 16.sp
                                )
                            }
                        }
                    }

                }
            }
        }
    }

    // TODO: FIX keyboard overlap UI 
    
//    @Preview(showBackground = true, showSystemUi = true)
//    @Composable
//    fun DefaultPreview() {
//        LearnOnboardingAppJetpackComposeTheme {
//            MainLayout(naviController = NavController(this))
//        }
//    }

    @Preview(showBackground = true, showSystemUi = true)
    @Composable
    fun LoginPreview() {
        LearnOnboardingAppJetpackComposeTheme {
            LoginLayout(naviController = NavController(this))
        }
    }
}