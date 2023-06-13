package com.maya.skiresorts.domain;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class BlogEntry {
    private int id;
    private String title;
    private LocalDate createDate;
    private String author;
    private String content;
}
