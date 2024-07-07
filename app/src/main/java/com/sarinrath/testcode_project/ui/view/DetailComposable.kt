package com.sarinrath.testcode_project.ui.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.sarinrath.testcode_project.model.ArticleX
import com.sarinrath.testcode_project.viewmodel.MainViewModel

@Composable
fun DetailComposable(
    viewModel: MainViewModel,
    newsId: Int,
    navigateUp: () -> Unit
) {

    val news = viewModel.news.observeAsState()
    val article: ArticleX = news.value?.articles?.get(newsId)!!

    Surface(
        shape = RoundedCornerShape(8.dp),
        shadowElevation = 8.dp,
    ) {
        Column {
            ToolbarnavigationIconComposable(title = "Detail",navigateUp)
            Row(
                verticalAlignment = Alignment.Top
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = article.urlToImage),//painterResource(R.drawable.ic_launcher_background), //article.urlToImage
                    contentDescription = "Description",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .weight(1f),
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
            ) {
                Text(
                    article.title,
                    color = Color(0xFF28B2A8),
                    style = MaterialTheme.typography.titleLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    article.description,
                    color = Color.Black,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 6,
                    overflow = TextOverflow.Ellipsis,
                )
                Text(
                    article.publishedAt,
                    color = Color.LightGray,
                    style = MaterialTheme.typography.bodyMedium,
                )
            }
        }
    }
}