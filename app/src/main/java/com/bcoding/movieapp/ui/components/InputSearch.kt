package com.bcoding.movieapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.bcoding.movieapp.R
import com.bcoding.movieapp.ui.theme.caption
import com.bcoding.movieapp.ui.theme.searchColor

@Composable
fun InputSearch() {
    var inputText by remember {
        mutableStateOf("")
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        TextField(
            value = inputText,
            onValueChange = {
                inputText = it
            },
            leadingIcon = {
                Icon(
                    painter = painterResource(id = R.drawable.ic_search),
                    contentDescription = "search",
                    tint = Color.White,
                    modifier = Modifier.size(18.dp)
                )
            },
            modifier = Modifier
                .fillMaxWidth()
                .background(searchColor)
                .border(
                    width = 1.dp,
                    Color(0xFF78909C),
                    shape = RoundedCornerShape(8.dp)
                ),
            shape = RoundedCornerShape(8.dp),
            placeholder = {
                Text(
                    text = "Search Movie",
                    style = MaterialTheme.typography.body1.copy(color = caption)
                )
            },
            textStyle = TextStyle(color = Color.White, fontSize = 16.sp),
            keyboardOptions = KeyboardOptions(imeAction = ImeAction.Search)
        )
    }
}

@Preview
@Composable
fun InputSearchPreview() {
    InputSearch()
}