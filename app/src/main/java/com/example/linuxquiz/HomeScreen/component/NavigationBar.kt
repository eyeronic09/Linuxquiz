package com.example.linuxquiz.HomeScreen.component

import androidx.compose.animation.Crossfade
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

data class Tab(
    val title: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val route: String
)

@Composable
fun BottomNavigationBar(
    tabs: List<Tab>,
    currentRoute: String,
    onTabSelected: (String) -> Unit
) {
    NavigationBar {
        tabs.forEach { tab ->
            NavigationBarItem(
                selected = currentRoute == tab.route,
                onClick = { onTabSelected(tab.route) },
                icon = {
                    Crossfade(targetState = currentRoute == tab.route) { selected ->
                        Icon(
                            imageVector = if (selected) tab.selectedIcon else tab.unselectedIcon,
                            contentDescription = if (selected) "${tab.title}, selected" else tab.title
                        )
                    }
                },
                label = { Text(tab.title) }
            )
        }
    }
}
