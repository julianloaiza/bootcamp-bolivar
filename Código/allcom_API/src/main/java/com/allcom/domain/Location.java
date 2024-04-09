package com.allcom.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class Location {
    private int locationId;
    private LocalDateTime dateReportId;
    private String locationName;
    double amount;
}
