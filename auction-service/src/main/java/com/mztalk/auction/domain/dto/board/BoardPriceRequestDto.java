package com.mztalk.auction.domain.dto.board;

import com.mztalk.auction.domain.entity.Price;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardPriceRequestDto {
    private Long boardId;
    private String buyer;
    private Integer currentPrice;

    public Price toEntity() {
        return Price.builder()
                .buyer(buyer)
                .currentPrice(currentPrice)
                .build();
    }
}
