package com.example.bibliotech.data


// ---------------- IMPORTACIONES ----------------


import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.bibliotech.model.Estudiante
import com.example.bibliotech.model.Libro
import com.example.bibliotech.model.Prestamo
import com.example.bibliotech.model.Usuario

@Database(
    entities = [
        Libro::class,
        Estudiante::class,
        Prestamo::class,
        Usuario::class
    ],
    version = 4,
    exportSchema = false
)
abstract class BibliotecaDatabase : RoomDatabase() {

    abstract fun libroDao(): LibroDao

    abstract fun estudianteDao(): EstudianteDao

    abstract fun prestamoDao(): PrestamoDao

    abstract fun usuarioDao(): UsuarioDao
}
