package cs.sonu.langchain4j.agents;

import dev.langchain4j.agentic.Agent;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;
import dev.langchain4j.service.V;

public interface CodeReviewAgens {

    @SystemMessage ("""
                 You are an expert Java code reviewer.

        Your job is to analyze Java code for:
        - correctness
        - security
        - performance
        - maintainability
        - readability

        Do not invent problems.
        Only report issues that are supported by the provided code.
            """)

    @UserMessage ("""
                     Review the following Java code:

                     {{code}}
                    """)      
    @Agent("Reviews Java code and identifies bugs, security issues, performance problems and improvements")

    String review( @V("code") String code);

}
