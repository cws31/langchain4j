package cs.sonu.langchain4j.service;

import org.springframework.stereotype.Service;

import cs.sonu.langchain4j.agents.CodeReviewAgens;
import cs.sonu.langchain4j.dto.CodeReviewRequest;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor 
@Service 
public class CodereviewService {

    private final CodeReviewAgens codeReviewAgens;

    public String reviewCode(CodeReviewRequest review){
        return  codeReviewAgens.review(review.getCode());
    }

}
