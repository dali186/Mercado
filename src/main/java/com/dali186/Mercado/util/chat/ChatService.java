package com.dali186.Mercado.util.chat;

import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatService {

	private final SimpMessageSendingOperations simpMessageSendingOperations;
	
	@Transactional
	public void sendMessage(ChatMessageDto chat) {
		
		simpMessageSendingOperations.convertAndSend("/sub/channel" + chat.getRoomId(), chat.getMessage());
	}
}
