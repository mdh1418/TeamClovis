# TeamClovis

This is the Android Studio code for the Fall 2017 MIT PPAT Team Clovis Project. It is a dynamic drag and drop keyboard with audio effects on selected buttons.

## Getting Started

### Installing the keyboard application on your tablet 

A) To export the application from Android Studio, follow these steps: 
```
Within Android Studio, select 'Build' from the top bar --> Build APK 
```

B) To export application from your computer to the tablet, follow these steps: 

#### NOTE: For Mac users, you need to download Android File Transfer software from https://www.android.com/filetransfer/ first. Then, drag your apk file from your computer into the Android File Transfer popup on your screen ####

```
Connect your tablet to your computer with a USB cable. On your tablet, select 'My Files' --> go to 'Downloads' --> click your apk file to install
```

### Accessing Files from Android Studio
* To access Java file with the code for the drag and drop keyboard, Select the following folders in this order: 

For example:
```
Clovis_prototype_01 --> app --> src --> main --> java/com/example/mdhwang/clovis_prototyp --> DraggingRed.java 
```

* To access the XML file with the code that defines the user interface of the keyboard, Select the following folders in this order:

For example:
```
Clovis_prototype_01 --> app --> src --> main --> res --> layout --> activity_dragging_red.xml
```

## About the Keyboards
We created 5 different versions of the dynamic keyboard for our client. As such, there are 5 copies of XML files and Java files for each respective version. To learn how to access each individual file, see the next section 'Accessing Files from Android Studio'. 

On the homepage, you will find 5 buttons with the following names. Clicking on each buttons will lead to a different version of the keyboard we have created. 

1. DRAG AND DROP (RED): Drag and Drop Keyboard with Red letters because red is colour our client, Clovis, requests the most when he paints. 

2. DRAG AND DROP (BLACK): Drag and Drop Keyboard with Black letters has the same functions as the one with red letters

3. ONE SCROLLBAR: Typing Interface with a single scroll bar on the right

4. TWO SCROLLBAR + GRID + ANIMATION: Typing Interface with two scroll bars, a grid as the background canvas and animated letters. 

5. TWO SCROLLBAR: Typing Interface with only two scrollbars. 

## Using the Keyboards
### For Drag and Drop (Black) and Drag and Drop (Red): 
* From the homepage, select "Drag and Drop (Black)" or "Drag and Drop (Red)"
* To select different letters, tap on the left or right button icons on the top left and top right corners of the screen respectively
* To begin typing, tap on the letters with your finger and drag it into the white space in the center. You can drag the letters around the white space thereafter. 
* To delete a selected letter, drag it to the image of Oscar the Grouch. 
* To clear all the letters, click on the 'Clear' button on the bottom right corner of the screen. 

### For Scroll Bars:
* From the homepage, select "One Scroll Bar" or "Two Scroll Bar Only" or "Two Scroll Bar + Grid + Animation"
* To select different letters, scroll up and down and tap on the letter first. 
* The selected letter will appear on the top left hand side of the screen. You will be able to drag the letters around the canvas thereafter.  
* To delete a selected letter, drag the letter one by one to the image of Oscar the Grouch. 

## Authors
* Mitchell Hwang 
* Wyin Kok
* Amy Liu 
* Arden Marin

## Acknowledgments
We would like to express our most sincere gratitude to Clovis, Nathalie, Joachim, Jason, MikeJ, and Elise for working with us to develop the dynamic keyboard this semester. Thank you Professor Julie GreenBerg, Tina Quach, and the PPAT team for advising and supporting us throughout this project.
