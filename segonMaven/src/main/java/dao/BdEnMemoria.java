/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import modelo.Usuario;

/**
 *
 * @author usuario
 */
class BdEnMemoria implements UsuarioDao {

    private final List<Usuario> personas;

    BdEnMemoria() {
        this.personas = new ArrayList<>();
    }

    @Override
    public Usuario nueva(Usuario p) {
        Objects.requireNonNull(p);
        assert Objects.isNull(p.getNombre());
        assert Objects.isNull(p.getPassword());
        personas.add(p);
        return p;
    }

    @Override
    public List<Usuario> todos() {
        return Collections.unmodifiableList(personas);
    }


}
