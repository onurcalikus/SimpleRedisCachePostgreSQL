package com.calikus.controller;

import com.calikus.service.interfaces.ICacheService;
import com.calikus.util.constants.Api;
import com.calikus.util.constants.CacheNames;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.*;

@Profile("!prod")
@RestController
@RequiredArgsConstructor
@RequestMapping(Api.Cache.BASE_URL)
public class CacheController {

    private final ICacheService cacheService;

    @DeleteMapping(Api.Cache.EVICT_COUNTRY_NAMES)
    public Boolean evictCountryNamesCache() {
        cacheService.evictCacheValues(CacheNames.COUNTRY_NAMES);
        return true;
    }
}
