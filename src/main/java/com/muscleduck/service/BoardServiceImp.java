package com.muscleduck.service;

import com.muscleduck.dto.BoardDTO;
import com.muscleduck.entity.BoardEntity;
import com.muscleduck.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Log4j2
public class BoardServiceImp implements BoardService{

     private final BoardRepository boardRepository; //자동주입 final


    @Override
    public Long register(BoardDTO boardDTO) {

        log.info("등록호출  " + boardDTO);

        BoardEntity boardEntity = dtoToEntity(boardDTO);
        //파라미터로 받은 보드 DTO를 dtoToEntity()로 변황하여 엔티티 타입으로 저장

        boardRepository.save(boardEntity);


        return boardEntity.getBno();
    }
}
