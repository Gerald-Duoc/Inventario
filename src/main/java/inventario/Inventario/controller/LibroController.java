package inventario.Inventario.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import inventario.Inventario.model.Libro;
import inventario.Inventario.service.LibroService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/libros")
public class LibroController {

    @Autowired
    private LibroService service;

    @GetMapping
    public ResponseEntity<?> listar() {

        List<Libro> lista =
            service.listar();

        if(lista.isEmpty()) {

            return ResponseEntity.status(404).body("No hay libros registrados");
        }

        return ResponseEntity.ok(lista);
    }

    @PostMapping
public ResponseEntity<Libro> guardar(
        @Valid @RequestBody Libro libro) {

    return new ResponseEntity<>(service.guardar(libro),HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Libro> buscar(@PathVariable Long id) {

        return service.buscar(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
public ResponseEntity<Libro> actualizar(@PathVariable Long id,@Valid @RequestBody Libro nuevoLibro) {

    return service.buscar(id).map(libro -> {

                libro.setTitulo(nuevoLibro.getTitulo());

                libro.setAutor(nuevoLibro.getAutor());

                libro.setStock(nuevoLibro.getStock());

                libro.setPrecio(nuevoLibro.getPrecio());

                libro.setCategoria(nuevoLibro.getCategoria());

                return ResponseEntity.ok(service.guardar(libro));
            })
            .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {

        return service.buscar(id).map(libro -> {
            service.eliminar(id);
            return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
            })
            .orElse(ResponseEntity.notFound().build());
    }
}
