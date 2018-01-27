package net.teamhuffowicz.catfeeder.pinhandlers.digital;

import com.pi4j.io.gpio.*;
import com.pi4j.wiringpi.Gpio;

public class Pwm {

   private final GpioController gpioFactory = GpioFactory.getInstance();

   public void turnServo(){
       Gpio.pinMode(18,Gpio.PWM_OUTPUT);
       Gpio.pwmSetMode(Gpio.PWM_MODE_MS);
       Gpio.pwmSetClock(384);
       Gpio.pwmSetRange(1000);
       Gpio.pwmWrite(18,75);
   }

   /*public GpioPinPwmOutput createServo(String pin){
        GpioPinPwmOutput servo = gpioFactory.provisionPwmOutputPin(RaspiPin.GPIO_26);
        return servo;
    }*/

}
