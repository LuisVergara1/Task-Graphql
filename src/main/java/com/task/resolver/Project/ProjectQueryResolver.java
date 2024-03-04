package com.task.resolver.Project;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.task.models.Project;
import com.task.repository.ProjectRepository;

import graphql.kickstart.tools.GraphQLQueryResolver;

@Component
public class ProjectQueryResolver implements GraphQLQueryResolver{

    @Autowired
    private ProjectRepository projectRepository;

    public List<Project> listarProyectos() {
        return projectRepository.findAll();
    }

    @SuppressWarnings("null")
    public Project listarProyectoPorId(Long id) {
        return projectRepository.findById(id).orElseThrow(
                () -> new RuntimeException(String.format("Proyecto No Encontrado", id))
        );
    }
    
}
