package cs.sonu.langchain4j.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import cs.sonu.langchain4j.agents.CodeReviewAgens;
import cs.sonu.langchain4j.service.ChatAssistant;
import dev.langchain4j.agentic.AgenticServices;
import dev.langchain4j.agentic.planner.AgenticService;
import dev.langchain4j.memory.chat.ChatMemoryProvider;
import dev.langchain4j.memory.chat.MessageWindowChatMemory;
import dev.langchain4j.model.chat.ChatModel;
import dev.langchain4j.model.googleai.GoogleAiGeminiChatModel;
import dev.langchain4j.service.AiServices;

@Configuration
public class AiConfig {

  

    @Value("${gemini.model.name}")
    private String model;

    @Value("${gemini.api.key}")
    private String key;

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

    @Bean
    public CodeReviewAgens codeReviewAgens(@Qualifier ("gemini") ChatModel chatModel, ChatMemoryProvider chatMemoryProvider){
        return AgenticServices.agentBuilder(CodeReviewAgens.class)
                             .chatModel(chatModel)
                             .chatMemoryProvider(chatMemoryProvider)
                             .outputKey("review")
                             .build();
    }
}