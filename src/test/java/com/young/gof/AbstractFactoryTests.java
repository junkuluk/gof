package com.young.gof;

import com.young.gof.abstractfactory.BlackShipFactory;
import com.young.gof.abstractfactory.Ship;
import com.young.gof.abstractfactory.WhiteProShipPartsFactory;
import com.young.gof.abstractfactory.WhiteShipFactory;
import com.young.gof.abstractfactory.WhiteShipPartsFactory;
import org.junit.jupiter.api.Test;

public class AbstractFactoryTests {

    @Test
    void abstract_factory_method_basic() {
        WhiteShipFactory whiteShipFactory = new WhiteShipFactory(new WhiteShipPartsFactory());
        Ship ship = whiteShipFactory.createShip();
        System.out.println(ship.toString());

        WhiteShipFactory whiteShipFactory2 = new WhiteShipFactory(new WhiteProShipPartsFactory());
        Ship ship2 = whiteShipFactory2.createShip();
        System.out.println(ship2.toString());

        BlackShipFactory blackShipWithWhiteParts = new BlackShipFactory(new WhiteShipPartsFactory());
        Ship ship3 = blackShipWithWhiteParts.createShip();
        System.out.println(ship3.toString());


    }

}
