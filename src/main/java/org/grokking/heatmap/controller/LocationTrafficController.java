package org.grokking.heatmap.controller;

import org.grokking.heatmap.domain.LocationTraffic;
import org.grokking.heatmap.repository.LogEventRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by duyrau on 11/19/16.
 */

@RestController
@RequestMapping(path = "/locationtraffic")
public class LocationTrafficController {

    @Inject
    private LogEventRepository logEventRepository;

    @RequestMapping("")
    public List<LocationTraffic> getLocationTraffic() {
        List<LocationTraffic> traffics = logEventRepository.getLocationTraffic();
        return traffics;
    }
}
