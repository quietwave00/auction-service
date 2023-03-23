package com.mztalk.auction.domain.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Price {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long priceId;

    @ManyToOne
    @JoinColumn(name = "boardId", nullable=false)
    @JsonManagedReference
    private Board board;

    private String buyer;

    private Integer currentPrice;

    //편의 메소드
    public Price addBoard(Board board) {
        this.board = board;
        return this;
    }
}
