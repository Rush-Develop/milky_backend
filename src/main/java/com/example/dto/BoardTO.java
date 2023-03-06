package com.example.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BoardTO {
	private int bid;
	private String id;
	private String title;
	private String content;
	private Date wdate;
	private int up_bid;

}
