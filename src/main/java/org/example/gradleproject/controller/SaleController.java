package org.example.gradleproject.controller;


import org.example.gradleproject.dto.BookDTO;
import org.example.gradleproject.dto.SaleDTO;
import org.example.gradleproject.service.SaleService;
import org.example.gradleproject.utilities.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;


@RestController
@RequestMapping("/api")
public class SaleController {

    @Autowired
    private SaleService saleService;

    @GetMapping("/get-sale/all")
    public ApiResponse<List<SaleDTO>> getAllSales() {
        List<SaleDTO> sales;
        sales = saleService.getAll();
        return ApiResponse.success(sales, "Sales fetched successfully");
    }

    @GetMapping("/get-sale/{id}")
    public ApiResponse<SaleDTO> getSale(@PathVariable Long id) {
        SaleDTO saleDTO = saleService.getElement(id);
        return ApiResponse.success(saleDTO, "Book fetched successfully");
    }

    @GetMapping("/try-error-codes/{id}")
    public ApiResponse<List<String>> getAllErrors(@PathVariable Long id) {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("errorcodes", Locale.getDefault(), getClass().getClassLoader());
        ArrayList<String> errorcodes = new ArrayList<>();
        errorcodes.add("NOT_FOUND: " +resourceBundle.getString("NOT_FOUND"));
        errorcodes.add("NOT_FOUND_DETAIL: " +resourceBundle.getString("NOT_FOUND_DETAIL"));
        errorcodes.add("NOT_FOUND_DETAIL: " +resourceBundle.getString("NOT_FOUND_DETAIL").replace("{id}",String.valueOf(id)));

        return ApiResponse.success(errorcodes, "Error codes fetched successfully");
    }

}
