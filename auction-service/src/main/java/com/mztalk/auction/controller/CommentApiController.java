package com.mztalk.auction.controller;

import com.mztalk.auction.domain.Result;
import com.mztalk.auction.domain.dto.comment.CommentRequestDto;
import com.mztalk.auction.domain.dto.comment.CommentResponseDto;
import com.mztalk.auction.domain.dto.comment.CommentUpdateRequestDto;
import com.mztalk.auction.service.AuctionService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/auction")
@RequiredArgsConstructor
public class CommentApiController {

    private final AuctionService auctionService;


    //댓글 작성
    @ApiOperation(value = "댓글 작성")
    @PostMapping("/comment")
    public CommentResponseDto insertComment(@RequestBody CommentRequestDto commentRequestDto) {
        return auctionService.insertComment(commentRequestDto);
    }

    //댓글 수정글
    @ApiOperation(value = "댓글 수정")
    @PatchMapping("/comment/{cId}")
    public CommentResponseDto updateComment(@PathVariable Long cId, @RequestBody CommentUpdateRequestDto commentUpdateRequestDto) {
        return auctionService.updateComment(cId, commentUpdateRequestDto);
    }

    //댓글 삭제
    @ApiOperation(value = "댓글 삭제")
    @PatchMapping("/deleteComment/{cId}")
    public int deleteComment(@PathVariable Long cId) {
        return auctionService.deleteComment(cId);
    }

    //댓글 전체 조회
    @ApiOperation(value = "댓글 전체 조회")
    @GetMapping("/comment/{bId}")
    public Result<?> selectCommentList(@PathVariable Long bId) {
        return auctionService.selectCommentList(bId);
    }

    //특정 댓글 조회
    @ApiOperation(value = "특정 댓글 조회")
    @GetMapping("selectComment/{cId}")
    public CommentResponseDto selectComment(@PathVariable Long cId) {
        return auctionService.selectComment(cId);
    }
}
