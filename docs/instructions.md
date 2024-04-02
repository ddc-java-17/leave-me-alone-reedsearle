---
title: Instructions
description: "Project build instructions and user instructions for the app."
menu: Instructions
order: 30
---

{% include ddc-abbreviations.md %}

## Build instructions
{: menu="Build" }

 - Navigate to [https://github.com/ddc-java-17/leave-me-alone-reedsearle](https://github.com/ddc-java-17/leave-me-alone-reedsearle)
 - Click the green [<>Code] button
 - Clone the directory
 - In IntelliJ, choose File > New > Project from Version Control
 - Copy the URL
 - Click [Clone] at bottom of screen
 - Connect phone or emulator
 - Ensure both the target device and "app" appear on the top bar
 - Click green triangle to build and install app


## User instructions
{: menu="User" }

Once the app has been selected, go through the login process and ACCEPT all requested permissions.  The app will not work without these permissions.  
The first screen after login has four options:
 - ALARM
 - Arm
 - Set Location
 - Display Locations

Additionally, the three dots in the upper right corner allow access to the settings screen and to sign out of the app.

ALARM sounds the alarm immediately.  This is useful in panic situations

Arm will activate the motion sensors and sound the alarm if the device is moved (stolen).  Be aware, the app will go into warning mode when you pick it up as you have moved it.  You have a short period of time to enter you disarm code before the alarm sounds.

Set Location opens a dialog window that allows you to set locations as either secure or unsecure.

Display Locations will display all set locations and remind you if they are secure or not.

### Set Location

On this screen, your current location may be saved with an annotation depicting this location as either secure or unsecure.  These annotations will later be used to vary the sensitvity of the device to motion in the armed state.  Cancel will exit the screen without a location being saved.

### Display Locations

This screen will display all of your saved locations as well as locations where the alarm has been triggered.  

### Arm

disarm code = 1234

At this screen, the device is sensing any movement.  The only choices are to enter the disarm code to return to the main screen or to let movement activate the warning screen.  Please note, when you pick up your phone to enter the disarm code, you are highly likely to end up in the warning screen.

### Warning

disarm code = 1234

On this screen, you will see a countdown timer (settable in the Settings screen), and hear the warning sound.  This is the time alloted to enter the disarm code.  If the code is not entered correctly by the time the timer expires, the alarm will sound and will transfer to the alarm sounding screen.

### Alarm 

disarm code = 1234

By the time you reach this screen, the alarm is sounding.  You still have the option of entering the disarm code to silence the alarm and return to the main screen.

### Settings

Here, you may set the type of alarm sound, the type of warning sound, the length of countdown delay time, and your disarm code.  These are persistant.  Unless you uninstall the app, these preferences will remain in effect each time you open the app.

### Sign Out

This will exit you from the app.


