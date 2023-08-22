package com.young.gof.abstractfactory;

public class WhiteProShipPartsFactory implements ShipPartsFactory{
    @Override
    public Wheel createWheel() {
        return new WhiteProWheel();
    }

    @Override
    public Anchor createAnchor() {
        return new WhiteProAnchor();
    }
}
