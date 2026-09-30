package com.example.bibliotech.model

import android.R
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey
import androidx.room.util.TableInfo

@Entity(
    tableName = "Prestamos",
    foreignKeys = [
        ForeignKey(
            entity = Libro::class,
            parentColumns =[ "id" ],
            childColumns = [ "idLibro" ],
            ),

        ForeignKey(
            entity = Libro::class,
            parentColumns =[ "id" ],
            childColumns = [ "idLibro" ],
        ),
                 ]
)
data class Prestamo(
    @PrimaryKey(autoGenerate = true)
    val id: Int =0,
    //Libro prestado
    val idLibro: Int,
    //Estudiante que lo presta
    val idEstudiante: Int,
    //Fecha en que se presta
    val fechaPrestamo: String,
    //fecha en la que se desea devolver
    val fechaDevolucion: String,
    //estado prestamo
    val devuelto: Boolean = false


)