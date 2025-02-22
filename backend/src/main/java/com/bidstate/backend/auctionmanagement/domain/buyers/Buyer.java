package com.bidstate.backend.auctionmanagement.domain.buyers;

import com.bidstate.backend.shared.domain.Auditable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "buyers")
public class Buyer extends Auditable {
    @Id
    private UUID id;

    private String name;

    private String email;

    public void update(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
