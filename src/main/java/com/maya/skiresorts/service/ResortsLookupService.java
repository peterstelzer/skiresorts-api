package com.maya.skiresorts.service;

import com.maya.skiresorts.dao.ResortDAO;
import com.maya.skiresorts.domain.Resort;
import com.maya.skiresorts.service.dto.ResortDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResortsLookupService {
    private final ResortDAO resortDAO;

    public List<ResortDTO> getResorts(){
        return resortDAO.getResorts().stream().map(this::toDTO).toList();
    }

    private ResortDTO toDTO(Resort resort) {
        return ResortDTO.builder()
                .resortId(resort.getResortId())
                .resortName(resort.getResortName())
                .acreage(resort.getAcreage())
                .verticalHeight(resort.getVerticalHeight())
                .numberOfLifts(resort.getNumberOfLifts())
                .numberOfRuns(resort.getNumberOfRuns())
                .mapUrl(resort.getMapUrl())
                .passOffered(resort.getPassOffered())
                .numberOfTerrainParks(resort.getNumberOfTerrainParks())
                .percentBeginner(resort.getPercentBeginner())
                .percentIntermediate(resort.getPercentIntermediate())
                .percentExpert(resort.getPercentExpert())
                .cityState(resort.getCityState())
                .build();
    }

}
