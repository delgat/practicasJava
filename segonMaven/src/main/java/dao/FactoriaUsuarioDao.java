/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author usuario
 */
public abstract class FactoriaUsuarioDao {
    private static final UsuarioDao DAO = new BdEnMemoria();
    public static UsuarioDao get(){
        return DAO;
    }
}
