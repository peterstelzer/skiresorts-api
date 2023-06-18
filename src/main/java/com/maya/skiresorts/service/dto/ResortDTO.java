package com.maya.skiresorts.service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResortDTO {
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
