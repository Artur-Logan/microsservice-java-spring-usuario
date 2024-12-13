package com.arturlogan.ms.user.controllers;

import com.arturlogan.ms.user.dtos.UsuarioRecordDto;
import com.arturlogan.ms.user.entities.Usuario;
import com.arturlogan.ms.user.services.UsuarioService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;


    @PostMapping("/usuarios")
    public ResponseEntity<Usuario> salvarUsuario(@RequestBody @Valid UsuarioRecordDto recordDto){
        var usuario = new Usuario();
        BeanUtils.copyProperties(recordDto, usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuarioService.salvar(usuario));
    }
}
