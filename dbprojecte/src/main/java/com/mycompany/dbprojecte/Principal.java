/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.dbprojecte;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jdcaparros
 */
public class Principal {

    private static final String dbURL = "jdbc:derby://localhost:1527/curso";
    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs=null;
           

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        createConnection();
        try {
            stmt = conn.createStatement();
            //System.out.println(stmt.executeUpdate("insert into personas values(1,'boncarro') "));
            //System.out.println(stmt.executeUpdate("insert into personas values(3,'boncarros') "));
            //System.out.println(stmt.executeUpdate("update personas set id=99 where id=1 "));
            //System.out.println(stmt.executeUpdate("delete from personas where id=2 "));

            rs = stmt.executeQuery("select * from personas");
            while (rs.next()) {
                System.out.println("-------------------------");
                System.out.print("id: ");
                System.out.println(rs.getInt(1));
                System.out.println("nombre: " + rs.getString(2));
                System.out.println("-------------------------");

            }
        } catch (SQLException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }

        shutdown();
    }

    private static void createConnection() {
        try {
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            //Get a connection
            conn = DriverManager.getConnection(dbURL, "app", "app");

            System.out.println("s'ha conectat");
        } catch (ClassNotFoundException | SQLException except) {
            System.out.println("No s'ha conectat");

        }
    }

    private static void shutdown() {
        try {

            if (stmt != null) {
                stmt.close();
            }
            if(rs!=null){
                rs.close();
            }
            if (conn != null) {

                conn.close();
                System.out.println("s'ha tancat");
            }
        } catch (SQLException sqlExcept) {
            System.out.println("no s'ha tancat");
        }

    }

}
