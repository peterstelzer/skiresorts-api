package com.maya.skiresorts.api;

import com.maya.skiresorts.service.dto.ResortDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class ResortsReply {
    List<ResortDTO> resorts;
}
