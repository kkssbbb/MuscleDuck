package com.muscleduck.service;

import com.muscleduck.dto.BoardDTO;
import com.muscleduck.entity.BoardEntity;
import com.muscleduck.entity.UserEntity;

public interface BoardService {

    //등록 기능
    Long register(BoardDTO boardDTO);

    //DTO ->Entity 타입변환 기능
    default BoardEntity dtoToEntity(BoardDTO boardDTO){

        UserEntity user = UserEntity.builder().uno(boardDTO.getUno()).build();

        BoardEntity boardEntity = BoardEntity.builder()
                .bno(boardDTO.getBno())
                .title(boardDTO.getTitle())
                .content(boardDTO.getContent())
                .writer(user)
                .build();

        return boardEntity;
    }
}
