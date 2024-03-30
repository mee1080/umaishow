package io.github.mee1080.umaishow.pages.table

import androidx.compose.foundation.VerticalScrollbar
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollbarAdapter
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import io.github.mee1080.umaishow.vm.ViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RelationInfoDialog(viewModel: ViewModel) {
    val displayInfo = viewModel.displayRelationInfo
    if (displayInfo.isNotEmpty()) {
        BasicAlertDialog(
            onDismissRequest = { viewModel.displayRelationInfo = emptyList() },
        ) {
            Row(
                modifier = Modifier
                    .clip(MaterialTheme.shapes.large)
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(16.dp)
            ) {
                ProvideTextStyle(LocalTextStyle.current.copy(color = MaterialTheme.colorScheme.onSurface)) {
                    val scrollState = rememberLazyListState()
                    LazyColumn(
                        modifier = Modifier.height(400.dp).weight(1f),
                        state = scrollState,
                    ) {
                        displayInfo.forEach {
                            item {
                                Text(it)
                            }
                        }
                    }
                    VerticalScrollbar(
                        rememberScrollbarAdapter(scrollState),
                        Modifier.height(400.dp).padding(start = 4.dp)
                    )
                }
            }
        }
    }
}