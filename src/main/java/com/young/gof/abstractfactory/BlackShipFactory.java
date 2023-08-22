package com.young.gof.abstractfactory;

public class BlackShipFactory implements ShipFactory {

    private final ShipPartsFactory shipPartsFactory;

    public BlackShipFactory(ShipPartsFactory shipPartsFactory){
        this.shipPartsFactory = shipPartsFactory;
    }
    @Override
    public Ship createShip() {
        Ship ship = new BlackShip();
        ship.setWheel(shipPartsFactory.createWheel());
        ship.setAnchor(shipPartsFactory.createAnchor());
        return ship;
    }
}
