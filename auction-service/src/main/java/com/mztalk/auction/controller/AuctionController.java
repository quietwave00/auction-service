package com.mztalk.auction.controller;

import com.mztalk.auction.domain.Result;
import com.mztalk.auction.domain.dto.*;
import com.mztalk.auction.domain.dto.board.*;
import com.mztalk.auction.domain.dto.comment.CommentRequestDto;
import com.mztalk.auction.domain.dto.comment.CommentResponseDto;
import com.mztalk.auction.domain.dto.comment.CommentUpdateRequestDto;
import com.mztalk.auction.service.AuctionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.util.concurrent.ConcurrentHashMap;

@Api(tags = "Auction Service")
@RequestMapping("/auction")
@RestController
@RequiredArgsConstructor
public class AuctionController {

    private final AuctionService auctionService;


    //페이징 처리
//    @ApiOperation(value = "페이징 처리")
//    @GetMapping("/board-front/{page}")
//    public Result<?> selectBoardListOfFront(@PathVariable("page") int page) throws ParseException {
//        return auctionService.selectBoardListOfFront(page);
//    }



    //상세페이지 입찰가
    @ApiOperation(value = "입찰 기능")
    @PatchMapping("/board/price")
    public BoardPriceDto updatePrice(@RequestBody BoardPriceDto boardPriceDto) {
        return auctionService.updatePrice(boardPriceDto);
    }

    //최신글 번호뽑아오기
    @GetMapping("/recent-board")
    public ConcurrentHashMap<String, String> getRecentBoardNo(){
        return auctionService.getRecentBoardNo();

    }


    //닉네임 변경 시
    @ApiOperation(value = "닉네임 변경 시 게시글에도 적용")
    @PatchMapping("/nickname")
    public void changedNickname(@RequestBody ChangedNicknameDto changedNicknameDto){
        auctionService.changedNickname(changedNicknameDto);
    }

    //입찰 현황 데이터 받아오기
    @ApiOperation(value = "입찰 현황 데이터 저장")
    @GetMapping("/currentPrice/{bId}")
    public Result<?> getCurrentPrice(@PathVariable("bId") Long bId) {
        return auctionService.getCurrentPrice(bId);
    }


}
