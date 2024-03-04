package com.task.resolver.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Component;

import com.task.models.User;
import com.task.repository.UserRepository;

import graphql.kickstart.tools.GraphQLMutationResolver;

@Component
public class UserMutationResolver implements GraphQLMutationResolver  {

    @Autowired
    private UserRepository userRepository;
    
    @MutationMapping
    public User guardarUsuario(@Argument User usuario){
        User user = new User();
        user.setId(usuario.getId());
        user.setUsername(usuario.getUsername());
        user.setEmail(usuario.getEmail());
        user.setProyects(null);
        return userRepository.save(user);
    }
}
