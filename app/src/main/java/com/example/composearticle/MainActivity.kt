package com.example.composearticle

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.key.Key.Companion.I
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composearticle.ui.theme.ComposeArticleTheme
import kotlin.text.Typography.paragraph

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeArticleTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposeArticle(
                        stringResource(R.string.paragraph2),
                        stringResource(R.string.paragraph1),
                        stringResource(R.string.titel)
                    )
                }
            }
        }
    }
}

@Composable
fun HeaderImage (modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)

    Image(
            painter = image,
            contentDescription = null,
            contentScale = ContentScale.Inside
    )
}

@Composable
fun Titel (titel: String, modifier: Modifier = Modifier) {
    Text(
        text = titel,
        fontSize = 24.sp,
        modifier = Modifier
            .padding(16.dp)
    )
}

@Composable
fun Paragraph (paragraph: String, modifier: Modifier = Modifier) {
    Text(
        text = paragraph,
        fontSize = 14.sp,
        modifier = Modifier
            .padding(16.dp)
    )
}

@Composable
fun ComposeArticle (
    paragraph2: String,
    paragraph1: String,
    titel: String,
    modifier: Modifier = Modifier
    ) {

    Column(
        verticalArrangement = Arrangement.Top,
        modifier = modifier
    ) {
        HeaderImage()
        Titel(titel)
        Paragraph(paragraph1)
        Paragraph(paragraph2)
    }
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    ComposeArticleTheme {
        ComposeArticle(stringResource(R.string.paragraph2), stringResource(R.string.paragraph1), stringResource(R.string.titel))
    }
}