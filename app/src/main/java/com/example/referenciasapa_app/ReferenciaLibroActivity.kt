package com.example.referenciasapa_app

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_referencia_libro.*

class ReferenciaLibroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_referencia_libro)
    }

    fun OnGenerarRerencia(view: View) {

        //Validación simple

        if(inputEditorial.text.toString().length == 0){
            Toast.makeText(this, "Por favor ingresa la editorial", Toast.LENGTH_LONG).show()
            return
        }

        if(inputTitulo.text.toString().length == 0){
            Toast.makeText(this, "Por favor ingresa un título", Toast.LENGTH_LONG).show()
            return
        }

        if(inputAutores.text.toString().length == 0){
            Toast.makeText(this, "Por favor ingresa autor o autores", Toast.LENGTH_LONG).show()
            return
        }
        if(inputAnioPublicacion.text.toString().length == 0){
            Toast.makeText(this, "Por favor ingresa el año de publicación", Toast.LENGTH_LONG).show()
            return
        }
        if(inputLugarPublicacion.text.toString().length == 0){
            Toast.makeText(this, "Por favor ingresa el lugar de publicación del libro", Toast.LENGTH_LONG).show()
            return
        }


        // End validación, si validación correcta, se genera la referencia


        crearReferencia()

    }

    private fun crearReferencia(){

        val validar = Operaciones()

        if(validar.validateAnio(inputAnioPublicacion.text.toString())){

        }else{
            Toast.makeText(this, "Año inválido ¿Vienes en el futuro?", Toast.LENGTH_LONG).show()
            return
        }

        var referenciaCreada : String = ""

        try {

            referenciaCreada += "${inputAutores.text.toString()}. (${inputAnioPublicacion.text.toString()}). ${inputTitulo.text.toString()}. ${inputLugarPublicacion.text.toString()}. ${inputEditorial.text.toString()}"
            inputReferenciaCreadaLibro.setText(referenciaCreada)

            Toast.makeText(this, "Referencia creada", Toast.LENGTH_LONG).show()
            btnCopiarReferenciaLibro.visibility = View.VISIBLE

        }catch (e: Exception){
            e.printStackTrace()
            Toast.makeText(this, "Ocurrió un error al crear la referencia", Toast.LENGTH_LONG).show()
            return
        }

    }

    fun OnCopiarReferencia(view : View){


        var txtToCopy = inputReferenciaCreadaLibro.text.toString()

        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("text", txtToCopy)
        clipboardManager.setPrimaryClip(clipData)


        Toast.makeText(this, "Texto copiado", Toast.LENGTH_LONG).show()
    }
}