package com.young.gof.abstractfactory;

import lombok.Data;

@Data
public class Ship {

    private String name;
    private String color;
    private String logo;

    private Wheel wheel;
    private Anchor anchor;

}
