package com.moment.hob.android.ui.signup

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.moment.hob.android.R
import com.moment.hob.android.ui.common.NavIndicatorBar

@Composable
fun SignUpScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        NavIndicatorBar(text = stringResource(id = R.string.nav_indicator_sign_up))
    }
}

@Composable
@Preview
fun SignUpScreenPreview() = SignUpScreen()