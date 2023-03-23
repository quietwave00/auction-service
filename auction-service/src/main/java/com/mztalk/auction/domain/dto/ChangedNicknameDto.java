package com.mztalk.auction.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ChangedNicknameDto {
    private String nickname;
    private Long userNo;
}
