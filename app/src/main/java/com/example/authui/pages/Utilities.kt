package com.example.authui.pages

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.authui.R


@Composable
fun ScreenDetails(title: String, message: String, modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Top,
        modifier = Modifier

    ) {
        Text(
            text = "Grapzian",
            textAlign = TextAlign.End,
            fontSize = 16.sp,
            color = colorResource(R.color.secondMidTeal),
            fontWeight = FontWeight(900),
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp, end = 16.dp)
        )
        Spacer(
            modifier = Modifier
                .height(12.dp)
        )
        Text(
            text = title,
            fontSize = 64.sp,
            color = colorResource(R.color.darkTeal),
            fontWeight = FontWeight(1000),
            lineHeight = 64.sp,
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 12.dp)
        )
        Spacer(
            modifier = Modifier
                .height(12.dp)
        )
        Text(
            text = message,
            fontSize = 16.sp,
            fontWeight = FontWeight(900),
            color = colorResource(R.color.secondMidTeal),
            fontStyle = FontStyle.Italic,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp, start = 16.dp)
        )
    }
}

@Composable
fun GoogleButton() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxWidth()


    ) {
        Button(
            onClick = {
            /*TODO*/
            },
            colors = ButtonDefaults.buttonColors(colorResource(R.color.midTeal)),
            shape = RoundedCornerShape(10.dp),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 5.dp),
            modifier = Modifier
                .width(175.dp)
        ) {
            Text(
                text = "Google",
                fontWeight = FontWeight(700),
                fontStyle = FontStyle.Italic
            )
        }
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Text(
            text = "or Continue with",
            fontWeight = FontWeight(700),
            fontStyle = FontStyle.Italic,
            color = colorResource(R.color.secondMidTeal)
        )
    }
}

@Composable
fun ScreenTabs() {
    var activeTab by remember { mutableStateOf("Login") }

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 16.dp)

    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Button(
                onClick = {
                    activeTab = "Login"
                },
                colors = ButtonDefaults.buttonColors(colorResource(R.color.OffWhite)),
                modifier = Modifier
                    .weight(1f)
                    .background(color = colorResource(R.color.OffWhite))
            ) {
                Text(
                    text = "Login",
                    fontWeight = FontWeight(700),
                    fontStyle = FontStyle.Italic,
                    color = colorResource(R.color.darkTeal)
                )
            }
            Button(
                onClick = {
                    activeTab = "SignUp"
                },
                colors = ButtonDefaults.buttonColors(colorResource(R.color.darkTeal)),
                modifier = Modifier
                    .weight(1f)
                    .background(color = colorResource(R.color.darkTeal))
            ) {
                Text(
                    text = "Sign Up",
                    fontWeight = FontWeight(700),
                    fontStyle = FontStyle.Italic
                )
            }
        }

        if (activeTab == "Login") {
            LoginForm()
        } else {
            SignUpForm()
        }
    }
}

@Composable
fun CheckboxWithText () {
    var checked by remember { mutableStateOf(true) }

    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Checkbox(
            checked = checked,
            onCheckedChange = { checked = it },
            Modifier.size(32 .dp)
        )
        Text(
            "Remember me",
            color = colorResource(R.color.darkTeal),
            fontWeight = FontWeight(700),
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.End,
        )
    }
}

@Composable
fun LoginForm() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rememberMe by remember {
        mutableStateOf(false)
    }

    // Retrieve credentials if "Remember Me" was checked previously
    LaunchedEffect(Unit) {
        if (SecureStorage.hasCredentials()) {
            val (storedEmail, storedPassword) = SecureStorage.getCredentials()!!
            email = storedEmail
            password = storedPassword
            rememberMe = true
        }
    }

    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.OffWhite))

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {

            OutlinedTextField(
                value = email,
                onValueChange = { newText ->
                    email = newText
                },
                label = { Text(text = "Email") },
                placeholder = { Text(text = "Enter your e-mail") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email Icon"
                    )
                },
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { newText ->
                    password = newText.trim()
                },
                label = { Text(text = "Password") },
                placeholder = { Text(text = "Enter password") },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Password Icon"
                    )
                },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Checkbox(
                    checked = rememberMe,
                    onCheckedChange = { rememberMe = it }
                )
                Text(
                    text = "Remember me",
                    modifier = Modifier.padding(start = 8.dp)
                )

                ClickableText(
                    text = AnnotatedString("Forget Password ?"),
                    onClick = {
                        // Handle forget password click
                        // navigate to a forget password screen
                    },
                    style = LocalTextStyle.current.copy(
                        color = colorResource(R.color.darkTeal),
                        fontWeight = FontWeight(700),
                        fontStyle = FontStyle.Italic,
                        textAlign = TextAlign.End,
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                // Save credentials if Remember Me is checked
                if (rememberMe) {
                    SecureStorage.storeCredentials(email, password)
                } else {
                    SecureStorage.clearCredentials()
                }
                // TODO: Handle login functionality
            },
            colors = ButtonDefaults.buttonColors(colorResource(R.color.darkTeal)),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)

        ) {
            Text(
                text = "Log in",
                fontWeight = FontWeight(700),
                fontStyle = FontStyle.Italic
            )
        }
    }
}

@Composable
fun SignUpForm() {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var rePassword by remember { mutableStateOf("") }
    Column(
        verticalArrangement = Arrangement.SpaceEvenly,
        modifier = Modifier
            .fillMaxSize()
            .background(color = colorResource(R.color.darkTeal))

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 24.dp)
        ) {

            OutlinedTextField(
                value = email,
                onValueChange = { newText ->
                    email = newText
                },
                label = {
                    Text(
                        text = "Email",
                        color = colorResource(R.color.OffWhite),
                    ) },
                placeholder = {
                    Text(
                        text = "Enter your e-mail",
                        color = colorResource(R.color.OffWhite)
                    ) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Email,
                        contentDescription = "Email Icon",

                    )
                },

                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = password,
                onValueChange = { newText ->
                    password = newText.trim()
                },
                label = {
                    Text(
                        text = "Password",
                        color = colorResource(R.color.OffWhite)
                    ) },
                placeholder = {
                    Text(
                        text = "Enter password",
                        color = colorResource(R.color.OffWhite)
                    ) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Password Icon"
                    )
                },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(8.dp))

            OutlinedTextField(
                value = rePassword,
                onValueChange = { newText ->
                    rePassword = newText.trim()
                },
                label = {
                    Text(
                        text = "Confirm Password",
                        color = colorResource(R.color.OffWhite),
                        ) },
                placeholder = {
                    Text(
                        text = "Retype the password",
                        color = colorResource(R.color.OffWhite),
                        ) },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Lock,
                        contentDescription = "Password Icon"
                    )
                },
                singleLine = true,
                visualTransformation = PasswordVisualTransformation(),
                modifier = Modifier
                    .fillMaxWidth()
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        Button(
            onClick = {
                //ToDo: Signup Functionality
            },
            colors = ButtonDefaults.buttonColors(colorResource(R.color.OffWhite)),
            shape = RoundedCornerShape(10.dp),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)

        ) {
            Text(
                text = "Sign up",
                color = colorResource(R.color.darkTeal),
                fontWeight = FontWeight(700),
                fontStyle = FontStyle.Italic
            )
        }
    }
}
