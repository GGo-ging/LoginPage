package com.example.loginpage

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class HomeActivity : AppCompatActivity() {

    private lateinit var iv_hm_Profile : ImageView
    private lateinit var tv_hm_UserId: TextView
    private lateinit var tv_hm_Name: TextView
    private lateinit var tv_hm_Age: TextView
    private lateinit var tv_hm_MBTI: TextView
    private lateinit var btn_hm_Exit: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val userId = intent.getStringExtra("USER_ID")

        iv_hm_Profile = findViewById(R.id.iv_hm_Profile)
        tv_hm_UserId = findViewById(R.id.tv_hm_UserId)
        tv_hm_Name = findViewById(R.id.tv_hm_Name)
        tv_hm_Age = findViewById(R.id.tv_hm_Age)
        tv_hm_MBTI = findViewById(R.id.tv_hm_MBTI)
        btn_hm_Exit = findViewById(R.id.btn_hm_Exit)

        tv_hm_UserId.text = "아이디: $userId"
        tv_hm_Name.text = "이름: 조인기"
        tv_hm_Age.text = "나이: 26"
        tv_hm_MBTI.text = "MBTI: ISTP"



        val images = listOf(
            R.drawable.im_sp1,
            R.drawable.im_sp2,
            R.drawable.im_sp3,
            R.drawable.im_sp4,
            R.drawable.im_sp5
        )

        val randomImage = images[Random.nextInt(images.size)]
        iv_hm_Profile.setImageResource(randomImage)

        btn_hm_Exit.setOnClickListener {
            val intent = Intent(this, SignInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}

