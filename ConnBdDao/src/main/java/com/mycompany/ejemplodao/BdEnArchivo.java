/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplodao;

import com.google.gson.Gson;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author usuario
 */
class BdEnArchivo implements PersonaDao {

    private static final String dbURL = "jdbc:derby://localhost:1527/curso";
    private static Connection conn = null;
    private static PreparedStatement stmt = null;
    private static ResultSet rs = null;

    private static final String NOMBRE_ARCHIVO = "personas.json";

    public BdEnArchivo() {
        createConnection();
        f();
    }

    private void f() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            @Override
            public void run() {

                if (conn != null) {

                    try {
                        conn.close();
                    } catch (SQLException ex) {
                        Logger.getLogger(BdEnArchivo.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    System.out.println("s'ha tancat");
                }

            }

        });
    }

    @Override
    public Persona nueva(final Persona p) {
        try {

            Objects.requireNonNull(p);
            assert Objects.isNull(p.getId());
            p.setId(System.nanoTime());
            stmt = conn.prepareStatement("insert into personas values( ?, ?) ");
            stmt.setLong(1, p.getId());
            stmt.setString(2, p.getNombre());
            stmt.executeUpdate();

            return p;
        } catch (SQLException ex) {
            Logger.getLogger(BdEnArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    private static final Logger LOG = Logger.getLogger(BdEnArchivo.class.getName());

    @Override
    public List<Persona> todos() {
        try {

            stmt = conn.prepareStatement("select * from personas");
//             stmt = conn.prepareStatement("select * from personas where id=?");
//            stmt.setInt(1, 2);

            List<Persona> r = new ArrayList<>();
            rs = stmt.executeQuery();
            while (rs.next()) {
                Persona person = new Persona(rs.getString(2));
                person.setId(rs.getLong(1));
                r.add(person);
            }

            return r;
        } catch (SQLException ex) {
            Logger.getLogger(BdEnArchivo.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    private static void createConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection(dbURL, "app", "app");
            System.out.println("s'ha conectat");
        } catch (ClassNotFoundException | SQLException except) {
            System.out.println("No s'ha conectat");

        }
    }

}
