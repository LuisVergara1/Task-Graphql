package com.task.Web;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.task.models.User;
import com.task.repository.UserRepository;


@Controller
public class UserController  {

    @Autowired
    private UserRepository userRepository;


    @QueryMapping
    public List<User> listarUsuario ()
    {
        return userRepository.findAll();
    }

    @SuppressWarnings("null")
    @QueryMapping
    public User listarUsuarioPorId (@Argument Long id)
    {
        return userRepository.findById(id).orElseThrow(
            ()-> new RuntimeException(String.format("Usuario No Encontrado", id))
        );
    }


    @SuppressWarnings("null")
    @MutationMapping
    public void eliminarUsuario(@Argument Long id){
        userRepository.deleteById(id);
    }


    
   
}
