package com.psr.repository;

import com.psr.models.Category;
import com.psr.models.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryReposity extends JpaRepository<Country, Integer> {
}
