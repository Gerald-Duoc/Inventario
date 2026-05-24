package inventario.Inventario.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import inventario.Inventario.model.Libro;

@Repository
public interface LibroRepository extends JpaRepository<Libro, Long> {
    
}
