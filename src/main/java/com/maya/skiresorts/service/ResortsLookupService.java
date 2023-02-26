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
        return resortDAO.getResorts().stream().map(r -> toDTO(r)).toList();
    }

    private ResortDTO toDTO(Resort resort) {
        return ResortDTO.builder()
                .resortId(resort.getResortId())
                .resortName(resort.getResortName())
                .squareFootage(resort.getSquareFootage())
                .verticalFeet(resort.getVerticalFeet())
                .build();
    }
}
