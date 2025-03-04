package com.geeks.project_6

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.geeks.project_6.R.color

class login : AppCompatActivity() {
    var emailEt: EditText? = null
    var passwordEt: EditText? = null
    var loginBtn: Button? = null

    var email: String = "admin"
    var password: String = "admin"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.enableEdgeToEdge()
        setContentView(R.layout.activity_login)
        ViewCompat.setOnApplyWindowInsetsListener(
            findViewById(R.id.main)
        ) { v: View, insets: WindowInsetsCompat ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        emailEt = findViewById(R.id.email)
        passwordEt = findViewById(R.id.password)
        loginBtn = findViewById(R.id.login)

        emailEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, i: Int, i1: Int, i2: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().trim { it <= ' ' }.length > 0) {
                    loginBtn.setBackgroundTintList(
                        ContextCompat.getColorStateList(
                            this@login,
                            color.darkRed
                        )
                    )
                } else {
                    loginBtn.setBackgroundTintList(
                        ContextCompat.getColorStateList(
                            this@login,
                            color.gray
                        )
                    )
                }
            }

            override fun afterTextChanged(s: Editable) {
            }
        })

        passwordEt.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, i: Int, i1: Int, i2: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                if (s.toString().trim { it <= ' ' }.length > 0) {
                    loginBtn.setBackgroundTintList(
                        ContextCompat.getColorStateList(
                            this@login,
                            color.darkRed
                        )
                    )
                } else {
                    loginBtn.setBackgroundTintList(
                        ContextCompat.getColorStateList(
                            this@login,
                            color.gray
                        )
                    )
                }
            }

            override fun afterTextChanged(s: Editable) {
            }
        })

        loginBtn.setOnClickListener(View.OnClickListener {
            if (email == emailEt.getText().toString() && password == passwordEt.getText()
                    .toString()
            ) {
                Toast.makeText(
                    this@login,
                    "You have successfully registered",
                    Toast.LENGTH_SHORT
                ).show()
                val intent = Intent(this@login, Menu::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(
                    this@login,
                    "Incorrect login or password",
                    Toast.LENGTH_SHORT
                ).show()
            }
            emailEt.setText("")
            passwordEt.setText("")
        })
    }
}