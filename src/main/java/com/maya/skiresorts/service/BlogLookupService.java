package com.maya.skiresorts.service;

import com.maya.skiresorts.dao.BlogDAO;
import com.maya.skiresorts.domain.BlogEntry;
import com.maya.skiresorts.service.dto.BlogEntryDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BlogLookupService {
    private final BlogDAO blogDAO;

    public List<BlogEntryDTO> getBlogEntries(){
        return blogDAO.getBlogEntries().stream().map(this::toDTO).toList();
    }

    private BlogEntryDTO toDTO(BlogEntry resort) {
        return BlogEntryDTO.builder()
                .id(resort.getId())
                .createDate(resort.getCreateDate())
                .author(resort.getAuthor())
                .content(resort.getContent())
                .title(resort.getTitle())
                .build();
    }

}
