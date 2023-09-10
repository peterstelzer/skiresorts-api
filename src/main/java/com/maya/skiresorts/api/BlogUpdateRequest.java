package com.maya.skiresorts.api;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogUpdateRequest {
    @NonNull
    private Integer id;
    private String title;
    private String author;
    private String content;
    private String imageName;
}
