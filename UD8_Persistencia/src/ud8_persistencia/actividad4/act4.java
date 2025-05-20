/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud8_persistencia.actividad4;

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
public class act4 {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory("objectdb:$objectdb/db/eventos.odb");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
         EventoMusical evento3 = new EventoMusical(
                "MadCool 2025",
                LocalDate.of(2025, 7, 15),
                new BigDecimal("150000.50"),
                GeneroMusical.ROCK
        );

        evento3.agregarArtista(new Artista("Metallica"));
        evento3.agregarArtista(new Artista("Drake"));
        evento3.agregarArtista(new Artista("Calvin Harris"));
        
        em.persist(evento3);
        
        em.getTransaction().commit();
        
        em.close();
        emf.close();
    }
}
