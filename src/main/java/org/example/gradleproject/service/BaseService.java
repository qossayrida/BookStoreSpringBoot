package org.example.gradleproject.service;

import org.example.gradleproject.entity.BaseEntity;

import java.util.*;

public interface BaseService<Request extends BaseEntity, Response, Identifier > {
    List<Response> getAll();
    Response getElement(Identifier uuid);

    Response create(Response dto);

    Response update(Response dto);
}