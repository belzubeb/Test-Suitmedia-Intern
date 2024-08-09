package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nameEditText: EditText = findViewById(R.id.Name)
        val palindromeEditText: EditText = findViewById(R.id.Palindrome)
        val checkButton: Button = findViewById(R.id.checkButton)
        val nextButton: Button = findViewById(R.id.nextButton)

        checkButton.setOnClickListener {
            val inputText = palindromeEditText.text.toString().replace("[^a-zA-Z0-9]".toRegex(), "").lowercase()
            if (isPalindrome(inputText)) {
                showAlertDialog("isPalindrome")
            } else {
                showAlertDialog("not palindrome")
            }
        }

        nextButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("NAME_FROM_FIRST_SCREEN", name)
            startActivity(intent)
        }
    }

    private fun isPalindrome(text: String): Boolean {
        val reversedText = text.reversed()
        return text.equals(reversedText, ignoreCase = true)
    }

    private fun showAlertDialog(message: String) {
        AlertDialog.Builder(this)
            .setMessage(message)
            .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
            .show()
    }
}