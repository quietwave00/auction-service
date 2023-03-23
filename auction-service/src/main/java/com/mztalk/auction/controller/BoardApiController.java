package com.mztalk.auction.controller;

import com.mztalk.auction.domain.Result;
import com.mztalk.auction.domain.dto.board.BoardCloseDto;
import com.mztalk.auction.domain.dto.board.BoardDetailResponseDto;
import com.mztalk.auction.domain.dto.board.BoardEditDto;
import com.mztalk.auction.domain.dto.board.BoardRequestDto;
import com.mztalk.auction.service.AuctionService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;

@RequestMapping("/auction")
@RequiredArgsConstructor
public class BoardApiController {

    private final AuctionService auctionService;

    //게시글 작성
    @ApiOperation(value = "게시글 작성")
    @PostMapping("/board")
    public Long insertBoard(@RequestBody BoardRequestDto boardRequestDto) throws ParseException {
        return auctionService.insertBoard(boardRequestDto);
    }

    //게시글 수정
    @ApiOperation(value = "게시글 수정")
    @PatchMapping("/board/{bId}")
    public void updateBoard(@PathVariable Long bId, @RequestBody BoardEditDto boardEditDto) {
        auctionService.updateBoard(bId, boardEditDto);
    }

    //게시글 검색
    @ApiOperation(value = "게시글 검색")
    @GetMapping("/board/keyword/{keyword}/{page}")
    public Result<?> searchBoard(@PathVariable("keyword") String keyword, @PathVariable("page")int page) throws ParseException, UnsupportedEncodingException {
        return auctionService.searchBoard(keyword, page);
    }

    //전체 게시글 목록
    @ApiOperation(value = "전체 게시글 목록")
    @GetMapping("/board/page/{page}")
    public Result<?> selectBoardList(@PathVariable("page") int page) throws ParseException {
        return auctionService.selectBoardList(page);
    }

    //입찰 마감 게시물 제외
    @ApiOperation(value = "입찰 마감 게시물 제외")
    @GetMapping("/board/close/{page}")
    public Result<?> selectCloseBoardList(@PathVariable int page) throws ParseException {
        return auctionService.selectCloseBoardList(page);
    }

    //게시물 디테일
    @ApiOperation(value = "게시글 상세 보기")
    @GetMapping("/board/{bId}/{writerId}")
    public BoardDetailResponseDto selectBoard(@PathVariable Long bId, @PathVariable Long writerId) {
        auctionService.updateCount(bId, writerId); //조회수 증가
        return auctionService.selectBoard(bId);
    }

    //게시글 삭제
    @ApiOperation(value = "게시글 삭제")
    @PatchMapping("/boardDelete/{bId}/{writer}")
    public int deleteBoard(@PathVariable Long bId, @PathVariable String writer) {
        return auctionService.deleteBoard(bId, writer);
    }

    //지금 마감시키기
    @ApiOperation(value = "사용자가 게시글을 마감")
    @PatchMapping("/board/close")
    public int closeBoard(@RequestBody BoardCloseDto boardCloseDto) {
        return auctionService.closeBoard(boardCloseDto);
    }
}
