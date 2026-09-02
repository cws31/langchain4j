package cs.sonu.langchain4j.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatAssistant chatAssistant;

    public String chat(String msg){
        return chatAssistant.chat(msg);
    }


}
