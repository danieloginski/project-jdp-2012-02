package com.kodilla.ecommercee.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "PRODUCTS")
public class Product {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "PRODUCT_ID", unique = true)
    Long id;

    @NotNull
    @Column(name = "NAME")
    String name;

    @NotNull
    @Column(name = "DESCRIPTION")
    String description;

    @NotNull
    @Column(name = "PRICE")
    BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    Group group;

    @ManyToMany(cascade = CascadeType.MERGE, mappedBy = "productList")
    List<Cart> cartsWhichContainsThisProduct = new ArrayList<>();
}
