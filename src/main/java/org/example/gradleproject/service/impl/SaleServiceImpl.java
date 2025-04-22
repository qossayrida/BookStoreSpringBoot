package org.example.gradleproject.service.impl;

import org.example.gradleproject.entity.*;
import org.example.gradleproject.dto.*;
import org.example.gradleproject.mapper.Converter;
import org.example.gradleproject.mapper.EntityMapper;
import org.example.gradleproject.repository.BaseRepository;
import org.example.gradleproject.service.BookService;
import org.example.gradleproject.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SaleServiceImpl extends BaseServiceImpl<Sale,SaleDTO,UUID> implements SaleService {

    @Autowired
    BaseRepository<Sale, UUID> saleRepository;

    @Autowired
    Converter<Sale,SaleDTO> saleConverter;


    @Override
    JpaRepository<Sale, UUID> getRepository() {
        return saleRepository;
    }

    @Override
    Converter<Sale, SaleDTO> getConverter() {
        return saleConverter;
    }
}
