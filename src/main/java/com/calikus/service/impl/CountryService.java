package com.calikus.service.impl;

import com.calikus.entity.Country;
import com.calikus.initializer.CountryInitializer;
import com.calikus.repository.ICountryRepository;
import com.calikus.service.interfaces.ICountryService;
import com.calikus.util.constants.CacheNames;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CountryService implements ICountryService {

    private final ICountryRepository countryRepository;

    @Override
    public List<Country> getAllCountries() {
        return countryRepository.findAll();
    }

    @Cacheable(CacheNames.COUNTRY_NAMES)
    @Override
    public List<String> getAllCountryNames() {
        System.out.println("Veritabanına Erişildi! Cache Mekanizması Kullanılmadı.");
        return countryRepository.findAllCountryNames();
    }

    @Override
    public List<Country> insertCountries() {
        return countryRepository.saveAll(CountryInitializer.readCountries());
    }

    @Caching(
            evict = {
                    @CacheEvict(value = CacheNames.COUNTRY_NAMES, allEntries = true, condition = "#country.code != null")
            }
    )
    @Override
    public Country insertCountry(Country country) {
        return countryRepository.save(country);
    }
}
