package org.example.gradleproject.service.impl;


import org.example.gradleproject.dto.AuthorDTO;
import org.example.gradleproject.entity.*;
import org.example.gradleproject.mapper.*;
import org.example.gradleproject.service.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public abstract class BaseServiceImpl<RQ extends BaseModel , RS, ID > implements BaseService<RQ, RS, ID > {


    abstract JpaRepository<RQ, ID> getRepository();

    abstract Converter<RQ,RS> getConverter();

    @Override
    public List<RS> getAll() {
        List<RQ> data =  getRepository().findAll();
        return data.stream()
                .map(getConverter()::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RS getElement(ID id){
        return getConverter().convertToDTO(getRepository().findById(id).get());
    }

}
