/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PublicarArticulos.GestorArticulos.controller;

import com.PublicarArticulos.GestorArticulos.model.Articulos;
import com.PublicarArticulos.GestorArticulos.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author USER
 */
@RestController
@RequestMapping("/articulos")
public class ArticuloController {

    @Autowired
    private ArticuloRepository articuloRepository;

    // CREATE
    @PostMapping
    public Articulos crearArticulo(@RequestBody Articulos articulo) {
        return articuloRepository.save(articulo);
    }

    // READ - todos
    @GetMapping
    public List<Articulos> obtenerArticulos() {
        return articuloRepository.findAll();
    }

    // READ - uno por id
    @GetMapping("/{id}")
    public Optional<Articulos> obtenerArticuloPorId(@PathVariable Integer id) {
        return articuloRepository.findById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public Articulos actualizarArticulo(@PathVariable Integer id, @RequestBody Articulos articulo) {
        articulo.setIdArticulos(id); // asegurar que actualice el correcto
        return articuloRepository.save(articulo);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void eliminarArticulo(@PathVariable Integer id) {
        articuloRepository.deleteById(id);
    }
}
