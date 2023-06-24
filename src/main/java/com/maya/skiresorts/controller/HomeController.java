package com.maya.skiresorts.controller;

import com.maya.skiresorts.api.BlogEntryReply;
import com.maya.skiresorts.api.ResortsReply;
import com.maya.skiresorts.service.BlogLookupService;
import com.maya.skiresorts.service.ResortsLookupService;
import com.maya.skiresorts.service.dto.BlogEntryDTO;
import com.maya.skiresorts.service.dto.ResortDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class HomeController {
    private final ResortsLookupService resortsLookupService;
    private final BlogLookupService blogLookupService;

    @CrossOrigin
    @GetMapping("/resorts")
    public ResortsReply getResorts(){
        return toReply(resortsLookupService.getResorts());
    }

    @CrossOrigin
    @GetMapping("/blogEntries")
    public BlogEntryReply getBlogEntries(){
        return toBlogReply(blogLookupService.getBlogEntries());
    }

    private BlogEntryReply toBlogReply(List<BlogEntryDTO> blogEntries) {
        return BlogEntryReply.builder().blogEntries(blogEntries).build();
    }

    private ResortsReply toReply(List<ResortDTO> resorts) {
        return ResortsReply.builder().resorts(resorts).build();
    }
}
