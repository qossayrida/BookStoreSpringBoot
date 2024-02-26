package org.example.gradleproject.mapper;

public interface Converter<E, D> {
    D convertToDTO(E entity);
    E convertToEntity(D dto);
}