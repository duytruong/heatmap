package org.grokking.heatmap.repository;

import org.grokking.heatmap.domain.LocationTraffic;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.List;

/**
 * Created by duyrau on 11/20/16.
 */

@Repository
public class LogEventRepositoryImpl implements LogEventRepository {

    @PersistenceContext
    private EntityManager em;

    @Override
    public List<LocationTraffic> getLocationTraffic() {
        Query query = em.createNativeQuery("with locations as (select data->>'location' as \"Location\", count(data->>'location') as \"View\" " +
                "from svcdb.log_event " +
                "where metric = 'pageview' " +
                "group by \"Location\" " +
                "order by \"View\" desc) " +
                "select \"Location\", \"View\" from locations l limit 10", "locationTrafficMapping");
        return query.getResultList();
    }

    @Override
    public List<LocationTraffic> getLocationTraffic1() {
        Session ss = em.unwrap(Session.class);
        SQLQuery q = ss.createSQLQuery("with locations as (select data->>'location' as \"Location\", count(data->>'location') as \"Number\" " +
                "from svcdb.log_event " +
                "where metric = 'pageview' " +
                "group by \"Location\" " +
                "order by \"Number\" desc) " +
                "select \"Location\", \"Number\" from locations l limit 10");
        List<LocationTraffic> res = q.list();
        return res;
    }
}
