package com.gmail.amansighr884.messenger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ReceiveMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_receive_message)
        val intent: Intent = getIntent()
        val messageText:String = intent.getStringExtra("message").toString()
        val messageView = findViewById<TextView>(R.id.message)
        messageView.text = messageText
    }
}