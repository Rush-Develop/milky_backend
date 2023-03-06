package com.example.controller;

import com.example.dto.BoardTO;
import com.example.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/board")
public class RestBoardController {
	@Autowired
	private BoardService boardService;

	@RequestMapping("/boardlist")
	public List<BoardTO> boardlist(){
		return boardService.boardlist();
	}

}
