/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ud8_persistencia.actividad8;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.SQLException;
import java.sql.ResultSet; // para  query


/**
 *
 * @author me
 */
public class Main {
    public static void main(String[] args) {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String url = "jdbc:mariadb://localhost:3306/geslibros";
            Connection con = DriverManager.getConnection(url,"root","");
            Statement stmt = con.createStatement();
            System.out.println("Conexión Exitosa");
            
             // Execute the query
            String query = "SELECT * FROM libros";
            ResultSet rs = stmt.executeQuery(query);

            // Process the result set
            while (rs.next()) {
                // Replace with actual column names from your table
                int id = rs.getInt("id");
                String titulo = rs.getString("titulo");
                String autor = rs.getString("autor_id");
                System.out.println("ID: " + id + ", Título: " + titulo + ", Autor: " + autor);
            }
            rs.close(); //Nuevo
            stmt.close();
            con.close();
            
        } catch (ClassNotFoundException |SQLException e) {
            System.err.println("Error Conexión");
            e.printStackTrace();
        }
    }
}

/*
Para hacerl con tienda desde mariabd (Terminal)
--------------------
package org.ieslosremedios.daw1.prog.ut8.ejemplos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EjemploConexionJDBC {
    public static void main(String[] args) {
        String url = "jdbc:mariadb://localhost:3306/tienda";
        try {
            // Enlazar con el driver
            Class.forName("org.mariadb.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, "root", "root");
            Statement stm = con.createStatement();
            //TODO consultas

            stm.close();
            con.close();
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Ha fallado la conexión: " + e.getMessage());
        }
    }
}
----------------------
mariadb -u root -p < C:\Users\frang\IdeaProjects\1daw-prog-22_23-private\org\ieslosremedios\daw1\prog\\ut8\tienda_ddl.sql


https://github.com/fgomrom/1daw-prog-22_23/blob/main/org/ieslosremedios/daw1/prog/ut8/ejemplos/EjemploConexionJDBC.java

https://github.com/fgomrom/1daw-prog-22_23/blob/main/org/ieslosremedios/daw1/prog/ut8/ejemplos/tienda_ddl.sql

https://mariadb.com/downloads/connectors/connectors-data-access/java8-connector
*/