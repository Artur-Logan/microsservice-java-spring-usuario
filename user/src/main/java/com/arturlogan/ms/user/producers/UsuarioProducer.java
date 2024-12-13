package com.arturlogan.ms.user.producers;

import com.arturlogan.ms.user.dtos.EmailDto;
import com.arturlogan.ms.user.entities.Usuario;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class UsuarioProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Value(value = "${broker.queue.email.name}")
    private String routingKey;

    public void publishMessageEmail(Usuario usuario){
        var emailDto = new EmailDto();
        emailDto.setUserId(usuario.getId());
        emailDto.setEmailTo(usuario.getEmail());
        emailDto.setSubject("Cadastro realizado com sucesso!");
        emailDto.setText(usuario.getNome() + ", seja bem vindo(a)! \nAgradecemos o seu cadastro, aproveite agora todos os recursos da nossa plataforma!");

        rabbitTemplate.convertAndSend("", routingKey, emailDto);
    }
}
