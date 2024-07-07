package com.sarinrath.testcode_project.ui.view

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.sarinrath.testcode_project.model.ArticleX

@Composable
fun ListComposable(articles: List<ArticleX>, selectedNews: (Int) -> Unit) {

    val state = rememberLazyListState()

    LazyColumn(Modifier.fillMaxSize(), state) {
        itemsIndexed(items = articles, itemContent = { index, dataItem ->
            Surface {
                CardViewComposable(article = dataItem,selectedNews,index)
            }
        })
    }
}
