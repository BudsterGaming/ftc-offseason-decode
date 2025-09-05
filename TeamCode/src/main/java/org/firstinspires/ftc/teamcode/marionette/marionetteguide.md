## What is marionette?

Marionette is a collection of code intended to make it easier for programmers to make a collection of hardware poses to tackle different tasks in different FTC challenges.
It can also be used to safeguard potentially experimental code, making it significantly harder for software to cause hardware damage.
Marionette is also intended to make it easier for less experienced coders to be able to sit down and fabricate well made and functioning code.

## A brief explanation of each component

Marionette - A collection of hardware poses to be accessed across the rest of the project
Pose - The class that contains all of the different different hardware that can be moved via a pose. All poses are kept in Marionette.
HardwareConstrainer - Keeps all hardware within the min and max values.
PoseSculptor - Interprets the poses and turns them into actual movement on the robot.

That's all the core components at the moment. I also have an example TeleOP (EnigmaTeleOP/PrimaryTeleOP)