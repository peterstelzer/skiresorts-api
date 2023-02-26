package com.maya.skiresorts.controller;

import com.maya.skiresorts.api.ResortsReply;
import com.maya.skiresorts.service.ResortsLookupService;
import com.maya.skiresorts.service.dto.ResortDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/resorts")
@RequiredArgsConstructor
public class HomeController {
    private final ResortsLookupService resortsLookupService;

    @GetMapping()
    public ResortsReply getResorts(){
        return toReply(resortsLookupService.getResorts());
    }

    private ResortsReply toReply(List<ResortDTO> resorts) {
        return ResortsReply.builder().resorts(resorts).build();
    }
}
