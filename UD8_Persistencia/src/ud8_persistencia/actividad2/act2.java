/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud8_persistencia.actividad2;

import java.math.BigDecimal;
import java.time.LocalDate;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import ud8_persistencia.actividad1.Artista;
import ud8_persistencia.actividad1.EventoMusical;
import ud8_persistencia.actividad1.GeneroMusical;

/**
 *
 * @author 1DAW2425-09
 */
public class act2 {
     public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("objectdb:db/eventos.odb");
        EntityManager em = emf.createEntityManager();

        EventoMusical evento = new EventoMusical(
                "RockFest 2025",
                LocalDate.of(2025, 7, 15),
                new BigDecimal("150000.50"),
                GeneroMusical.ROCK
        );

        evento.agregarArtista(new Artista("The Rolling Stones"));
        evento.agregarArtista(new Artista("Foo Fighters"));
        evento.agregarArtista(new Artista("AC/DC"));

        em.getTransaction().begin();
        em.persist(evento);
        em.getTransaction().commit();

        System.out.println("Evento guardado: " + evento);

        em.close();
        emf.close();
    }
}
