package com.maya.skiresorts.dao;

import com.maya.skiresorts.domain.Resort;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ResortDAO {
    private final JdbcTemplate jdbcTemplate;
    public List<Resort> getResorts(){
        return jdbcTemplate.query("select * from skiingadmin.resort;",
                (rs, rowNum) -> Resort.builder()
                        .resortId(rs.getInt("resort_id"))
                        .resortName(rs.getString("resort_name"))
                        .acreage(rs.getInt("resort_acreage"))
                        .verticalHeight(rs.getInt("resort_vertical_height"))
                        .numberOfLifts(rs.getInt("num_lifts"))
                        .numberOfRuns(rs.getInt("num_runs"))
                        .mapUrl(rs.getString("resort_map"))
                        .passOffered(rs.getString("pass_offered"))
                        .numberOfTerrainParks(rs.getInt("num_terain_parks"))
                        .percentBeginner(rs.getInt("percent_beginner"))
                        .percentIntermediate(rs.getInt("percent_intermediate"))
                        .percentExpert(rs.getInt("percent_expert"))
                        .cityState(rs.getString("city_state"))
                        .build());
    }
}
