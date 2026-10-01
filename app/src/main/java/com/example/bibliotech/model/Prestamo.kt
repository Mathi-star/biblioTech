package com.example.bibliotech.model

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "Prestamos",
    foreignKeys = [
        ForeignKey(
            entity = Libro::class,
            parentColumns = ["id"],
            childColumns = ["idLibro"]
        ),
        ForeignKey(
            entity = Estudiante::class,
            parentColumns = ["id"],
            childColumns = ["idEstudiante"]
        )
    ]
)
data class Prestamo(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    // Libro prestado
    val idLibro: Int,
    // Estudiante que lo presta
    val idEstudiante: Int,
    // Fecha en que se presta
    val fechaPrestamo: String,
    // Fecha en la que se desea devolver
    val fechaDevolucion: String,
    // Estado prestamo
    val devuelto: Boolean = false
)
