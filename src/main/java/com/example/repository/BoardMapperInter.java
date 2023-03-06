package com.example.repository;

import com.example.dto.BoardTO;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface BoardMapperInter {
	@Select("select * from board order by bid")
	List<BoardTO> boardlist();

	@Insert("insert into board(bid, id, title, content) values()")
	int boardpost(BoardTO to);

	@Insert("insert into board(bid, id, content, up_bid) values()")
	int comment(BoardTO to);

	@Update("update board set title=#{title}, content=#{content} where bid=#{bid} and id=#{id}")
	int editpost(BoardTO to);

	@Update("update board set content=#{content} where bid=#{bid} and id=#{id}")
	int editcomment(BoardTO to);

	@Delete("delete from board where bid=#{bid}")
	int deletepost(int bid);
}
