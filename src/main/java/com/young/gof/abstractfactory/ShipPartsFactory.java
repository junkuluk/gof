package com.young.gof.abstractfactory;

public interface ShipPartsFactory {
    Wheel createWheel();
    Anchor createAnchor();
}
