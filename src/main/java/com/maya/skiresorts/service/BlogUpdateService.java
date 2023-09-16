package com.maya.skiresorts.service;

import com.maya.skiresorts.api.BlogUpdateRequest;
import com.maya.skiresorts.dao.BlogDAO;
import com.maya.skiresorts.domain.BlogEntry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogUpdateService {
    private final BlogDAO blogDAO;

    public void updateBlogEntry(BlogUpdateRequest blogEntry){
        BlogEntry entry = toBlogEntry(blogEntry);
        blogDAO.updateBlogEntry(entry);
    }

    private BlogEntry toBlogEntry(BlogUpdateRequest blogEntry) {
        return BlogEntry.builder()
                .id(blogEntry.getId())
                .title(blogEntry.getTitle())
                .content(blogEntry.getContent())
                .imageName(blogEntry.getImageName())
                .author(blogEntry.getAuthor())
                .build();
    }
}
