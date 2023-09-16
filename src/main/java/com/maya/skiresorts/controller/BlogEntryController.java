package com.maya.skiresorts.controller;

import com.maya.skiresorts.api.BlogEntryReply;
import com.maya.skiresorts.api.BlogUpdateRequest;
import com.maya.skiresorts.service.BlogLookupService;
import com.maya.skiresorts.service.BlogUpdateService;
import com.maya.skiresorts.service.dto.BlogEntryDTO;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class BlogEntryController {
    private final BlogLookupService blogLookupService;
    private final BlogUpdateService blogUpdateService;

    @CrossOrigin
    @GetMapping("/blogEntries")
    public BlogEntryReply getBlogEntries(){
        return toBlogReply(blogLookupService.getBlogEntries());
    }

    @CrossOrigin
    @PatchMapping("/blogEntry")
    @ResponseBody
    public ResponseEntity<Boolean> updateBlogEntry(@Valid @RequestBody BlogUpdateRequest request){
        blogUpdateService.updateBlogEntry(request);
        return ResponseEntity.ok().body(Boolean.TRUE);
    }

    private BlogEntryReply toBlogReply(List<BlogEntryDTO> blogEntries) {
        return BlogEntryReply.builder().blogEntries(blogEntries).build();
    }
}
