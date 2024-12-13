package com.arturlogan.ms.user.services;

import com.arturlogan.ms.user.entities.Usuario;
import com.arturlogan.ms.user.producers.UsuarioProducer;
import com.arturlogan.ms.user.repositories.UsuarioRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository  usuarioRepository;

    @Autowired
    private UsuarioProducer usuarioProducer;

    @Transactional
    public Usuario salvar(Usuario usuario){
        usuario = usuarioRepository.save(usuario);
        usuarioProducer.publishMessageEmail(usuario);

        return usuario;
    }
}

