package com.allcom.persistence;

import com.allcom.domain.User;
import com.allcom.domain.repository.UserRepository;
import com.allcom.persistence.crud.UsuarioCrudRepository;
import com.allcom.persistence.entity.Usuario;
import com.allcom.persistence.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UsuarioRepository implements UserRepository {

    @Autowired
    private UsuarioCrudRepository usuarioCrudRepository;
    @Autowired
    private UserMapper mapper;

    @Override
    public Optional<User> getUser(String userId){
        return usuarioCrudRepository.findById(userId).map(usuario -> mapper.toUser(usuario));
    }
}
