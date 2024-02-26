package org.example.gradleproject.dto;

import lombok.*;
import java.util.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SaleDTO {
    private Long saleID;
    private Integer quantity;
    private Date saleDate;
    private Long bookId;
}
