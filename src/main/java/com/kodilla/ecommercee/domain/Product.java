package com.kodilla.ecommercee.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@Entity(name = "PRODUCTS")
public class Product {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", unique = true)
    Long id;

    @NotNull
    @NonNull
    @Column(name = "NAME")
    String name;

    @NotNull
    @NonNull
    @Column(name = "DESCRIPTION")
    String description;

    @NotNull
    @NonNull
    @Column(name = "PRICE")
    BigDecimal price;

    @NonNull
    @NotNull
    @ManyToOne
    @JoinColumn(name = "GROUP_ID")
    Group group;

    @LazyCollection(LazyCollectionOption.FALSE)
    @OneToMany(cascade = CascadeType.REMOVE)
    @JoinTable(
            name = "PRODUCT_JOIN_CARTENTRIES",
            joinColumns = {@JoinColumn(name = "PRODUCT_ID", referencedColumnName = "ID")},
            inverseJoinColumns = {@JoinColumn(name = "CART_ENTRY_ID", referencedColumnName = "ID")}
    )
    List<CartEntry> cartEntriesWhichContainsThisEntry = new ArrayList<>();
}

