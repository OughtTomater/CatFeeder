package net.teamhuffowicz.catfeeder.controller;

import com.pi4j.io.gpio.*;
import net.teamhuffowicz.catfeeder.pinhandlers.digital.Pwm;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeederController {

    private static GpioPinDigitalOutput pin;
    Pwm servo = new Pwm();

    /*@RequestMapping("/")
    public String greeting() {
        return "Hello World";
    }*/

    @RequestMapping("/toggle")
    public String light() throws InterruptedException {
        pin.toggle();
        return "Toggled LED";
    }

    @RequestMapping("/on")
    public String turnOn() {
        System.out.println("this works");
        getPin(1).high();
    return "LED ON!";
    }

    @RequestMapping("/off")
    public String turnOff() {
        getPin(1).low();
        return "LED Off!";
    }

    @RequestMapping("/blink")
    public String blinkLed() {
        getPin(1).blink(200, 5000);
        return "Blink...blink...blink";
    }

    @RequestMapping("/servo")
    public String servo(){
        servo.screwItJustUsePython();
        return "turning servo";
    }

    public GpioPinDigitalOutput getPin(int pinNumber) {
        if (pin == null) {
            GpioController gpioController = GpioFactory.getInstance();
            pin = gpioController.provisionDigitalOutputPin(RaspiPin.getPinByAddress(pinNumber), "MyLED", PinState.LOW);
        }
        return pin;
    }


    /*@RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }*/

}
