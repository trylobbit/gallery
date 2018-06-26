package com.satyla.currency;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.Currency;

@Service
public class CurrencyService {

    private static final Logger LOG = LoggerFactory.getLogger(CurrencyService.class);

    private final RestTemplate restTemplate;

    private String currencyUrl;

    @Autowired
    public CurrencyService(RestTemplate restTemplate, CurrencySourceConnector currencySourceConnector) {
        this.restTemplate = restTemplate;
        this.currencyUrl = currencySourceConnector.getCountryRateUrl();
    }

    @Cacheable(value = "currency", key = "#code")
    public BigDecimal getRateForCode(Currency code) {
        CurrencyJson[] currencies = restTemplate.getForObject(currencyUrl, CurrencyJson[].class);
        CurrencyJson rates = currencies[0];
        LOG.info("Country code {} , response {}", code, rates.toString());

        return rates.getCurrencyRates()
                .stream()
                .filter(currencyRate -> currencyRate.getCode().equals(code))
                .findFirst()
                .map(CurrencyRate::getMid)
                .orElseThrow(IllegalArgumentException::new);
    }

}
