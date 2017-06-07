/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplodao;

import java.io.IOException;
import java.io.InputStream;
import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Properties;
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
        rellenarBd();
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
            stmt = conn.prepareStatement(cargarPropiedades("insertPersona"));
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

    private String cargarPropiedades(String nombrePropiedad) {
        try {
            InputStream is = getClass()
                    .getClassLoader()
                    .getResourceAsStream(
                            "newproperties.properties");
            Properties p = new Properties();
            p.load(is);
            return p.getProperty(nombrePropiedad);
        } catch (IOException ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void rellenarBd() {
        try {
            stmt = conn.prepareStatement(cargarPropiedades("insertPersona"));
            conn.setAutoCommit(false);
            for (int i = 0; i < 50; i++) {
                stmt.setLong(1, 432 + i);
                stmt.setString(2, "XYZ");
                stmt.addBatch();
            }
            stmt.executeBatch();
            conn.commit();
            conn.setAutoCommit(true);
        } catch (BatchUpdateException esd) {
            try {
                conn.rollback();
                System.out.println("Rollback!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            } catch (SQLException ex1) {
                Logger.getLogger(BdEnArchivo.class.getName()).log(Level.SEVERE, null, ex1);
            }
        } catch (SQLException ex) {
            try {
                conn.rollback();
                System.out.println("Rollback!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            } catch (SQLException ex1) {
                Logger.getLogger(BdEnArchivo.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }
    }

}
