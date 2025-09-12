/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.PublicarArticulos.GestorArticulos.controller;

import com.PublicarArticulos.GestorArticulos.model.Articulos;
import com.PublicarArticulos.GestorArticulos.repository.ArticuloRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author USER
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/articulos")
public class ArticuloController {

    @Autowired
    private ArticuloRepository articuloRepository;

     // CREATE
    @PostMapping
    public ResponseEntity<Articulos> crearArticulo(@RequestBody Articulos articulo) {
        Articulos nuevo = articuloRepository.save(articulo);
        return ResponseEntity.ok(nuevo);
    }

    // READ - todos
    @GetMapping
    public ResponseEntity<List<Articulos>> obtenerArticulos() {
        List<Articulos> lista = articuloRepository.findAll();
        return ResponseEntity.ok(lista);
    }

    // READ - uno por id
    @GetMapping("/{id}")
    public ResponseEntity<Articulos> obtenerArticuloPorId(@PathVariable Integer id) {
        return articuloRepository.findById(id)
                .map(ResponseEntity::ok) // si existe lo devuelve con 200
                .orElse(ResponseEntity.notFound().build()); // si no existe, 404
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Articulos> actualizarArticulo(@PathVariable Integer id, @RequestBody Articulos articulo) {
        return articuloRepository.findById(id)
                .map(articuloExistente -> {
                    articulo.setIdArticulos(id); // mantener el mismo id
                    Articulos actualizado = articuloRepository.save(articulo);
                    return ResponseEntity.ok(actualizado); // 200 OK con el actualizado
                })
                .orElse(ResponseEntity.notFound().build()); // si no existe el id → 404
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarArticulo(@PathVariable Integer id) {
        return articuloRepository.findById(id)
                .map(articulo -> {
                    articuloRepository.deleteById(id);
                    return ResponseEntity.noContent().build(); // 204 sin contenido
                })
                .orElse(ResponseEntity.notFound().build()); // si no existe el id → 404
    }
}
