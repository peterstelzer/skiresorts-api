package com.maya.skiresorts.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Resort {
    private long resortId;
    private String resortName;
    private Integer squareFootage;
    private Integer verticalFeet;
}
