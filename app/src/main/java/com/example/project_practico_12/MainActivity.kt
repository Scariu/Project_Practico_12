package com.example.project_practico_12

import android.os.Bundle
import android.util.Patterns.EMAIL_ADDRESS
import androidx.appcompat.app.AppCompatActivity
import java.util.regex.Pattern


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}


fun main() {

    var nombre: String
    var apellido: String
    var edad: Int
    var correo: String
    var sistemaSalud: String

    val usuarios = mutableListOf<Usuario>()
    println("Ingrese la cantidad de usuarios: ")
    var cantidadUsuario = readLine()!!.toInt()

    for (i in 1..cantidadUsuario) {
        //NOMBRE
        println("Ingrese nombre: ")
        nombre = readln()
        while (!validarNombre(nombre)) {
            println("Nombre inválido, ingrese un nombre válido.")
            nombre = readln()
        }
        //APELLIDO
        println("Ingrese apellido: ")
        apellido = readln()
        while (!validarApellido(apellido)) {
            println("Apellido inválido, ingrese un apellido válido.")
            apellido = readln()
        }

        //EDAD
        println("Ingrese edad: ")
        edad = readln().toInt()
        while (!validarEdad(edad)) {
            println("Edad inválido, ingrese una edad válida.")
            edad = readln().toInt()
        }

        //CORREO
        println("Ingrese correo electrónico: ")
        correo = readln()
        while (validarCorreo(correo)) {
            println("Correo inválido, ingrese un correo válido.")
            apellido = readln()
        }

        //SISTEMA SALUD
        println("Seleccione su sistema de salud :")
        println("1.Fonasa")
        println("2.Isapre")
        println("3.Particular")
        sistemaSalud = readln().lowercase().uppercase()
        while (!validarSistema(sistemaSalud)) {
            println("Sistema de salud inválido, ingrese un sistema de salud válido.")
            sistemaSalud = readln()
        }


        var usuario = Usuario(nombre, apellido, edad, correo, sistemaSalud)
        usuarios.add(usuario)

        for (u in usuarios) {
            println(u)
        }
    }
}


//DataClass
    data class Usuario(
        val nombre: String,
        val apellido: String,
        val edad: Int,
        val correo: String,
        val sistemaSalud: String
    )

    fun validarSistema(sistemaSalud: String): Boolean {
        when (sistemaSalud) {
            "Fonasa".lowercase().uppercase() -> println("Seleccionó Fonasa.")
            "Isapre".lowercase().uppercase() -> println("Seleccionó Isapre.")
            "Particular".lowercase().uppercase() -> println("Seleccionó Particular.")
        }
        return sistemaSalud.equals(
            "Fonasa".lowercase().uppercase()
        ) || sistemaSalud.equals(
            "Isapre".lowercase().uppercase()
        ) || sistemaSalud.equals("Particular".lowercase().uppercase())
    }

    fun validarEdad(edad: Int): Boolean {
     return edad in 1..115
    }

    fun validarCorreo(correo: String): Boolean {
     return correo.all { it.isLetterOrDigit() } && correo.contains(Regex("^\\S+@\\S+\\.\\S+$"))
    }


    fun validarApellido(apellido: String): Boolean {
        return apellido.length in 1..20 && apellido.all { it.isLetterOrDigit() }

    }

    fun validarNombre(nombre: String): Boolean {
      return nombre.length in 1..20 && nombre.all { it.isLetterOrDigit() }

    }

