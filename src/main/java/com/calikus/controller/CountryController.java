package com.calikus.controller;

import com.calikus.dto.CountryDto;
import com.calikus.entity.Country;
import com.calikus.mapper.ICountryMapper;
import com.calikus.service.interfaces.ICountryService;
import com.calikus.util.constants.Api;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping(Api.Country.BASE_URL)
public class CountryController {

    private final ICountryService countryService;

    private final ICountryMapper countryMapper;

    @GetMapping
    public List<Country> getAllCountries(){
        return countryService.getAllCountries();
    }

    @PostMapping
    public ResponseEntity<CountryDto> insertCountry(@RequestBody CountryDto countryDto){
        Country mappedCountry = countryMapper.toCountry(countryDto);
        Country country = countryService.insertCountry(mappedCountry);
        return ResponseEntity.ok(countryMapper.fromCountry(country));
    }

    @GetMapping(Api.Country.COUNTRY_NAMES)
    public List<String> getAllCountryNames(){
        return countryService.getAllCountryNames();
    }

    @PostMapping(Api.Country.INSERT_ALL)
    public List<Country> insertCountries(){
        return countryService.insertCountries();
    }

}
