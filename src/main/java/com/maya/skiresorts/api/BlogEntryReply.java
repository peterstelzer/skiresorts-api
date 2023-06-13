package com.maya.skiresorts.api;

import com.maya.skiresorts.service.dto.BlogEntryDTO;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class BlogEntryReply {
    List<BlogEntryDTO> blogEntries;
}
