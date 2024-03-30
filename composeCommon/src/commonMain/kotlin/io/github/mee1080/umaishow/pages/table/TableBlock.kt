package io.github.mee1080.umaishow.pages.table

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.scrollBy
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.PointerButton
import androidx.compose.ui.input.pointer.PointerEventType
import androidx.compose.ui.input.pointer.isPrimaryPressed
import androidx.compose.ui.input.pointer.onPointerEvent
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import io.github.mee1080.common.lib.PointerState
import io.github.mee1080.umaishow.vm.CharaList
import io.github.mee1080.umaishow.vm.RelationTableEntry
import io.github.mee1080.umaishow.vm.TableState
import io.github.mee1080.umaishow.vm.ViewModel
import kotlinx.coroutines.*
import kotlin.math.max

@Composable
fun TableBlock(state: TableState, viewModel: ViewModel) {
    LazyColumnLazyRowTable(
        state = state,
        onSortKeyChanged = {
            viewModel.sort(it)
        },
        showRelationInfo = {
            viewModel.showRelationInfo(it)
        }
    )
}

private val rowHeaderWidth = 160.dp

private val columnHeaderHeight = 160.dp

private val itemSize = 30.dp

private val rowHeaderModifier = Modifier
    .height(itemSize)
    .width(rowHeaderWidth)

private val columnHeaderModifier = Modifier
    .height(columnHeaderHeight)
    .width(itemSize)

private val itemModifier = Array(64) {
    Modifier
        .size(itemSize)
        .padding(1.dp)
        .background(Color.hsl(max(0, 27 - it) * 10f, 1f, 0.8f))
}

private val itemText = Array(64) { it.toString() }

private val totalWidth = 60.dp

private val totalModifier = Modifier
    .height(itemSize)
    .width(totalWidth)
    .padding(1.dp)
    .background(Color.hsl(0f, 1f, 0.8f))

private val infoWidth = 218.dp

private val infoPadding = 8.dp

private val infoTextModifier = Modifier
    .height(itemSize)
    .width(infoWidth - itemSize - infoPadding)
    .padding(horizontal = 4.dp, vertical = 1.dp)

private val infoButtonModifier = Modifier
    .padding(end = infoPadding)
    .size(itemSize)

@OptIn(ExperimentalComposeUiApi::class)
private fun Modifier.pointerScroll(
    scope: CoroutineScope,
    horizontalScrollState: LazyListState,
    verticalScrollState: LazyListState,
    pointerState: PointerState,
) = this.onPointerEvent(PointerEventType.Press) {
    if (it.button != PointerButton.Primary) return@onPointerEvent
    pointerState.updateAndDiff(it)
}.onPointerEvent(PointerEventType.Move) {
    if (!it.buttons.isPrimaryPressed) return@onPointerEvent
    scope.launch {
        val (dx, dy) = pointerState.updateAndDiff(it)
        verticalScrollState.scrollBy(-dy.toFloat())
        horizontalScrollState.scrollBy(-dx.toFloat())
    }
}.onPointerEvent(PointerEventType.Scroll) {
    scope.launch {
        verticalScrollState.scrollBy(it.changes[0].scrollDelta.y)
        horizontalScrollState.scrollBy(it.changes[0].scrollDelta.x)
    }
}

@Composable
private fun LazyColumnLazyRowTable(
    state: TableState,
    onSortKeyChanged: (Int) -> Unit,
    showRelationInfo: (Int) -> Unit,
) {
    val horizontalScrollState = rememberLazyListState()
    val tableHeaderModifier = Modifier.padding(end = LocalScrollbarStyle.current.thickness)
    val tableFooterModifier = Modifier.padding(
        start = rowHeaderWidth,
        end = LocalScrollbarStyle.current.thickness,
    )
    Column(Modifier.fillMaxSize()) {
        TableHeader(state, horizontalScrollState, tableHeaderModifier, onSortKeyChanged)
        TableBody(state, horizontalScrollState, Modifier.weight(1f), showRelationInfo)
        Row(tableFooterModifier) {
            HorizontalScrollbar(
                rememberScrollbarAdapter(horizontalScrollState),
                Modifier.fillMaxWidth(),
            )
        }
    }
}

