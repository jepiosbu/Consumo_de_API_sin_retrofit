package com.example.consumodeapisinretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.consumodeapisinretrofit.databinding.ActivityMainBinding

//¿Qué es una API?
//Una API es el código que determina el funcionamiento de un programa informático que sirve para canalizar información de una parte de un software a otra.
//Las API permiten que una aplicación extraiga archivos o datos preexistentes dentro de un software y los use en otro programa.
//Que significa API?
//application programming interface en traduccion interfaz de programacion de aplicaciones.
//Primeramente comenzaremos adentrandonos enn que es el consumo de api...
//El consumo de api se puede definir como una interfaz que favorece la comunicación entre dos sistemas o plataformas diferentes,
//permitiendo agregar diversas funciones a sitios web y aplicaciones.
//Hay diversas maneras de consumir api en android studio como lo son con librerias externas tales como retrofit 2
//o como la que implementaremos en nuestro caso que es con volley

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setup()
    }

    open fun setup(){

        //definimos la nueva instacia del requestQueue el cual es el objeto que se encarga de gestionar por automatico el envio de peticiones
        val queue = Volley.newRequestQueue(this)
        //direccion URL de la API que vamos a consumir
        val url = "https://jsonplaceholder.typicode.com/"
        //creamos un una peticion con la clase string request para hacer la llamada
        val stringRequest = StringRequest(url, { response ->
            binding.texto.text="Response is: ${response.substring(1,900)}" // nos devuelve el resultado obtenido de la llamada
        },
        {   error ->
                 binding.texto.text=error.printStackTrace().toString() //en caso contrario nos devuelve el error generado en caso de tener mal las dependencias
        })                                                             //o los permisos de red

        //añadimos al objeto request nuestra peticion de texto  y con esto ya tendriamos la llamada
        queue.add(stringRequest)
    }
}