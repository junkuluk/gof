package com.young.gof.factorymethod;

import lombok.Data;


public class WhiteShip extends Ship{

    public WhiteShip(){
        setName("whiteship");
        setColor("white");
        setLogo("🛳️");
    }

}
