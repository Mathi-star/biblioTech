package com.example.bibliotech.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.example.bibliotech.BibliotecaApplication
import com.example.bibliotech.model.Estudiante
import com.example.bibliotech.model.Libro
import com.example.bibliotech.model.Prestamo
import kotlinx.coroutines.flow.MutableStateFlow

class PrestamoViewModel(application: Application)
    : AndroidViewModel(application){

    //traemos todos los repositorios
    private val prestamoRepository = (application as BibliotecaApplication).prestamoRepository

    private val libroRepository =
        (application as BibliotecaApplication).libroRepository

    private val estudiamteRepository =
        (application as BibliotecaApplication).estudianteRepository

    //libros disponibles

    private val librosDisponibles =
        MutableStateFlow<List<Libro>>(emptyList())

    val _librosDisponibles = librosDisponibles

    // estudiantes activos
    private val _estudiantesActivos =
        MutableStateFlow<List<Estudiante>>(emptyList())

    val estudiantesActivos = _estudiantesActivos


    //prestamos activos

    private val _prestamosActivos =
        MutableStateFlow<List<Prestamo>>(emptyList())
    val prestamosActivos = _prestamosActivos

    //saber si el prestamo ya fue guardado o no
    private val _prestamoGuardado =
        MutableStateFlow<Boolean>(false)
    val prestamoGuardado = _prestamoGuardado

    //traer los datos al momento de hacer el registro del prestamo

}