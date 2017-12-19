package net.teamhuffowicz.catfeeder.controller;

import com.pi4j.io.gpio.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeederController {

    private static GpioPinDigitalOutput pin;
    private static GpioPinPwmOutput pwm;

    @RequestMapping("/")
    public String greeting() {
        return "Hello World";
    }

    @RequestMapping("/toggle")
    public String light() throws InterruptedException {
        pin.toggle();
        return "Toggled LED";
    }

    @RequestMapping("/on")
    public void turnOn() {
        getPin(1).high();
    }

    @RequestMapping("/off")
    public void turnOff() {
        getPin(1).low();
    }

    @RequestMapping("/blink")
    public void blinkLed() {
        getPin(1).blink(200, 5000);
    }

    public GpioPinDigitalOutput getPin(int pinNumber) {
        if (pin == null) {
            GpioController gpioController = GpioFactory.getInstance();
            pin = gpioController.provisionDigitalOutputPin(RaspiPin.getPinByAddress(pinNumber), "MyLED", PinState.LOW);
        }
        return pin;
    }

    public GpioPinPwmOutput getPwm(){
        getPin(1).isMode(PinMode.PWM_OUTPUT);

        return null;
       }

    /*@RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }*/

}
