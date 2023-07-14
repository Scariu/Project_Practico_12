package com.example.project_practico_12

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

fun main(){
    val usuarios = mutableListOf<Usuario>()
    println("Ingrese la cantidad de usuarios: ")
    val cantidadUsuario = readLine()!!.toInt()

    for(i in 1..cantidadUsuario){
        //NOMBRE
        println("Ingrese nombre: ")
        var nombre = readln()

        //APELLIDO
        println("Ingrese apellido: ")
        val apellido = readln()

        //EDAD
        println("Ingrese edad: ")
        val edad = readln().toInt()

        //CORREO
        println("Ingrese correo electrónico: ")
        val correo = readln()

        //SISTEMA SALUD
        println("Seleccione su sistema de salud (seleccione el número):")
        println("1.Fonasa")
        println("2.Isapre")
        val sistemaSalud = readln().toInt()


        //val sistemaSalud = when

        val usuario = Usuario(nombre, apellido, edad, correo, sistemaSalud)
        usuarios.add(usuario)
    }
    for (u in usuarios){
        println(u)
    }
}



//DataClass
data class Usuario(val nombre: String, val apellido: String, val edad: Int, val correo: String, val sistemaSalud: Int)
