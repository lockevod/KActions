package com.enderthor.kNotify.screens


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
fun TabLayout() {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf("Conf.", "Mess.", "Phones")

    Column(modifier = Modifier.fillMaxSize()) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            modifier = Modifier.fillMaxWidth(),
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index },
                    text = { Text(text = title, fontSize = 14.sp) },
                )
            }
        }

        when (selectedTabIndex) {
            0 -> ConfigScreen()
            1 -> MessagesScreen()
            2 -> PhonesScreen()
        }
    }
}

@Preview(name = "karoo", device = "spec:width=480px,height=800px,dpi=300")
@Composable
private fun PreviewTabLayout() {
    TabLayout()
}