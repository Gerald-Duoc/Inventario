package inventario.Inventario.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import inventario.Inventario.model.Libro;
import inventario.Inventario.repository.LibroRepository;

@Service
public class LibroService {
    
    @Autowired
    private LibroRepository repository;

    public List<Libro> listar() {
        return repository.findAll();
    }

    public Libro guardar(Libro libro) {
        return repository.save(libro);
    }

    public Optional<Libro> buscar(Long id) {
        return repository.findById(id);
    }

    public void eliminar(Long id) {
        repository.deleteById(id);
    }
    
}
