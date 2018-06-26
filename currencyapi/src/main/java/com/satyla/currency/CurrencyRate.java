package com.satyla.currency;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.math.BigDecimal;
import java.util.Currency;

@Getter
@Setter
@ToString
@JsonIgnoreProperties(ignoreUnknown = true)
 class CurrencyRate {

    private Currency code;

    private BigDecimal mid;

}
