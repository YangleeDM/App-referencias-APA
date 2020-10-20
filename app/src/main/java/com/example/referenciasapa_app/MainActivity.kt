package com.example.referenciasapa_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnLibro = findViewById<Button>(R.id.btnReferenciaLibro)

        btnLibro.setOnClickListener {
            val intent = Intent(this, ReferenciaLibroActivity::class.java)
            startActivity(intent)
        }

        val btnWeb = findViewById<Button>(R.id.btnReferenciaWeb)

        btnWeb.setOnClickListener {
            val intent = Intent (this, ReferenciaPaginaWebActivity::class.java)
            startActivity(intent)
        }


        val btnCapitulLibro = findViewById<Button>(R.id.btnReferenciaCapLibro)

        btnCapitulLibro.setOnClickListener {
            val intent = Intent(this, ReferenciaCapituloLibroActivity::class.java)
            startActivity(intent)
        }


    }




}
