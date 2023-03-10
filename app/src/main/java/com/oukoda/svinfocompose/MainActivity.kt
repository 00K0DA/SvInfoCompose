package com.oukoda.svinfocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oukoda.svinfocompose.model.enumclass.BottomItems
import com.oukoda.svinfocompose.repository.JsonRepository
import com.oukoda.svinfocompose.theme.SvInfoComposeTheme
import com.oukoda.svinfocompose.view.component.BottomBar
import com.oukoda.svinfocompose.view.page.ListPage

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SvInfoComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    MainScreen()
                }
            }
        }
    }
}

@Composable
fun MainScreen() {
    val startDestination = BottomItems.List.route()
    val navController = rememberNavController()
    val resources = LocalContext.current.resources
    var repository: JsonRepository? by remember { mutableStateOf(null) }
    LaunchedEffect(Unit) {
        repository = JsonRepository.getInstance(resources)
    }
    Box {
        Scaffold(
            scaffoldState = rememberScaffoldState(),
            bottomBar = {
                BottomBar(startDestination) {
                    navController.navigate(it.route()) {
                        launchSingleTop = true
                    }
                }
            },
        ) {
            Surface(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(it),
                color = MaterialTheme.colors.background,
            ) {
                repository?.let { jsonRepository ->
                    NavHost(
                        navController = navController,
                        startDestination = startDestination,
                    ) {
                        composable(BottomItems.List.route()) {
                            ListPage(jsonRepository)
                        }
                        composable(BottomItems.Sort.route()) {
                            Text(text = stringResource(id = BottomItems.Sort.stringId()))
                        }
                        composable(BottomItems.Quiz.route()) {
                            Text(text = stringResource(id = BottomItems.Quiz.stringId()))
                        }
                    }
                }
            }
        }
        if (repository == null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.LightGray.copy(alpha = 0.8f)),
                contentAlignment = Alignment.Center,
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    CircularProgressIndicator()
                    Text(text = "Loading", textAlign = TextAlign.Center)
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SvInfoComposeTheme {
    }
}
