package com.example.referenciasapa_app

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_referencia_libro.*

class ReferenciaCapituloLibroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_referencia_capitulo_libro)
    }

    fun OnCopiarReferencia(view : View){


        var txtToCopy = inputReferenciaCreadaLibro.text.toString()

        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("text", txtToCopy)
        clipboardManager.setPrimaryClip(clipData)


        Toast.makeText(this, "Texto copiado", Toast.LENGTH_LONG).show()
    }

}