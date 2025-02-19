package com.bidstate.backend.propertymanagement.domain.sellers;

import com.bidstate.backend.propertymanagement.domain.properties.Property;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import com.bidstate.backend.shared.domain.Auditable;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "sellers")
public class Seller extends Auditable {
    @Id
    private UUID id;

    private String name;
    private String email;
    private String phoneNumber;

    @OneToMany(mappedBy = "seller", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Property> properties = new ArrayList<>();

}
