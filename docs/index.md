---
title: Overview
description: "Project proposal or summary of in-progress/completed project."
menu: Overview
order: 0
---

{% include ddc-abbreviations.md %}

## Summary

The Leave Me alone app is designed to provide additional security to those people who frequently 
have their phones in public places. The app, once activated, will sound an alarm if the phone is 
moved before the unlock code is entered.  Additionally, the app will determine which camera is 
facing up and take a photo.  This photo will be sent to the user's email address to assist in 
identifying the phone theft culprit.

## Intended users & user stories
{: menu="Users" }

The primary user is one who has their phone in public places frequently.  Users of this type include 
students, professionals, sales people, etc.  Also in this category are users who are prone to 
forgetting their phones.

The other type of user is a practical joker.  This person might install this app on their phone and
ask a friend to hand the phone to them.  Alternatively, the practical joker might install the app
on a friend's phone so the friend cannot touch the phone without setting off the alarm.

As a professional who frequents places where phones may be taken, I want an alarm that makes a so uncomfortable, they drop my phone and run.  I would like a picture to be taken of that person,

As a person who has their life saved in their phone, I want an alarm app that will track the location of my phone when stolen so the police can recover my phone

As a practical joker, I would love an app that would scare my friends if they touched my phone.

## Functionality

The user will be able to do the following:
  * Set an alarm type, similar to ringtone only much louder
  * Trigger alarm immediately
  * Set method of engagement, either manually or automatically when the screen times out
  * set an address (email, text, Whatsapp) to which photos to be sent in the event of theft
  * set an authentication code to disable the alarm
  * set a delay for entering the authentication code

## Persistent data
{: menu="Persistence" }

* User
    * Authentication code
    * Alarm and chirp preferences
    * Delay times
    * Manual/Automatic mode (on startup)
    * List of secure and unsecure locations based on previous triggered alerts
    
## Device/external services
{: menu="Services" }

Device Services

  * CameraX - https://developer.android.com/media/camera/camerax This will be used to take a picture on both the front-facing and rear-facing cameras in the event of theft. This code will live on the device
  * GPS Services - https://developer.android.com/develop/sensors-and-location/location/request-updates The GPS is used to set the location of secure and unsecure locations.  Then, the GPS is used to automatically detect those locations and change the alert settings accordingly.  In addition, if the phone is stolen, The GPS is used to get current locations to send through email to the owner in an effort to track the phone.  
  * Motion Sensors - https://developer.android.com/develop/sensors-and-location/sensors/sensors_motion Sensors will include accelerometers, gyroscopes and linear motion sensors used to detect motion after the alarm has been armed
  * Sounds - https://developer.android.com/reference/android/media/SoundPool The SoundPool manager will play the alarm and chirp sounds as necessary

External Services

  * Email tools - https://developer.android.com/guide/components/intents-common This is a list of comm Intents including sending email with multiple attachments
  * https://developer.android.com/reference/android/content/Intent#ACTION_SEND This is the specific Intent for emailing with an attachment

Service Requirements

All services will be highly recommended but the app will operate without any dangerous services, 
although at a somewhat reduced capability.

## Stretch goals and possible enhancements 
{: menu="Stretch goals" }

  * Add GPS tracking so the phone can be followed
  * Use phone sleep time out to arm alarm
  * Add notification to Whatsapp, Instagram and others
  * Tools to add sounds to library


