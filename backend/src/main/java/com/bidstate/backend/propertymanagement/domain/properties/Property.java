package com.bidstate.backend.propertymanagement.domain.properties;

import com.bidstate.backend.propertymanagement.domain.sellers.Seller;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.bidstate.backend.shared.domain.Auditable;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "properties")
public class Property extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String title;
    private String description;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;
    private String measures;

    @Enumerated(EnumType.STRING)
    private PropertyType type;

    @Enumerated(EnumType.STRING)
    private PropertyStatus status;

    @Embedded
    private Address address;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "category_id")
    private Category category;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id")
    private Seller seller;

    public void update(
            String title,
            String description,
            BigDecimal price,
            String measures,
            PropertyType type,
            PropertyStatus status,
            Address address,
            Category category,
            Seller seller
    ) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.measures = measures;
        this.status = status;
        this.type = type;
        this.address = address;
        this.category = category;
        this.seller = seller;
    }
}
