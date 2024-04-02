---
title: Current State
description: "Current state of completion, known deficiencies, and test environments used."
menu: State
order: 40
---

{% include ddc-abbreviations.md %}

## Completion state
{: menu="Completion" }

This app currently includes the basic functionality.  Navigation to all screen is possible through the intended methods.  The database can be populated with three fields, latitude, longitude and a boolean annotation for the security of a particular location.  Saved locations may be displayed on a separate screen with different background on the individual rows denoting secure or unsecure.  The setting screen allows for the countdown delay to be set, and this setting is used in the actual delay.  The disarm code entry works without additional buttons by sensing the length of the code.  The disarm code works with the default code.  

## Known deficiencies
{: menu="Deficiencies" }

 - App occasionally starts with no functionality.  The app will open but no buttons or fields are displayed.  The only fix found is to uninstall and reinstall the app.
 - Motion sensitivity in not adjustable and is currently set to high.  The app ws intended to have variable sensitivity based on location (secure vs unsecure).  This adjustability was not implemented for this release.  Further, the app is not sensitive to movement.  to trigger the warning state from the armed state, the phone must be shaken violently or even hit.
 - Camera functionality not implemented.  The app is supposed to take a photo or a quick video once motion is detected in the armed state.  This is not implemented in this release.
 - Preferences not complete.  The settings screen is supposed to allow the user to set the alarm sound, the warning sound, the length of the countdown delay, and the disarm code.  At this time, only the length of the countdown delay has been implemented.
 - No alarm or warning sound.  The alarm is supposed to have two distinct sounds; one to warn you motion has been detected and to enter your disarm code, and the other to alert you the phone is being stolen.  Neither was implemented in this release.
 - No alarm functionality.  Other than the alarm screen, no other functionality exists yet for this state.  In this state, the device was supposed to sound an audible alarm, take a photo or a quick video, save a location with the unsecure annotation, and begin GPS tracking.  Further, this information was supposed to be transmitted to a pre-determined email which is also not implemented.
 - The disarm code is a hard-coded default, as is the code length.  The code should be determined by the user.  The code length, used for the text watcher to determine if a correct length code has been entered, should be based on the code chosen by the user.
 - 

## Test environments used
{: menu="Environments" }

This app was tested on a Samsung S23.  No other devices or emulators were used.
