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
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SignInActivity : AppCompatActivity() {

    private lateinit var et_sin_Id: EditText
    private lateinit var et_sin_Password: EditText
    private lateinit var btn_sin_Login: Button
    private lateinit var btn_sin_SignUp: Button

    private val signUpLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data
            if (data != null) {
                val userId = data.getStringExtra("USER_ID")
                val userPassword = data.getStringExtra("USER_PASSWORD")
                et_sin_Id.setText(userId)
                et_sin_Password.setText(userPassword)
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)


        et_sin_Id = findViewById(R.id.et_sin_Id)
        et_sin_Password = findViewById(R.id.et_sin_Password)
        btn_sin_Login = findViewById(R.id.btn_sin_Login)
        btn_sin_SignUp = findViewById(R.id.btn_sin_SignUp)

        et_sin_Id.addTextChangedListener(textWatcher)
        et_sin_Password.addTextChangedListener(textWatcher)



        btn_sin_Login.setOnClickListener {
            val id = et_sin_Id.text.toString()
            val password = et_sin_Password.text.toString()
            if (id.isNotEmpty() && password.isNotEmpty()) {
                val intent = Intent(this, HomeActivity::class.java).apply {
                    putExtra("USER_ID", id)
                }
                startActivity(intent)
                Toast.makeText(this, "로그인 성공", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "아이디/비밀번호를 확인해주세요", Toast.LENGTH_SHORT).show()
            }
        }

        btn_sin_SignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            signUpLauncher.launch(intent)
        }
    }

    private val textWatcher = object : TextWatcher {
        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            val id = et_sin_Id.text.toString().trim()
            val password = et_sin_Password.text.toString().trim()
            btn_sin_Login.isEnabled = id.isNotEmpty() && password.isNotEmpty()
        }
        override fun afterTextChanged(s: Editable?) {
            Log.e("textWatcher", "afterTextChanged")
        }
    }
}



