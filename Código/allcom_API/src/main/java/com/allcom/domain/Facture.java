package com.allcom.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
public class Facture {
    private int FactureId;
    private String userNameId;
    private LocalDateTime dateReportId;
    private double amount;
}
