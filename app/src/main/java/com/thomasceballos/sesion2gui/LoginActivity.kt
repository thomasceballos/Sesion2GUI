package com.thomasceballos.sesion2gui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_main.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var datosRecibidos = intent.extras
        

        bt_irse.setOnClickListener{
            val intent = Intent(this, RegistroActivity::class.java)
            startActivityForResult(intent, 1234)
        }

        bt_splash2.setOnClickListener {
            val intent = Intent(this, SplashActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1234 && resultCode == Activity.RESULT_OK){
            val nombre = data?.extras?.getString("nombre")
            val cedula = data?.extras?.getLong("cedula")

            Toast.makeText(this, "nombre: $nombre, cedula: $cedula", Toast.LENGTH_SHORT).show()
        }
    }
}