package org.example.gradleproject.service;

import org.example.gradleproject.dto.*;
import org.example.gradleproject.entity.BaseModel;

import java.util.*;

public interface BaseService<RQ extends BaseModel, RS, ID > {
    List<RS> getAll();
    RS getElement(ID id);
}