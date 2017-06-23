/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.curso.appEscriptori;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author jdcaparros
 */
public interface TweetRepo extends JpaRepository<Tweet, Long> {

//    List<Tweet> buscarPorIdUsuario(Long id);
    List<Tweet> findByUsuarioId(Long id);
}
