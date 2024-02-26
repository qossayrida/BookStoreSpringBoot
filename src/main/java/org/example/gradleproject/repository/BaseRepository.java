package org.example.gradleproject.repository;

import org.example.gradleproject.entity.BaseModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BaseRepository<M extends BaseModel, ID> extends JpaRepository<M , ID> {

}