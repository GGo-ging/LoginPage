package com.example.loginpage

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignUpActivity : AppCompatActivity() {

    private lateinit var et_sup_Name: EditText
    private lateinit var et_sup_Id: EditText
    private lateinit var et_sup_Password: EditText
    private lateinit var btn_sup_SignUp: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        et_sup_Name = findViewById(R.id.et_sup_Name)
        et_sup_Id = findViewById(R.id.et_sup_Id)
        et_sup_Password = findViewById(R.id.et_sup_Password)
        btn_sup_SignUp = findViewById(R.id.btn_sup_SignUp)

        et_sup_Name.addTextChangedListener(textWatcher)
        et_sup_Id.addTextChangedListener(textWatcher)
        et_sup_Password.addTextChangedListener(textWatcher)


        btn_sup_SignUp.setOnClickListener {

            val name = et_sup_Name.text.toString()
            val id = et_sup_Id.text.toString()
            val password = et_sup_Password.text.toString()

            if (name.isNotEmpty() && id.isNotEmpty() && password.isNotEmpty()) {
                val singInIntent = Intent().apply {
                    putExtra("USER_ID", id)
                    putExtra("USER_PASSWORD", password)
                }
                setResult(Activity.RESULT_OK, singInIntent)
                finish()
            } else {
                Toast.makeText(this, "입력되지 않은 정보가 있습니다", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private val textWatcher = object : TextWatcher {

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            Log.e("textWathcer", "beforeTextChanged")
        }
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val name = et_sup_Name.text.toString().trim()
            val id = et_sup_Id.text.toString().trim()
            val password = et_sup_Password.text.toString().trim()
            btn_sup_SignUp.isEnabled = name.isNotEmpty() && id.isNotEmpty() && password.isNotEmpty()
        }
        override fun afterTextChanged(s: Editable?) {}
    }
}

