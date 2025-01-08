package com.dali186.Mercado.util.chat;

import org.springframework.web.bind.annotation.RequestMapping;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@RequestMapping
@NoArgsConstructor
@AllArgsConstructor
public class ChatMessageDto {
	private ChatType type;
	private Long sender;
	private String roomId;
	private String message;
	
	public void setSender(Long sender) {
		this.sender = sender;
	}
	
	public void openRoom() {
		this.type = ChatType.OPEN;
	}
	
	public void enterRoom() {
		this.type = ChatType.ENTER;
	}
	
	public void exitRoom() {
		this.type = ChatType.EXIT;
	}
	
	public void closeRoom() {
		this.type = ChatType.CLOSE;
	}
}
