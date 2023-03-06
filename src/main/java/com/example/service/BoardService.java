package com.example.service;

import com.example.dto.BoardTO;
import com.example.repository.BoardMapperInter;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BoardService {
	private final BoardMapperInter boardMapperInter;

	public List<BoardTO> boardlist(){
		return boardMapperInter.boardlist();
	}
	public int boardpost(BoardTO to){
		return boardMapperInter.boardpost(to);
	}
	public int comment(BoardTO to){
		return boardMapperInter.comment(to);
	}
	public int editpost(BoardTO to){
		return boardMapperInter.editpost(to);
	}
	public int editcomment(BoardTO to){
		return boardMapperInter.editcomment(to);
	}


}
