package com.satyla.currency;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Currency;

@Getter
@NoArgsConstructor

public class Rate implements Serializable {

    private static long serialVersionUID = 1L;

    private String name;

    private Currency code;

    public Rate(Currency code) {
        this.code = code;
        this.name = code.toString();
    }

}
