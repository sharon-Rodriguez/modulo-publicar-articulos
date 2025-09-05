/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PublicarArticulos.GestorArticulos.controller;

import com.PublicarArticulos.GestorArticulos.model.Usuario;
import com.PublicarArticulos.GestorArticulos.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author USER
 */
@RestController
@RequestMapping("/usuarios") // todas las rutas empiezan con /usuarios
public class UsuarioController {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // Crear usuario
    @PostMapping
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    // Listar todos los usuarios
    @GetMapping
    public List<Usuario> listarUsuarios() {
        return usuarioRepository.findAll();
    }

    // Buscar usuario por id
    @GetMapping("/{id}")
    public Optional<Usuario> obtenerUsuario(@PathVariable Integer id) {
        return usuarioRepository.findById(id);
    }

    // Editar usuario
    @PutMapping("/{id}")
    public Usuario editarUsuario(@PathVariable Integer id, @RequestBody Usuario usuarioActualizado) {
        return usuarioRepository.findById(id).map(usuario -> {
            usuario.setNombre(usuarioActualizado.getNombre());
            usuario.setCorreo(usuarioActualizado.getCorreo());
            usuario.setContraseña(usuarioActualizado.getContraseña());
            usuario.setCiudad(usuarioActualizado.getCiudad());
            usuario.setReputacion(usuarioActualizado.getReputacion());
            return usuarioRepository.save(usuario);
        }).orElseThrow(() -> new RuntimeException("Usuario no encontrado"));
    }

    // Eliminar usuario
    @DeleteMapping("/{id}")
    public String eliminarUsuario(@PathVariable Integer id) {
        usuarioRepository.deleteById(id);
        return "Usuario eliminado con éxito";
    }
}
