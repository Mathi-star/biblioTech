package com.example.bibliotech.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.bibliotech.model.Prestamo

@Dao
interface PrestamoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertar(prestamo: Prestamo): Long

    @Update
    fun actualizarPrestamo(prestamo: Prestamo)

    @Delete
    fun eliminarPrestamo(prestamo: Prestamo)

    @Query("SELECT * FROM Prestamos WHERE devuelto = 0")
    fun obtenerPrestamosActivos(): List<Prestamo>

    @Query("SELECT * FROM Prestamos")
    fun obtenerPrestamos(): List<Prestamo>

    @Query("SELECT * FROM Prestamos WHERE id = :id")
    fun obtenerPrestamoPorId(id: Int): Prestamo?
}
