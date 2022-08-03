package com.muscleduck.repository;

import com.muscleduck.entity.BoardEntity;
import com.muscleduck.entity.UserEntity;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Optional;


@SpringBootTest
class BoardRepositoryTest {

    @Autowired
    private BoardRepository boardRepository;

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("게시글 생성 테스트")
    void testBoard(){

        for(int i=0;i<100; i++){


            UserEntity user = UserEntity.builder()
                    .email("test"+i+"@email.com")
                    .password("1234")
                    .nickname("홍길동" + i)
                    .build();


            BoardEntity board = BoardEntity.builder()
                    .title("제목"+i)
                    .content("내용"+i)
                    .writer(user)
                    .build();

            boardRepository.save(board);


        }

    }
   @Transactional
    @Test
    @DisplayName("보드테이블 조회 테스트")
    void testRead() {
        Optional<BoardEntity> result = boardRepository.findById(100L);

        BoardEntity board = result.get();
        System.out.println("board = " + board);
        System.out.println(board.getWriter());
    }

    @Test
    @DisplayName("목록화면에서 게시글 정보와 댓글 수 가져오기")
    void TestReadWithWriter(){

        Object result = boardRepository.getBoardWithWriter(100L);

        Object[] arrResult =(Object[]) result;

        System.out.println("arrResult = " + Arrays.toString(arrResult));
    }

    }

