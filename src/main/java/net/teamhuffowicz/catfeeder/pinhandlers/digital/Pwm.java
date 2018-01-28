package net.teamhuffowicz.catfeeder.pinhandlers.digital;

import com.pi4j.io.gpio.*;
import com.pi4j.util.CommandArgumentParser;
import com.pi4j.wiringpi.Gpio;

public class Pwm {

   private final GpioController gpio = GpioFactory.getInstance();

   Pin pin = CommandArgumentParser.getPin(RaspiPin.class, RaspiPin.GPIO_01);

    GpioPinPwmOutput pwm = gpio.provisionPwmOutputPin(pin);

   public void turnServo(){
       Gpio.pinMode(18,Gpio.PWM_OUTPUT);
       Gpio.pwmSetMode(Gpio.PWM_MODE_MS);
       Gpio.pwmSetClock(192);
       Gpio.pwmSetRange(2000);
       pwm.setPwm(500);
   }

   /*public GpioPinPwmOutput createServo(String pin){
        GpioPinPwmOutput servo = gpioFactory.provisionPwmOutputPin(RaspiPin.GPIO_26);
        return servo;
    }*/

}
