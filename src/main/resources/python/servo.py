# Servo Control
import time
import wiringpi

# use 'GPIO naming'
wiringpi.wiringPiSetupGpio()

# set #18 to be a PWM output
wiringpi.pinMode(18, wiringpi.GPIO.PWM_OUTPUT)

# set the PWM mode to milliseconds stype
wiringpi.pwmSetMode(wiringpi.GPIO.PWM_MODE_MS)

# divide down clock
wiringpi.pwmSetClock(192)
wiringpi.pwmSetRange(2000)

delay_period = 0.01
RUNNING = True

try:
    while RUNNING:
        for pulse in range(100, 250, 1):
            wiringpi.pwmWrite(18, pulse)
            time.sleep(delay_period)

except KeyboardInterrupt:
    RUNNING = False
    print "Stopping Servo..."
    wiringpi.pwmWrite(18,0)

finally:
    print "Servo Stopped!"
