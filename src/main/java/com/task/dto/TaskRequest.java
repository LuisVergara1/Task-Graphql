package com.task.dto;

public record TaskRequest(
    String titulo,
    String descripcion,
    Long usuarioId,
    Long proyectoId
) {
    
}
