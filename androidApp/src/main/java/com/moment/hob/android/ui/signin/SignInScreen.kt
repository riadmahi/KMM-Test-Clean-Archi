package com.moment.hob.android.ui.signin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.moment.hob.android.R
import com.moment.hob.android.ui.common.HobButton
import com.moment.hob.android.ui.common.NavIndicatorBar
import com.moment.hob.android.ui.theme.BrSonoma

@Composable
fun SignInScreen(
    navigateBack: () -> Unit
) {
    var emailText by rememberSaveable { mutableStateOf("") }
    var passwordText by rememberSaveable { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        NavIndicatorBar(
            text = stringResource(id = R.string.nav_indicator_sign_in),
            onBack = { navigateBack() })
        Text(
            modifier = Modifier.padding(24.dp),
            text = "Heureux de vous revoir! \uD83D\uDC4B",
            fontFamily = BrSonoma,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
                .padding(top = 32.dp),
            verticalArrangement = Arrangement.spacedBy(24.dp)
        ) {

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = emailText,
                onValueChange = {
                    emailText = it
                },
                placeholder = {
                    Text(
                        text = "Email",
                        style = MaterialTheme.typography.bodyMedium,
                    )
                },
                textStyle = MaterialTheme.typography.bodyMedium,
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.colors(
                    focusedTrailingIconColor = MaterialTheme.colorScheme.primary,
                    focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                    cursorColor = MaterialTheme.colorScheme.primary,
                    focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer
                ),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(imeAction = ImeAction.Next),
            )

            OutlinedTextField(
                modifier = Modifier
                    .fillMaxWidth(),
                value = passwordText,
                onValueChange = {
                    passwordText = it
                },
                placeholder = {
                    Text(
                        text = "Password",
                        style = MaterialTheme.typography.bodyMedium,
                    )
                },
                textStyle = MaterialTheme.typography.bodyMedium,
                shape = RoundedCornerShape(8.dp),
                colors = TextFieldDefaults.colors(
                    focusedTrailingIconColor = MaterialTheme.colorScheme.primary,
                    focusedIndicatorColor = MaterialTheme.colorScheme.primary,
                    cursorColor = MaterialTheme.colorScheme.primary,
                    focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                    unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
                ),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                maxLines = 1,
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Password,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(onDone = {}),
                trailingIcon = {
                    val image = if (passwordVisible) painterResource(id = R.drawable.ic_eye_slash)
                    else painterResource(id = R.drawable.ic_eye)
                    val description = if (passwordVisible) "Hide password" else "Show password"

                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            modifier = Modifier.size(24.dp),
                            painter = image,
                            contentDescription = description
                        )
                    }
                }
            )

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.forgot_your_password),
                textDecoration = TextDecoration.Underline,
                style = MaterialTheme.typography.bodyMedium,
                textAlign = TextAlign.End
            )
            HobButton(
                modifier = Modifier.fillMaxWidth().padding(top = 24.dp),
                text = stringResource(id = R.string.signin_btn),
                onClick = { }
            )
        }


    }
}

@Composable
@Preview
fun SignInScreenPreview() = SignInScreen() {

}