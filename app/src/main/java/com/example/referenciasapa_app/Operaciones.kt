package com.example.referenciasapa_app

import android.webkit.URLUtil
import android.widget.Toast

class Operaciones {

    //TODO Validaciones de inputs de los tres Activitys y acomodación de nombre en formato APA


    fun validateAnio(Anio: String): Boolean{

        if(Anio > "2020"){
            return false
        }else{
            return true
        }

    }

    fun isValidURL(Link: String): Boolean{
        if(URLUtil.isValidUrl(Link)){
            return true
        }else{
            return false
        }
    }

    fun formatAutor(Autorname: String): String{

        //TODO
        return ""
    }

    fun campoVacio(Str: String): Boolean{

        if(Str.isEmpty() || Str.isBlank()){
            return false
        }else{
            return true
        }

    }





}