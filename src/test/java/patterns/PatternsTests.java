package patterns;

import org.example.patterns.builder.Car;
import org.example.patterns.builder.SportCarBuilder;
import org.example.patterns.decorator.CheeseDecorator;
import org.example.patterns.decorator.PepperoniPizza;
import org.example.patterns.decorator.Pizza;
import org.example.patterns.factory.CoffeeBase;
import org.example.patterns.factory.CoffeeFactory;
import org.example.patterns.factory.CoffeeType;
import org.example.patterns.singelton.Singleton;
import org.example.patterns.singelton.SingletonThreadSafe;
import org.testng.annotations.Test;

public class PatternsTests {

    @Test
    public void factoryTest()
    {
        CoffeeBase late = CoffeeFactory.orderCoffee(CoffeeType.LATTE);
        CoffeeBase americano = CoffeeFactory.orderCoffee(CoffeeType.AMERICANO);
    }


    @Test
    public void builderTests()
    {
        Car car = new SportCarBuilder()
                .withBody()
                .withColor("blue")
                .withInterior()
                .build();

        Car partialCar = new SportCarBuilder()
                .withColor()
                .withInterior()
                .build();

         System.out.println(car.toString());
         System.out.println(partialCar.toString());
    }

    @Test
    public void singletonTests()
    {
        Singleton singleton = Singleton.getInstance("1");
        System.out.println(singleton.getValue());
        Singleton singleton2 = Singleton.getInstance("2");
        System.out.println(singleton2.getValue());

        SingletonThreadSafe singletonThreadSafe = SingletonThreadSafe.getInstance("3");
        System.out.println(singletonThreadSafe.getValue());
        SingletonThreadSafe singletonThreadSafe2 = SingletonThreadSafe.getInstance("2");
        System.out.println(singletonThreadSafe2.getValue());
    }

    @Test
    public void decoratorTests()
    {
        Pizza peperoniPizza = new PepperoniPizza();
        System.out.println(peperoniPizza.getDescription() + ":$" + peperoniPizza.getCost());

        peperoniPizza  = new CheeseDecorator(peperoniPizza);
        System.out.println(peperoniPizza.getDescription() + ":$" + peperoniPizza .getCost());
    }
}
