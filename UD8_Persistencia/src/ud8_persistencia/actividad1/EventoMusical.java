/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud8_persistencia.actividad1;

/**
 *
 * @author 1DAW2425-09
 */
import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class EventoMusical implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="referenciaSeq")
    @SequenceGenerator(initialValue=10, allocationSize=10, name="referenciaSeq")
    private Long id;
    //private static final ling serialVersionUID = 1L;
    private String nombre;

    private LocalDate fecha;

    private BigDecimal recaudacion;
    @Transient
    private int control;

    @Enumerated(EnumType.STRING)
    private GeneroMusical genero;

    @ElementCollection
    private List<Artista> artistasConfirmados = new ArrayList<>();

    public EventoMusical() {}

    public EventoMusical(String nombre, LocalDate fecha, BigDecimal recaudacion, GeneroMusical genero) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.recaudacion = recaudacion;
        this.genero = genero;
        this.control = 12;
    }

    public void agregarArtista(Artista artista) {
        artistasConfirmados.add(artista);
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public BigDecimal getRecaudacion() {
        return recaudacion;
    }

    public GeneroMusical getGenero() {
        return genero;
    }

    public List<Artista> getArtistasConfirmados() {
        return artistasConfirmados;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setRecaudacion(BigDecimal recaudacion) {
        this.recaudacion = recaudacion;
    }

    public void setGenero(GeneroMusical genero) {
        this.genero = genero;
    }

    public void setArtistasConfirmados(List<Artista> artistasConfirmados) {
        this.artistasConfirmados = artistasConfirmados;
    }

    @Override
    public String toString() {
        return "EventoMusical{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fecha=" + fecha +
                ", recaudacion=" + recaudacion +
                ", genero=" + genero +
                ", artistasConfirmados=" + artistasConfirmados +
                '}';
    }
}


