package org.example.gradleproject.entity;

import jakarta.persistence.*;
import lombok.*;
import java.util.*;

@Entity
@Table(name = "sales")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "SaleID"))
public class Sale extends BaseModel{

    private Integer quantity;

    @Column(name = "Saledate")
    @Temporal(TemporalType.DATE)
    private Date saleDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BookID", nullable = false)
    private Book book;
}
