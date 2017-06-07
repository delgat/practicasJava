/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicio;

import modelo.Usuario;

/**
 *
 * @author jdcaparros
 */
public abstract interface AuthServicio {
    Boolean existe(Usuario u);
}
