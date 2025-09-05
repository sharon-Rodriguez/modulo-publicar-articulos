/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.publicararticulos.gestorarticulos.repository;

import com.publicararticulos.gestorarticulos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

// Repositorio para la entidad Usuario
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    // Aquí también puedes poner métodos personalizados si lo requieres
}

