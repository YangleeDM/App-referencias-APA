package com.example.referenciasapa_app

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_referencia_libro.*
import kotlinx.android.synthetic.main.activity_referencia_libro.inputReferenciaCreadaLibro
import kotlinx.android.synthetic.main.activity_referencia_pagina_web.*

class ReferenciaPaginaWebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_referencia_pagina_web)
    }


    fun OnGenerarRerencia(view: View) {

        //Validación simple

        if(inputAnioPublicacionWeb.text.toString().length == 0){
            Toast.makeText(this, "Por favor ingresa la editorial", Toast.LENGTH_LONG).show()
            return
        }

        if(inputAsociacionWeb.text.toString().length == 0){
            Toast.makeText(this, "Por favor ingresa un título", Toast.LENGTH_LONG).show()
            return
        }

        if(inputAutoresWeb.text.toString().length == 0){
            Toast.makeText(this, "Por favor ingresa autor o autores", Toast.LENGTH_LONG).show()
            return
        }
        if(inputEnlaceWeb.text.toString().length == 0){
            Toast.makeText(this, "Por favor ingresa el año de publicación", Toast.LENGTH_LONG).show()
            return
        }
        if(inputFechaRecWeb.text.toString().length == 0){
            Toast.makeText(this, "Por favor ingresa el lugar de publicación del libro", Toast.LENGTH_LONG).show()
            return
        }
        if(inputTituloArticulo.text.toString().length == 0){
            Toast.makeText(this, "Por favor ingresa el lugar de publicación del libro", Toast.LENGTH_LONG).show()
            return
        }


        var anioPub = inputAnioPublicacionWeb.text.toString()
        var ascWeb = inputAsociacionWeb.text.toString()
        var autWeb = inputAutoresWeb.text.toString()
        var urlWeb = inputEnlaceWeb.text.toString()
        var fechaRecuperacionWeb = inputFechaRecWeb.text.toString()
        var tituloWeb = inputTituloArticulo.text.toString()

        // End validación simple
        crearReferencia()

    }

    fun OnCopiarReferencia(view : View){


        var txtToCopy = inputReferenciaCreadaLibro.text.toString()

        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("text", txtToCopy)
        clipboardManager.setPrimaryClip(clipData)


        Toast.makeText(this, "Texto copiado", Toast.LENGTH_LONG).show()
    }

    private fun crearReferencia(){

        val valdidar = Operaciones()



    }


}