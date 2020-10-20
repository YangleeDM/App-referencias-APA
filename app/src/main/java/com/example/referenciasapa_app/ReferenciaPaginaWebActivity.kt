package com.example.referenciasapa_app

import android.app.DatePickerDialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.CompoundButton
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_referencia_libro.*
import kotlinx.android.synthetic.main.activity_referencia_libro.inputReferenciaCreadaLibro
import kotlinx.android.synthetic.main.activity_referencia_pagina_web.*
import java.text.SimpleDateFormat
import java.util.*

class ReferenciaPaginaWebActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_referencia_pagina_web)



    }

    val validar = Operaciones()


    // Intanciación del la clase Calendar para usar el objeto myCalendar
    private val myCalendar: Calendar = Calendar.getInstance()

    private val year = myCalendar.get(Calendar.YEAR)
    private val month = myCalendar.get(Calendar.MONTH)
    private val day = myCalendar.get(Calendar.DAY_OF_MONTH)

    //Acción al generar referencia, incluye validaciones
    fun OnGenerarRerencia(view: View) {

        //Validación simple


        if (inputAutoresWeb.text.toString().length == 0) {
            mensajeLargo("Por favor ingresa autor o autores")
            return
        }

        if (inputAnioPublicacionWeb.text.toString().length == 0) {
            mensajeLargo("Por favor ingresa año de publicación")
            return
        }
        if (inputEnlaceWeb.text.toString().length == 0) {
            mensajeLargo("Por favor ingresa el año de publicación")
            return
        }
        if (inputFechaRecWeb.text.toString().length == 0) {
            mensajeLargo("Por favor ingresa el lugar de publicación")
            return
        }

        if (inputAsociacionWeb.text.toString().length == 0) {
            mensajeLargo("Por favor ingresa el título")
            return
        }

        if (inputTituloArticulo.text.toString().length == 0) {
            mensajeLargo("Por favor ingresa el título del artículo")
            return
        }


        var anioPub = inputAnioPublicacionWeb.text.toString()
        var ascWeb = inputAsociacionWeb.text.toString()
        var autWeb = inputAutoresWeb.text.toString()
        var urlWeb = inputEnlaceWeb.text.toString()
        var fechaRecuperacionWeb = inputFechaRecWeb.text.toString()
        var tituloWeb = inputTituloArticulo.text.toString()

        // End validación simple

        //Validación año
        if(validar.validateAnio(anioPub)){

        }else{
            Toast.makeText(this, "Año inválido ¿Vienes en el futuro?", Toast.LENGTH_LONG).show()
            return
        }


        //Validación URL

        if (validar.isValidURL(urlWeb)) {
            var referenciaCreada: String = crearReferenciaWeb(anioPub, ascWeb, autWeb, urlWeb, fechaRecuperacionWeb, tituloWeb)
            inputReferenciaCreadaLibro.setText(referenciaCreada)
            Toast.makeText(this, "Referencia creada", Toast.LENGTH_LONG).show()
            btnCopiarWeb.visibility = View.VISIBLE
        } else {
            mensajeLargo("El enlace introducido es inválido")
            return
        }




    }

    //Date picker
    fun onClickFechaRecuperacion(view: View){




        DatePickerDialog(this, DatePickerDialog.OnDateSetListener
        { view, selectedYear, selectedMonth, selectedDayOfMonth ->


            val selectedDate = "$selectedDayOfMonth/${selectedMonth+1}/$selectedYear"
            val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

            inputFechaRecWeb.setText(selectedDate.toString())

            mensajeCorto("Fecha seleccionada")



        }, year, month, day).show()

    }

    fun onCheckBoxClick(view: View){

        checkboxFechaRecu.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->

            if(checkboxFechaRecu.isChecked){
                val fechaActual = "$day/${month+1}/$year"
                val sdf = SimpleDateFormat("MM dd, yyyy", Locale.ENGLISH)

                inputFechaRecWeb.setText(fechaActual.toString())

                inputFechaRecWeb.isEnabled=false
                inputFechaRecWeb.setTextColor(Color.parseColor("#A4ACDC"));
            }else{
                inputFechaRecWeb.isEnabled=true
                inputFechaRecWeb.setTextColor(Color.parseColor("#708ae8"));
            }

        })


    }







    fun OnCopiarReferencia(view : View){


        var txtToCopy = inputReferenciaCreadaLibro.text.toString()

        val clipboardManager = getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("text", txtToCopy)
        clipboardManager.setPrimaryClip(clipData)


        Toast.makeText(this, "Texto copiado", Toast.LENGTH_LONG).show()
    }

    private fun crearReferenciaWeb(Anio:String, Asociacion: String, Autor: String, Url: String, FechaRecu: String, Titulo: String): String{

        var referenciaCreada = ""

        referenciaCreada += "$Autor. ($Anio). $Titulo. $FechaRecu, de $Asociacion: $Url."
        return referenciaCreada

    }

    private fun mensajeLargo(msg: String){
        Toast.makeText(this, "$msg", Toast.LENGTH_LONG).show()
    }

    private fun mensajeCorto(msg: String){
        Toast.makeText(this, "$msg", Toast.LENGTH_SHORT).show()
    }



}