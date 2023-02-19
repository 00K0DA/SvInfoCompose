package com.oukoda.svinfocompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.oukoda.svinfocompose.model.enumclass.BottomItems
import com.oukoda.svinfocompose.theme.SvInfoComposeTheme
import com.oukoda.svinfocompose.view.component.BottomBar
import com.oukoda.svinfocompose.view.page.ListPage
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
            NavHost(
                navController = navController,
                startDestination = startDestination,
            ) {
                composable(BottomItems.List.route()) {
                    ListPage()
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

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SvInfoComposeTheme {
    }
}
