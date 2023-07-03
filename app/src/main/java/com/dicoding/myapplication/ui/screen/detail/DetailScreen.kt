package com.dicoding.myapplication.ui.screen.detail

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.dicoding.myapplication.R
import com.dicoding.myapplication.model.KpopData.kpop
import com.dicoding.myapplication.ui.theme.DarkBlue
import com.dicoding.myapplication.ui.theme.MyApplicationTheme

@Composable
fun DetailScreen(
    groupId: Int,
    navigateBack: () -> Unit,
) {
    val group = kpop[groupId-1]
    DetailContent(
        image = group.photo,
        name = group.name,
        description = group.description,
        extraDesc = group.extraDesc,
        onBackClick = navigateBack,
    )
}

@Composable
fun DetailContent(
    @DrawableRes image: Int,
    name: String,
    description: String,
    extraDesc: String,
    onBackClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        Column(
            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .weight(1f)
        ) {
            Box {
                Image(
                    painter = painterResource(image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = modifier
                        .height(400.dp)
                        .fillMaxWidth()
                )
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = stringResource(R.string.back),
                    modifier = Modifier
                        .padding(16.dp)
                        .clickable { onBackClick() },
                    tint = DarkBlue
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(16.dp, 8.dp, 16.dp, 15.dp)
            ) {
                Text(
                    text = name,
                    textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.h5.copy(
                        fontWeight = FontWeight.ExtraBold
                    ),
                )
                Text(
                    text = description,
                    style = MaterialTheme.typography.body1,
                    textAlign = TextAlign.Justify,
                )
            }
            Column(
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(16.dp, 0.dp, 16.dp, 8.dp)
            ) {
                Text(
                    text = extraDesc,
                    style = MaterialTheme.typography.body2,
                    textAlign = TextAlign.Justify,
                )
            }
        }
    }
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun DetailContentPreview() {
    MyApplicationTheme {
        DetailContent(
            R.drawable.ateez,
            "TXT",
            stringResource(R.string.lorem_ipsum),
            "This is extra description",
            onBackClick = {},
        )
    }
}