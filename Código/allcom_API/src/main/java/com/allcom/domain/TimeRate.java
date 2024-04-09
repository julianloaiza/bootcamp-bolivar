package com.allcom.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class TimeRate {
    private int timeRateId;
    private String userNameId;
    private double timeStart;
    private double timeEnd;
    private double price;
}
