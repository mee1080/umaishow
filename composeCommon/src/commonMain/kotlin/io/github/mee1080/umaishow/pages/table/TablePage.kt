package io.github.mee1080.umaishow.pages.table

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.github.mee1080.umaishow.vm.TableState
import io.github.mee1080.umaishow.vm.ViewModel

@Composable
fun TablePage(state: TableState, viewModel: ViewModel) {
    Column(Modifier.fillMaxSize().background(MaterialTheme.colorScheme.background)) {
        SettingBlock(state, viewModel)
        TableBlock(state, viewModel)
    }
    RelationInfoDialog(viewModel)
}