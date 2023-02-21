  package com.example.fotografpaylasmauygulamas.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.fotografpaylasmauygulamas.R
import com.google.firebase.auth.FirebaseAuth

import kotlinx.android.synthetic.main.activity_main.*

  class KullaniciActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        auth=FirebaseAuth.getInstance()

        val guncelKullanici=auth.currentUser
        if(guncelKullanici!=null){
            val intent=Intent(this, HaberlerActivity::class.java)
            startActivity(intent)
            finish()  // direk Haberler activity çalışır
        }


    }
    fun girisYap(view: View){
        auth.signInWithEmailAndPassword(EmailText.text.toString(),sifreText.text.toString()).addOnCompleteListener{ task ->
            if(task.isSuccessful){
                val guncelkullanici=auth.currentUser?.email.toString()
                Toast.makeText(this,"Hoşgeldin :${guncelkullanici}",Toast.LENGTH_LONG).show()
                val intent=Intent(this, HaberlerActivity::class.java)
                startActivity(intent)
                finish()
            }

        }.addOnFailureListener{exception->
            Toast.makeText(this,exception.localizedMessage,Toast.LENGTH_LONG).show() }


    }
    fun kayitOl(view: View){
        val email=EmailText.text.toString()
        val sifre=sifreText.text.toString()
        // ne kadar zaman alacağını bilemeyiz oyuzden listener kullanırız
        auth.createUserWithEmailAndPassword(email,sifre) .addOnCompleteListener{task->
            // asenkron çalışır
            if(task.isSuccessful){
                // diğer aktivite
                val intent = Intent(this, HaberlerActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.addOnFailureListener { exception ->

            Toast.makeText(applicationContext,exception.localizedMessage, Toast.LENGTH_LONG).show()

        }




    }
}