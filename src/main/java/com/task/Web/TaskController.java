package com.task.Web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.task.dto.TaskRequest;
import com.task.models.Project;
import com.task.models.Task;
import com.task.models.User;
import com.task.repository.ProjectRepository;
import com.task.repository.TaskRepository;
import com.task.repository.UserRepository;

@Controller
public class TaskController {
    
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProjectRepository projectRepository;

 
    @QueryMapping
    public List<Task> listarProyectos()
    {
        return taskRepository.findAll();
    }

    @SuppressWarnings("null")
    @QueryMapping
    public Task listarTaskPorId (@Argument Long id)
    {
        return taskRepository.findById(id).orElseThrow(
            ()-> new RuntimeException(String.format("Usuario No Encontrado", id))
        );
    }


    @SuppressWarnings("null")
    @MutationMapping
    public void eliminarTask(@Argument Long id){
        taskRepository.deleteById(id);
    }

    @MutationMapping
    public Task guardarTask(@Argument TaskRequest taskRequest){
        @SuppressWarnings("null")
        User user = userRepository.findById(taskRequest.usuarioId()).orElse(null);
        @SuppressWarnings("null")
        Project project = projectRepository.findById(taskRequest.proyectoId()).orElse(null);
        Task taskBD = new Task();
        taskBD.setTitulo(taskRequest.titulo());
        taskBD.setDescripcion(taskRequest.descripcion());
        taskBD.setProjects(project);
        taskBD.setAsignado(user);
        return taskRepository.save(taskBD);
    }
   
}
