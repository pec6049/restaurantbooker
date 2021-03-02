package com.eunchae.restaurantbooker.application;

import com.eunchae.restaurantbooker.domain.Region;
import com.eunchae.restaurantbooker.domain.RegionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegionService {

    @Autowired
    private RegionRepository regionRepository;

    @Autowired
    public RegionService(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    public List<Region> getRegions() {
        List<Region> regions = regionRepository.findAll();

        return regions;
    }

}
