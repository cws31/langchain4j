package cs.sonu.langchain4j.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cs.sonu.langchain4j.dto.CodeReviewRequest;
import cs.sonu.langchain4j.service.CodereviewService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/review")
public class CodeReviewController {

    private final CodereviewService codereviewService;

    @PostMapping("/code")
    public String reviewCode(@RequestBody  CodeReviewRequest codeReviewRequest) {
        return codereviewService.reviewCode(codeReviewRequest);
    }

}
