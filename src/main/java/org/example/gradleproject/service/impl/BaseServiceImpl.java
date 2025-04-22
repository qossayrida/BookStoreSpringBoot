package org.example.gradleproject.service.impl;


import org.example.gradleproject.entity.*;
import org.example.gradleproject.mapper.*;
import org.example.gradleproject.service.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public abstract class BaseServiceImpl<Request extends BaseEntity, Response, Identifier > implements BaseService<Request, Response, Identifier > {


    abstract JpaRepository<Request, Identifier> getRepository();

    abstract Converter<Request,Response> getConverter();

    @Override
    public List<Response> getAll() {
        List<Request> data =  getRepository().findAll();
        return data.stream()
                .map(getConverter()::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Response getElement(Identifier id){
        return getConverter().convertToDTO(getRepository().findById(id).get());
    }

    @Override
    public Response create(Response dto) {
        Request entity = getConverter().convertToEntity(dto);

        Request savedEntity = getRepository().save(entity);

        return getConverter().convertToDTO(savedEntity);
    }

    @Override
    public Response update(Response dto) {
        Request entity = getConverter().convertToEntity(dto);

        Request updatedEntity = getRepository().save(entity);

        return getConverter().convertToDTO(updatedEntity);
    }

}
