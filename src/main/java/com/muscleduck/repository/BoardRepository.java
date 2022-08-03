package com.muscleduck.repository;

import com.muscleduck.entity.BoardEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface BoardRepository extends JpaRepository<BoardEntity, Long> {

    //목록화면에서 게시글 정보와 댓글 수 가져오기
    @Query("SELECT b, w from BoardEntity b left join  b.writer w where b.bno =:bno")
    Object getBoardWithWriter(@Param("bno") Long bno);
}
