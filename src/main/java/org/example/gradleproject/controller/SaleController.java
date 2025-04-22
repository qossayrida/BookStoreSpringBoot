package org.example.gradleproject.controller;


import io.swagger.v3.oas.annotations.Parameter;
import org.example.gradleproject.dto.BookDTO;
import org.example.gradleproject.dto.SaleDTO;
import org.example.gradleproject.service.SaleService;
import org.example.gradleproject.utilities.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;


@RestController
@RequestMapping("/api/v1/sales")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping
    public ApiResponse<List<SaleDTO>> getAllSales() {
        List<SaleDTO> sales;
        sales = saleService.getAll();
        return ApiResponse.success(sales, "Sales fetched successfully");
    }

    @GetMapping("/{id}")
    public ApiResponse<SaleDTO> getSale(@PathVariable UUID id) {
        SaleDTO saleDTO = saleService.getElement(id);
        return ApiResponse.success(saleDTO, "Book fetched successfully");
    }

    @PostMapping
    @Parameter(name = "uuid", hidden = true)
    public ApiResponse<SaleDTO> createSale(@RequestBody SaleDTO saleDTO) {
        SaleDTO createdSale = saleService.create(saleDTO);
        return ApiResponse.success(createdSale, "Sale created successfully");
    }

    @PutMapping
    public ApiResponse<SaleDTO> updateSale(@RequestBody SaleDTO saleDTO) {
        SaleDTO updatedSale = saleService.update(saleDTO);
        return ApiResponse.success(updatedSale, "Sale updated successfully");
    }
}
