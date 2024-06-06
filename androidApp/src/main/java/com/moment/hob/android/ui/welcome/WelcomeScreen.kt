package com.moment.hob.android.ui.welcome

import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.moment.hob.android.R
import com.moment.hob.android.ui.common.DarkHobButton
import com.moment.hob.android.ui.common.HobButton
import com.moment.hob.android.ui.theme.BrSonoma

@Composable
fun WelcomeScreen() {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        //BG Image

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 24.dp, horizontal = 12.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Spacer(modifier = Modifier.weight(1f))
            Text(
                modifier = Modifier.padding(bottom = 12.dp),
                text = stringResource(id = R.string.welcome_motto),
                fontFamily = BrSonoma,
                fontWeight = FontWeight.Bold,
                fontSize = 32.sp
            )

            HobButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.signin_btn)
            ) {

            }

            DarkHobButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.signup_btn)
            ) {

            }
        }
    }
}

@Composable
@Preview
fun WelcomeScreenPreview() = WelcomeScreen()