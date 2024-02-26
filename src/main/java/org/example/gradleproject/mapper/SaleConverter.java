package org.example.gradleproject.mapper;

import org.example.gradleproject.dto.*;
import org.example.gradleproject.entity.Sale;
import org.springframework.stereotype.Component;

@Component
public class SaleConverter implements Converter<Sale, SaleDTO> {

    @Override
    public SaleDTO convertToDTO(Sale sale) {
        return EntityMapper.entityMapper.saleToSaleDTO(sale);
    }

    @Override
    public Sale convertToEntity(SaleDTO saleDTO) {
        return EntityMapper.entityMapper.saleDTOToSale(saleDTO);
    }
}
