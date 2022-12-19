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

        /*This intent object intents to the activity within the app*/
//        val intent = Intent(this,ReceiveMessageActivity::class.java)
//        intent.putExtra("message",messageText)

        /*What if we want to intent to the activity in another app*/
        val intent = Intent(Intent.ACTION_SEND)
        intent.setType("text/plain")
        intent.putExtra(Intent.EXTRA_TEXT,messageText)
//        startActivity(intent);

        /*chosenintent always asks user to choose an activity to send message*/
        val chooserTitle:String = "Send Message" // Chooser title
        val chosenIntent = Intent.createChooser(intent,chooserTitle)
        startActivity(chosenIntent)


    }
}