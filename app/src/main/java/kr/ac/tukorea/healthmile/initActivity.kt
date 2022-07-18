package kr.ac.tukorea.healthmile

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_init.*

class initActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_init)

        btnSignup.setOnClickListener {
            startActivity(Intent(this@initActivity, SignupActivity::class.java))

        }

        btnSignin.setOnClickListener {
            startActivity(Intent(this@initActivity, SigninActivity::class.java))
        }
    }
}