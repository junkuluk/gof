package com.young.gof.abstractfactory;

public class WhiteShipPartsFactory implements ShipPartsFactory{
    @Override
    public Wheel createWheel() {
        return new WhiteWheel();
    }

    @Override
    public Anchor createAnchor() {
        return new WhiteAnchor();
    }
}
