package com.example.bibliotech.data

import com.example.bibliotech.model.Prestamo

class PrestamoRepository(private val prestamoDao: PrestamoDao) {

    fun insertar(prestamo: Prestamo): Long {
        return prestamoDao.insertar(prestamo)
    }

    fun actualizarPrestamo(prestamo: Prestamo) {
        prestamoDao.actualizarPrestamo(prestamo)
    }

    fun eliminarPrestamo(prestamo: Prestamo) {
        prestamoDao.eliminarPrestamo(prestamo)
    }

    fun obtenerPrestamosActivos(): List<Prestamo> {
        return prestamoDao.obtenerPrestamosActivos()
    }

    fun obtenerPrestamos(): List<Prestamo> {
        return prestamoDao.obtenerPrestamos()
    }

    fun obtenerPrestamoPorId(id: Int): Prestamo? {
        return prestamoDao.obtenerPrestamoPorId(id)
    }
}
