package inventario.Inventario.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLibro;

    @NotBlank(message = "El titulo es obligatorio")
    @Size(max = 150,
        message = "El titulo no puede superar 150 caracteres")

    @Column(nullable = false, length = 150)
    private String titulo;

    @NotBlank(message = "El autor es obligatorio")
    @Size(max = 100,
        message = "El autor no puede superar 100 caracteres")

    @Column(nullable = false, length = 100)
    private String autor;

    @Min(value = 0,
        message = "El stock no puede ser negativo")

    @Column(nullable = false)
    private int stock;

    @Positive(message = "El precio debe ser positivo")

    @Column(nullable = false)
    private double precio;

    @Size(max = 100,
        message = "La categoria no puede superar 100 caracteres")

    @Column(length = 100)
    private String categoria;

}