@Composable
private fun TableHeader(
    state: TableState,
    horizontalScrollState: LazyListState,
    modifier: Modifier,
    onSortKeyChanged: (Int) -> Unit,
) {
    Row(modifier) {
        Box(Modifier.height(columnHeaderHeight).width(rowHeaderWidth).clickable { onSortKeyChanged(-2) }) {
            Text("列クリックでソート", Modifier.align(Alignment.CenterStart))
        }
        ProvideTextStyle(LocalTextStyle.current.copy(lineHeight = 1.em)) {
            if (state.displayChild) {
                Box(columnHeaderModifier.clickable { onSortKeyChanged(-1) }) {
                    Text(
                        text = "親相性",
                        modifier = Modifier.align(Alignment.BottomCenter),
                        textAlign = TextAlign.Center,
                    )
                }
            }
            LazyRow(
                modifier = Modifier.weight(1f),
                state = horizontalScrollState,
            ) {
                CharaList.nameList.forEachIndexed { index, name ->
                    item {
                        Box(columnHeaderModifier.clickable { onSortKeyChanged(index) }) {
                            Text(
                                text = name.replace('ー', '丨'),
                                modifier = Modifier
                                    .width(1.dp)
                                    .padding(start = 6.dp)
                                    .align(Alignment.BottomStart),
                                textAlign = TextAlign.Center,
                            )
                        }
                    }
                }
                item {
                    Box(
                        Modifier.height(columnHeaderHeight).width(totalWidth).clickable {
                            onSortKeyChanged(CharaList.charaCount)
                        }
                    ) {
                        Text(
                            text = "合計",
                            modifier = Modifier.align(Alignment.BottomCenter),
                            textAlign = TextAlign.Center,
                        )
                    }
                }
                item {
                    Box(Modifier.height(columnHeaderHeight).width(infoWidth)) {
                        Text(
                            text = "要素",
                            modifier = Modifier.align(Alignment.BottomCenter),
                            textAlign = TextAlign.Center,
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun TableBody(
    state: TableState,
    horizontalScrollState: LazyListState,
    modifier: Modifier,
    showRelationInfo: (Int) -> Unit,
) {
    Row(modifier) {
        val verticalScrollState = rememberLazyListState()
        val pointerState = remember { PointerState() }
        val scope = rememberCoroutineScope()
        LazyColumn(
            state = verticalScrollState,
            modifier = Modifier
                .weight(1f)
                .pointerScroll(scope, horizontalScrollState, verticalScrollState, pointerState)
        ) {
            state.relationTable.forEach { row ->
                item("row${row.index}") {
                    TableRow(state, row, horizontalScrollState, showRelationInfo)
                }
            }
        }
        VerticalScrollbar(
            rememberScrollbarAdapter(verticalScrollState),
            Modifier.fillMaxHeight(),
        )
    }
}

@Composable
private fun TableRow(
    state: TableState,
    row: RelationTableEntry,
    horizontalScrollState: LazyListState,
    showRelationInfo: (Int) -> Unit,
) {
    var skip by remember { mutableStateOf(true) }
    LaunchedEffect(Unit) {
        withContext(Dispatchers.Default) {
            delay(100L)
            skip = false
        }
    }
    if (skip) {
        Row {
            Text(row.name, modifier = rowHeaderModifier)
            if (state.displayChild) {
                Text(
                    text = itemText[row.parentRelation],
                    modifier = itemModifier[row.parentRelation],
                    textAlign = TextAlign.Center,
                )
            }
            return
        }
    }
    val localHorizontalScrollState = rememberLazyListState(
        horizontalScrollState.firstVisibleItemIndex,
        horizontalScrollState.firstVisibleItemScrollOffset,
    )
    LaunchedEffect(
        horizontalScrollState.firstVisibleItemIndex,
        horizontalScrollState.firstVisibleItemScrollOffset,
    ) {
        localHorizontalScrollState.scrollToItem(
            horizontalScrollState.firstVisibleItemIndex,
            horizontalScrollState.firstVisibleItemScrollOffset,
        )
    }
    Row {
        Text(row.name, modifier = rowHeaderModifier)
        if (state.displayChild) {
            Text(
                text = itemText[row.parentRelation],
                modifier = itemModifier[row.parentRelation],
                textAlign = TextAlign.Center,
            )
        }
        LazyRow(
            modifier = Modifier.weight(1f),
            state = localHorizontalScrollState,
            userScrollEnabled = false,
        ) {
            row.relationList.forEach {
                item {
                    Text(
                        text = itemText[it],
                        modifier = itemModifier[it],
                        textAlign = TextAlign.Center,
                    )
                }
            }
            item {
                Text(
                    text = row.relationTotal.toString(),
                    modifier = totalModifier,
                    textAlign = TextAlign.End,
                )
            }
            item {
                Text(
                    text = row.info,
                    modifier = infoTextModifier,
                )
                IconButton(
                    onClick = { showRelationInfo(row.index) },
                    modifier = infoButtonModifier,
                ) {
                    Icon(Icons.Outlined.Info, "その他")
                }
            }
        }
    }
}

