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
facing up and take a photo.  THis photo will be sent to the user's email address to assist in 
identifying the phone theft culprit.

## Intended users & user stories
{: menu="Users" }

The primary user is one who has their phone in public places frequently.  Users of this type include 
students, professionals, sales people, etc.  Also in this category are users who are prone to 
forgetting their phones.

As someone who lives in a place where phone might be taken, I want a feature that makes a loud noise 
to alert me that someone has grabbed my phone.  I would like a picture to be taken of that person
so I have a chance of getting my phone back.

The other type of user is a practical joker.  This person might install this app on their phone and 
ask a friend to hand the phone to them.  Alternatively, the practical joker might install the app
on a friend's phone so the friend cannot touch the phone without setting off the alarm.

As a practical joker, I would love an app that would scare my friends if they touched my phone.

## Functionality

The user will be able to do the following:
  * Set an alarm type, similar to ringtone only much louder
  * Set method of engagement, either manually or automatically when the screen times out
  * set an address (email, text, Whatsapp) to which photos to be sent in the event of theft
  * set an authentication code to disable the alarm
  * set a delay for entering the authentication code

## Persistent data
{: menu="Persistence" }

* User
    * Authentication code
    * Alarm preferences
    * Delay times
    * Manual/Automatic mode (on startup)
    
## Device/external services
{: menu="Services" }

Device Services
  * Accelerometer
  * Cameras
  * Phone data related to screen time out

External Services
  * Email tools
  * text tools
  * Whatsapp, Instagram type apps

## Stretch goals and possible enhancements 
{: menu="Stretch goals" }

I would like to add GPS tracking so the phone can be followed


