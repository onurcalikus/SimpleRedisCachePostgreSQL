package com.calikus.service.interfaces;

import com.calikus.entity.Country;

import java.util.List;

public interface ICountryService {

    List<Country> getAllCountries();

    List<String> getAllCountryNames();

    List<Country> insertCountries();

    Country insertCountry(Country country);

}
