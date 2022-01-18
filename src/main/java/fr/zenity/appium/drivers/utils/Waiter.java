package fr.zenity.appium.drivers.utils;

import org.openqa.selenium.WebDriver;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Function;

public class Waiter<T extends WebDriver> {

    private T driver;
    private int seconds;

    public Waiter(T driver, int seconds ){
        this.driver     = driver;
        this.seconds    = seconds;
    }

    public <V> V until(Function<T, V> isTrue){
        Duration end = Duration.ofSeconds(this.seconds);
        long start   = System.nanoTime();
        long stop    = System.nanoTime() + end.getSeconds();
        V returned = null;

        do{
            start   = System.nanoTime();
            try{
                //
                returned = isTrue.apply(this.driver);
                if(!Objects.isNull(returned)) break;

            }catch (Exception e){ }
        }while ( start < stop );

        if(Objects.isNull(returned)) throw new NoSuchElementException("Element not Found");

        return returned;
    }


}