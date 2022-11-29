package com.gmail.amansighr884.messenger

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import com.gmail.amansighr884.messenger.R.id.message

class CreateMessageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_message)
    }

    fun onSendMessage(view: View) {
        val messageView = findViewById<EditText>(R.id.message)
        val messageText:String = messageView.text.toString()

        val intent = Intent(this,ReceiveMessageActivity::class.java)
        intent.putExtra("message",messageText)
        startActivity(intent);
    }
}