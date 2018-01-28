package net.teamhuffowicz.catfeeder.pinhandlers.digital;

import com.pi4j.io.gpio.*;
import com.pi4j.util.CommandArgumentParser;
import com.pi4j.wiringpi.Gpio;
import org.python.util.PythonInterpreter;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Pwm {

   private final GpioController gpio = GpioFactory.getInstance();

   Pin pin = CommandArgumentParser.getPin(RaspiPin.class, RaspiPin.GPIO_01);

    GpioPinPwmOutput pwm = gpio.provisionPwmOutputPin(pin);

    public void screwItJustUsePython(){
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.exec("import sys\nsys.path.append(\"/home/pi/\")\nfrom piServo import turnServo\nturnServo()");
    }

   public void turnServo(){
       Gpio.pinMode(18,Gpio.PWM_OUTPUT);
       Gpio.pwmSetMode(Gpio.PWM_MODE_MS);
       Gpio.pwmSetClock(192);
       Gpio.pwmSetRange(2000);
       Gpio.pwmWrite(18, 75);
   }

   public void stopServo(){
       Gpio.pwmWrite(18 , 0);
   }

}
