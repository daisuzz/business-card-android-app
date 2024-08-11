package com.example.businesscard

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Phone
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    BusinessCard()
                }
            }
        }
    }
}

@Composable
fun BusinessCard(modifier: Modifier = Modifier) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize().background(color = Color(0xFF7dfcc4))
    ){
        Spacer(Modifier.height(300.dp))
        NameContent(
            fullName = stringResource(R.string.name),
            title = stringResource(R.string.title),
        )
        Spacer(Modifier.height(200.dp))
        AddressContent(
            telephoneNumber = stringResource(R.string.telephone_number),
            accountName = stringResource(R.string.account_name),
            email = stringResource(R.string.email),
        )
    }
}

@Composable
fun NameContent(fullName: String, title: String, modifier:Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(R.drawable.android_logo),
            contentDescription = "android logo",
            modifier = Modifier
                .height(100.dp)
                .width(100.dp)
                .background(Color(0xFF223355)),
        )
        Text(text = fullName, fontSize = 30.sp, modifier = Modifier.padding(top = 10.dp))
        Text(text = title, fontSize = 15.sp, fontWeight = FontWeight.Bold, color = Color(0xFF137722), modifier = Modifier.padding(top = 10.dp))
    }
}

@Composable
fun AddressContent(telephoneNumber: String, accountName: String, email: String, modifier: Modifier = Modifier){
    Column(
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.Start,
    ){
        Row {
            Icon(Icons.Outlined.Phone, contentDescription = "phone", tint = Color(0xFF137722))
            Spacer(Modifier.width(15.dp))
            Text(text = telephoneNumber)
        }
        Row {
            Spacer(Modifier.height(10.dp))
        }
        Row {
            Icon(Icons.Outlined.Share, contentDescription = "share", tint = Color(0xFF137722))
            Spacer(Modifier.width(15.dp))
            Text(text = accountName)
        }
        Row {
            Spacer(Modifier.height(10.dp))
        }
        Row {
            Icon(Icons.Outlined.Email, contentDescription = "email", tint = Color(0xFF137722))
            Spacer(Modifier.width(15.dp))
            Text(text = email)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BusinessCardPreview() {
    BusinessCardTheme {
        BusinessCard()
    }
}