package com.allcom.persistence.crud;

import com.allcom.persistence.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UsuarioCrudRepository extends CrudRepository<Usuario, String> {}
