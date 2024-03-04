package com.task.dto;

public record UserRequest(
    String id,
    String nombre,
    double precio,
    int cantidad,
    Long categoriaId

) {
    

}
