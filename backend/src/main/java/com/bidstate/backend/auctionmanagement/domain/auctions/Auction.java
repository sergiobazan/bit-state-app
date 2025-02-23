package com.bidstate.backend.auctionmanagement.domain.auctions;

import com.bidstate.backend.auctionmanagement.domain.buyers.Buyer;
import com.bidstate.backend.propertymanagement.domain.properties.Property;
import com.bidstate.backend.propertymanagement.domain.sellers.Seller;
import com.bidstate.backend.shared.domain.Auditable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "auctions")
public class Auction extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(precision = 10, scale = 2)
    private BigDecimal startingPrice;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "start", column = @Column(name = "start_range")),
            @AttributeOverride(name = "end", column = @Column(name = "end_range"))
    })
    private AuctionRange rangeTime;

    @Enumerated(EnumType.STRING)
    private AuctionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "seller_id", nullable = false)
    private Seller seller;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "property_id", nullable = false)
    private Property property;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer_id")
    private Buyer buyer;

    public void close() throws Exception {
        if (this.status == AuctionStatus.CLOSED) {
            throw new Exception("Auction already closed");
        }
        if (this.status == AuctionStatus.CANCELLED) {
            throw new Exception("Auction was cancelled");
        }

        this.status = AuctionStatus.CLOSED;
    }

    public void assignWinner(Buyer winner) {
        this.buyer = winner;
    }
}
