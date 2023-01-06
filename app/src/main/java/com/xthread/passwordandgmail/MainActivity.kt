package com.xthread.passwordandgmail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.xthread.passwordandgmail.ui.theme.PasswordAndGmailTheme


//認証の話なので、認証の状態に応じてユーザーを対応する画面にリダイレクトできるような仕組みを実装する必要があります。
//もしユーザーが認証されていなければ、サインイン画面にリダイレクトし、そうでなければ、プロファイル画面にリダイレクトします。
//ユーザーが認証されているが、電子メールを確認していない場合は、 電子メールの確認画面にリダイレクトします。
//ユーザーのリダイレクトに関連するロジックは、すべてMainActivityの中に追加されています。




class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PasswordAndGmailTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    PasswordAndGmailTheme {
        Greeting("Android")
    }
}