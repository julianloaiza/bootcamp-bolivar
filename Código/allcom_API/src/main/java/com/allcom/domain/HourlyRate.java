package com.allcom.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class HourlyRate {
    private int hourlyRateId;
    private String userNameId;
    private LocalDateTime hourlyStart;
    private LocalDateTime hourlyEnd;
    private double price;
}
