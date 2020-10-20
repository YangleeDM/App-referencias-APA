package com.example.referenciasapa_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_referencia_libro.*

class ReferenciaLibroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_referencia_libro)
    }

    fun OnGenerarRerencia(view: View) {
        if(inputEditorial.text.toString().length== 0){
            Toast.makeText(this, "Por favor ingrese la editorial", Toast.LENGTH_LONG).show()
            return
        }

        if(inputAutores.text.toString().length == 0){
            Toast.makeText(this, "Por favor ingrese autor o autores", Toast.LENGTH_LONG).show()
            return
        }
        if(inputAnioPublicacion.text.toString().length == 0){
            Toast.makeText(this, "Por favor ingrese el año de publicación", Toast.LENGTH_LONG).show()
            return
        }
        if(inputLugarPublicacion.text.toString().length == 0){
            Toast.makeText(this, "Por favor ingrese el lugar de publicación del libro", Toast.LENGTH_LONG).show()
            return
        }

        btnCopiarReferenciaLibro.isEnabled = true

    }


    fun OnCopiarReferencia(view : View){
        Toast.makeText(this, "Funciono", Toast.LENGTH_LONG).show()
    }
}