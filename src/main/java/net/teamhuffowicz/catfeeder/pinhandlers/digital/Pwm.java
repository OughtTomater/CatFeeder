package net.teamhuffowicz.catfeeder.pinhandlers.digital;

import com.pi4j.io.gpio.*;
import com.pi4j.util.CommandArgumentParser;
import com.pi4j.wiringpi.Gpio;
import org.python.util.PythonInterpreter;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Pwm {

   private final GpioController gpio = GpioFactory.getInstance();


   public void turnServo(int servoPin){
       Gpio.pinMode(servoPin,Gpio.PWM_OUTPUT);
       Gpio.pwmSetMode(Gpio.PWM_MODE_MS);
       Gpio.pwmSetClock(192);
       Gpio.pwmSetRange(2000);
       Gpio.pwmWrite(servoPin,200);
   }

    public void turnServobackwards(int servoPin){
        Gpio.pinMode(servoPin,Gpio.PWM_OUTPUT);
        Gpio.pwmSetMode(Gpio.PWM_MODE_MS);
        Gpio.pwmSetClock(256);
        Gpio.pwmSetRange(1500);
        Gpio.pwmWrite(servoPin,200);
    }

   public void stopServo(int servoPin){
       Gpio.pwmWrite(servoPin , 0);
   }

}
