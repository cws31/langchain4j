package cs.sonu.langchain4j.service;

import dev.langchain4j.service.MemoryId;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

public interface ChatAssistant {

    @SystemMessage("""
             answer user's question
            """)
    String chat(@MemoryId int id, @UserMessage String msg);

}
