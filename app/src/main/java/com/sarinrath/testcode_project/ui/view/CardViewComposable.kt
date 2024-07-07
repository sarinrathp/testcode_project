package com.sarinrath.testcode_project.ui.view

import android.content.Intent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import coil.compose.rememberAsyncImagePainter
import com.sarinrath.testcode_project.R
import com.sarinrath.testcode_project.model.ArticleX

@Composable
fun CardViewComposable(article: ArticleX, selectedNews: (Int) -> Unit, index: Int) {
    Surface(shape = RoundedCornerShape(8.dp), shadowElevation = 8.dp,) {
        Column(Modifier.clickable(onClick = { selectedNews(index) })) {
            Row(
                verticalAlignment = Alignment.Bottom
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = article.urlToImage),//painterResource(R.drawable.ic_launcher_background), //article.urlToImage
                    contentDescription = "Description",
                    contentScale = ContentScale.Fit,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(220.dp)
                        .weight(1f),
                )

                Spacer(modifier = Modifier.width(16.dp))

                Image(
                    painter = painterResource(R.drawable.right_arrow), //article.urlToImage
                    contentDescription = "Description",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable(onClick = { selectedNews(index) })
                )
            }

            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    article.title,
                    color = Color(0xFF28B2A8),
                    style = MaterialTheme.typography.titleLarge,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
                Text(
                    article.description,
                    color = Color.Black,
                    style = MaterialTheme.typography.bodyMedium,
                    maxLines = 6,
                    overflow = TextOverflow.Ellipsis,
                    textAlign = TextAlign.Center
                )
                Text(
                    article.publishedAt,
                    color = Color.LightGray,
                    style = MaterialTheme.typography.bodyMedium,
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}