package cs.sonu.langchain4j.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cs.sonu.langchain4j.service.ChatService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/chat")
public class ChatController {

    private final ChatService chatService;

    @PostMapping
    public String doChat(@RequestBody ChatRequest chatRequest){
        return chatService.chat(chatRequest);
    }

}
