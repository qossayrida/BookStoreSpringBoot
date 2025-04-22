package org.example.gradleproject.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleDTO {
    private UUID uuid;
    private Integer quantity;
    private LocalDate saleDate;
    private Reference book;
}
