package com.moment.hob.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.moment.hob.HobApi
import com.moment.hob.HobRepository

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val hobRepository = HobRepository(HobApi())
        setContent {
            HobApp(hobRepository)
        }
    }
}
