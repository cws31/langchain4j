package cs.sonu.langchain4j.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cs.sonu.langchain4j.service.ChatAssistant;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
// import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.service.AiServices;

@Configuration
public class AiConfig {

  

    @Value("${gemini.model.name}")
    private String model;

    @Value("${gemini.api.key}")
    private String key;


   

    // @Value("${groq.base.url}")
    // private String url;

    // @Value("${groq.model.name}")
    // private String groqModel;

    // @Value("${groq.api.key}")
    // private String groqKey;



    @Bean("gemini")
    public ChatModel geminiChatModel() {

        return GoogleAiGeminiChatModel.builder()
                .modelName(model)
                .apiKey(key)
                .build();
    }


    // @Bean("groq")
    // public ChatModel groqChatModel() {

    //     return OpenAiChatModel.builder()
    //             .baseUrl(url)
    //             .temperature(0.1)
    //             .modelName(groqModel)
    //             .apiKey(groqKey)
    //             .build();
    // }

    @Bean 
    public  ChatMemoryProvider chatMemoryProvider(){
        return  memoryId -> MessageWindowChatMemory.builder()
                            .id(memoryId)
                            .maxMessages(20)
                            .build();
    }

    @Bean
    public ChatAssistant chatAssistant(
            @Qualifier("gemini") ChatModel chatModel, ChatMemoryProvider chatMemoryProviders) {

        return AiServices.builder(ChatAssistant.class)
                .chatModel(chatModel)
                .chatMemoryProvider(chatMemoryProviders)
                .build();
    }
}