package org.example.gradleproject.mapper;

public interface Converter<Entity, EntityDTO> {
    EntityDTO convertToDTO(Entity entity);
    Entity convertToEntity(EntityDTO dto);
}