package org.grokking.heatmap.domain;

import javax.persistence.*;

/**
 * Created by duyrau on 11/18/16.
 */

// http://stackoverflow.com/a/36109273/4422260
@SqlResultSetMapping(
    name = "locationTrafficMapping",
    classes = {
        @ConstructorResult(
            targetClass = LocationTraffic.class,
            columns = {
                @ColumnResult(name = "Location", type = String.class),
                @ColumnResult(name = "View", type = Long.class)
            }
        )
    }
) @Entity
class LocationTrafficCfgEntity{@Id int id;}

public class LocationTraffic {

    private String location;

    private long view;

    public LocationTraffic(String location, long view) {
        this.location = location;
        this.view = view;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public long getView() {
        return view;
    }

    public void setView(long view) {
        this.view = view;
    }
}
