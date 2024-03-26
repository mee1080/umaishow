package io.github.mee1080.umaishow.components.pages.table

import androidx.compose.runtime.Composable
import io.github.mee1080.umaishow.vm.TableState
import io.github.mee1080.umaishow.vm.ViewModel

@Composable
fun TablePage(state: TableState, model: ViewModel) {
    FilterSetting(state, model)
    RelationTable(state, model)
}