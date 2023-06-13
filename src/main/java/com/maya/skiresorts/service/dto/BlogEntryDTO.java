package com.maya.skiresorts.service.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BlogEntryDTO {
    private int id;
    private String title;
    private LocalDate createDate;
    private String author;
    private String content;
}
