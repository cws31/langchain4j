package cs.sonu.langchain4j.service;

import org.springframework.stereotype.Service;

import cs.sonu.langchain4j.controller.ChatRequest;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatAssistant chatAssistant;

    public String chat(ChatRequest chatRequest) {
        return chatAssistant.chat(chatRequest.getId(), chatRequest.getMessage());
    }

}
