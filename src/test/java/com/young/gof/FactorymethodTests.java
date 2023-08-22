package com.young.gof;

import com.young.gof.factorymethod.BlackShipFactory;
import com.young.gof.factorymethod.WhiteShipFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class FactorymethodTests {

    @Test
    void factory_method_basic() {
        new WhiteShipFactory().orderShip("WhiteShip", "youngjun103@gmail.com");
        new BlackShipFactory().orderShip("BlackShip", "youngjun103@gmail.com");
    }

    @Test
    void factory_method_spring_example() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        BeanFactory beanFactory = context.getBeanFactory();
        System.out.println(beanFactory.getBean("hello"));
    }
    static class SpringConfig{
        @Bean
        public String hello(){
            return "Hello";
        }
    }
}
