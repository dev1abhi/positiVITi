package com.example.positiviti

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.positiviti.ui.theme.ChatActivity
import com.google.firebase.auth.FirebaseAuth


class LogIn: AppCompatActivity() {
    private lateinit var edtEmail: EditText
    private lateinit var edtName: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogIn: Button
    private lateinit var btnSignUp: Button
    private lateinit var mAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?){
    super.onCreate(savedInstanceState)
        setContentView(R.layout.landingpage)

        supportActionBar?.hide()

        mAuth = FirebaseAuth.getInstance()

        edtEmail=findViewById(R.id.emailSpace)
        edtName=findViewById(R.id.nameSpace)
        edtPassword=findViewById(R.id.emailSpace)
        btnLogIn=findViewById(R.id.logIn)
        btnSignUp=findViewById(R.id.signUp)

        btnSignUp.setOnClickListener{
            val intent = Intent(this,SignUp::class.java)
            finish()
            startActivity(intent)
        }

        btnLogIn.setOnClickListener{
            val email = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            login(email,password)
        }
    }

    private fun login(email: String,password: String){
        //logic for logging in a user

        mAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    //code for logging in a user

                    val intent = Intent(this@LogIn,Useractivity::class.java)
                    startActivity(intent)
                }
                else {
                    Toast.makeText(this@LogIn,"User does not exist",Toast.LENGTH_SHORT).show()
                }
            }
    }
}