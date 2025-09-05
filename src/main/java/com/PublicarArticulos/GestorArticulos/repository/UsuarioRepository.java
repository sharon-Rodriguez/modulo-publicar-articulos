/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.PublicarArticulos.GestorArticulos.repository;

import com.PublicarArticulos.GestorArticulos.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author USER
 */
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    
}