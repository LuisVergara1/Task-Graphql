package com.task.Web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.task.models.Project;
import com.task.repository.ProjectRepository;


@Controller
public class ProjectController {

    @Autowired
    private ProjectRepository projectRepository;

    @QueryMapping("/graphiql")
    public String graphiql() {
        return "graphiql";
    }
    
    @QueryMapping
    public List<Project> listarProyectos()
    {
        return projectRepository.findAll();
    }

    @SuppressWarnings("null")
    @QueryMapping
    public Project listarProyectoPorId (@Argument Long id)
    {
        return projectRepository.findById(id).orElseThrow(
            ()-> new RuntimeException(String.format("Usuario No Encontrado", id))
        );
    }


    @SuppressWarnings("null")
    @MutationMapping
    public void eliminarProyecto(@Argument Long id){
        projectRepository.deleteById(id);
    }
   

}
