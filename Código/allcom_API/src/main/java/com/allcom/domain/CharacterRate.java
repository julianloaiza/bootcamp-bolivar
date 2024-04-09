package com.allcom.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CharacterRate {
    private int characterRateId;
    private String userNameId;
    private int charactersStart;
    private int charactersEnd;
    private double price;
}
