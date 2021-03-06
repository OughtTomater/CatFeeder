package net.teamhuffowicz.catfeeder.pinhandlers.digital;

import com.pi4j.component.servo.ServoDriver;
import com.pi4j.component.servo.ServoProvider;
import com.pi4j.component.servo.impl.RPIServoBlasterProvider;
import com.pi4j.io.gpio.Pin;

import java.io.IOException;

public class RPIServoBlasterExample {

    public void servo() throws IOException, InterruptedException {
        ServoProvider servoProvider = new RPIServoBlasterProvider();
        ServoDriver servo7 = servoProvider.getServoDriver(servoProvider.getDefinedServoPins().get(7));
        long start = System.currentTimeMillis();

        while (System.currentTimeMillis() - start < 120000) { // 2 minutes
            for (int i = 50; i < 150; i++) {
                servo7.setServoPulseWidth(i); // Set raw value for this servo driver - 50 to 195
                Thread.sleep(10);
            }
            for (int i = 150; i > 50; i--) {
                servo7.setServoPulseWidth(i); // Set raw value for this servo driver - 50 to 195
                Thread.sleep(10);
            }
        }
        System.out.println("Exiting RPIServoBlasterExample");
    }
}
