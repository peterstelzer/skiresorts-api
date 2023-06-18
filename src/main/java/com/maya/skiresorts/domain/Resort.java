package com.maya.skiresorts.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Resort {
    private long resortId;
    private String resortName;
    private Integer acreage;
    private Integer verticalHeight;
    private Integer numberOfLifts;
    private Integer numberOfRuns;
    private String mapUrl;
    private String passOffered;
    private Integer numberOfTerrainParks;
    private Integer percentBeginner;
    private Integer percentIntermediate;
    private Integer percentExpert;
    private String cityState;

}
