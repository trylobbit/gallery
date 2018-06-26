package com.satyla.currency;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ToString
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
 class CurrencyJson {

    private CurrencyRate[] rates;

    List<CurrencyRate> getCurrencyRates() {
        return new ArrayList<>(Arrays.asList(rates));
    }

}
