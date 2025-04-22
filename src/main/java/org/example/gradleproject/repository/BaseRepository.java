package org.example.gradleproject.repository;

import org.example.gradleproject.entity.BaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BaseRepository<Entity extends BaseEntity, Identifier> extends JpaRepository<Entity , Identifier> {

}