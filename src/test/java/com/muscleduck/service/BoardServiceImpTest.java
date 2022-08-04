package com.muscleduck.service;

import com.muscleduck.dto.BoardDTO;
import com.muscleduck.repository.BoardRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceImpTest {

    @Autowired
    private BoardService boardService;

    @Test
    @DisplayName("register() Test")
    void testRegister(){

        BoardDTO boardDTO  = BoardDTO.builder()
                .uno(1L)
                .title("register Test Title")
                .content("register Test content")
                .writerEmail("t@email.com")
                .build();

        boardService.register(boardDTO);

    }

}