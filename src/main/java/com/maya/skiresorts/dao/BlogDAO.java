package com.maya.skiresorts.dao;

import com.maya.skiresorts.domain.BlogEntry;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BlogDAO {
    private final JdbcTemplate jdbcTemplate;
    public List<BlogEntry> getBlogEntries(){
        return jdbcTemplate.query("select * from content;",
                (rs, rowNum) -> BlogEntry.builder()
                        .id(rs.getInt("content_id"))
                        .title(rs.getString("title"))
                        .createDate(rs.getDate("create_date").toLocalDate())
                        .author(rs.getString("author"))
                        .content(rs.getString("content"))
                        .build());
    }
}
