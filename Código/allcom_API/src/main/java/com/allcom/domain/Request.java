package com.allcom.domain;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Request {

    private int requestId;
    private String userNameId;
    private int factureId;
    private char state;
    private String description;

}
