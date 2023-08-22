package com.young.gof.abstractfactory;

public interface ShipFactory {

    default Ship orderShip(String name, String email) {
        validate(name, email);
        prepareFor(name);
        Ship ship = createShip();
        sendEmailTo(email, ship);
        return ship;

    }

    Ship createShip();

    private static void sendEmailTo(String email, Ship ship) {
        System.out.println(ship.getName() + " has been completed");
        System.out.println("sending e-mail to " + email);
    }

    private void prepareFor(String name) {
        System.out.println(name = " building");
    }

    private void validate(String name, String email) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("please name the ship");
        }
        if (email == null || email.isBlank()) {
            throw new IllegalArgumentException("please put the e-mail");
        }

    }

}
