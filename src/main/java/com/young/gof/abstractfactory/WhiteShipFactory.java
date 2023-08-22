package com.young.gof.abstractfactory;

public class WhiteShipFactory implements ShipFactory {

    private final ShipPartsFactory shipPartsFactory;

    public WhiteShipFactory(ShipPartsFactory shipPartsFactory) {
        this.shipPartsFactory = shipPartsFactory;
    }

    @Override
    public Ship createShip() {
        Ship ship = new WhiteShip();
        ship.setWheel(shipPartsFactory.createWheel());
        ship.setAnchor(shipPartsFactory.createAnchor());
        return ship;
    }
}
