package org.grokking.heatmap.repository;

import org.grokking.heatmap.domain.LocationTraffic;

import java.util.List;

/**
 * Created by duyrau on 11/19/16.
 */

public interface LogEventRepository {

//    @Query(value = "with locations as (select data->>'location' as \"Location\", count(data->>'location') as \"Number\" " +
//            "from svcdb.log_event " +
//            "where metric = 'pageview' " +
//            "group by \"Location\" " +
//            "order by \"Number\" desc) select new org.grokking.heatmap.domain.LocationTraffic(l.Location, l.Number) from locations l limit 10;", nativeQuery = true)
    List<LocationTraffic> getLocationTraffic();

    List<LocationTraffic> getLocationTraffic1();
}
