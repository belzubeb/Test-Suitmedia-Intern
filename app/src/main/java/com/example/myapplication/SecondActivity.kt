package com.example.myapplication

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    companion object {
        const val REQUEST_CODE = 100
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val buttonBack: ImageView = findViewById(R.id.buttonBack)
        val nameUserTextView: TextView = findViewById(R.id.nameUser)
        val selectedUserTextView: TextView = findViewById(R.id.selectedUserName)
        val chooseUserButton: Button = findViewById(R.id.nextSlide)

        val nameFromFirstScreen = intent.getStringExtra("NAME_FROM_FIRST_SCREEN")
        nameUserTextView.text = nameFromFirstScreen ?: "Unknown User"

        selectedUserTextView.text = "Selected User Name"

        chooseUserButton.setOnClickListener {
            val intent = Intent(this, ThirdActivity::class.java)
            startActivityForResult(intent, REQUEST_CODE)
        }

        buttonBack.setOnClickListener {
            onBackPressed()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val selectedUserName = data?.getStringExtra("SELECTED_USER_NAME")
            val selectedUserTextView: TextView = findViewById(R.id.selectedUserName)
            selectedUserTextView.text = selectedUserName ?: "Selected User Name"
        }
    }
}