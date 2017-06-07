/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.ejemplodao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author usuario
 */
class BdEnMemoria implements PersonaDao {

    private final List<Persona> personas;

    BdEnMemoria() {
        this.personas = new ArrayList<>();
    }

    @Override
    public Persona nueva(final Persona p) {
        Objects.requireNonNull(p);
        p.setId(System.nanoTime());
        personas.add(p);
        return p;
    }

    @Override
    public List<Persona> todos() {
        return Collections.unmodifiableList(personas);
    }

    @Override
    public void rellenarBd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
