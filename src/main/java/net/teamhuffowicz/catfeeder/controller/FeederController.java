package net.teamhuffowicz.catfeeder.controller;

import com.pi4j.io.gpio.*;
import com.pi4j.wiringpi.Gpio;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeederController {

    private static GpioPinDigitalOutput pin;

    @RequestMapping("/")
    public String greeting(){
        return "Hello World";
    }

    @RequestMapping("/light")
    public String light() throws InterruptedException {
        if (pin ==null) {
            GpioController gpioController = GpioFactory.getInstance();
            pin = gpioController.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.LOW);
        }
        Thread.sleep(5000);
        pin.toggle();
        return "Toggled LED";
    }
}
