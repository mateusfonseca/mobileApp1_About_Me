# Android App: About Me

**Dorset College Dublin**  
**BSc in Science in Computing & Multimedia**  
**Mobile Applications 1 - BSC20921**  
**Stage 2, Semester 2**  
**Continuous Assessment 1**  

**Lecturer name:** Saravanabalagi Ramachandran  
**Lecturer email:** saravanabalagi.ramachandran@faculty.dorset-college.ie  

**Student Name:** Mateus Fonseca Campos  
**Student Number:** 24088  
**Student Email:** 24088@student.dorset-college.ie  

**Submission date:** 6 March 2022  

This repository contains an "About Me" Android app developed for my CA1 at Dorset College BSc in Computing, Year 2, Semester 2.

## Part 1: Requirements Checklist

- [x] 1. Main Activity (or Launcher Activity)
- [x] 2. Button Links open new Activity
- [x] 3. Home icon opens Main Activity from back-stack instead of creating newly
- [x] 4. Exit Button finishes the activity and closes the app
- [x] 5. Text is not hardcoded in the layout but is present in "strings" resources xml file
- [x] 6. Image Assets
    - [x] 6.1. Images (Raster) are used
    - [x] 6.2. Vector icons (inbuilt material icons) are used
    - [x] 6.3. SVG icon is used
- [x] 7. Layout and Design:
    - [x] 7.1. All text presented should be clear and legible and should have sufficient contrast (Hint: Dark Gray Text on Dark Blue background is bad)
    - [x] 7.2. All activities should contain ScrollViews to display lengthy content
    - [x] 7.3. In Main Activity,
        - [x] 7.3.1. Basic details are centered horizontally
        - [x] 7.3.2. Photo has at least 5dp margin on all sides
        - [x] 7.3.3. 4 buttons have same length
    - [x] 7.4. Copyright Text
        - [x] 7.4.1. has a small font size
        - [x] 7.4.2. has dark gray color
        - [x] 7.4.3. has a top padding 10dp with a top gray border of 1dp (to separate it out from the main content)
    - [x] 7.5. In all 4 extra activities,
        - [x] 7.5.1. title row is at the top of the app and does not scroll
        - [x] 7.5.2. title row has a dark background (and hence white/light colored text and icon)
        - [x] 7.5.3. button row is at the bottom of the app and does not scroll
        - [x] 7.5.4. button row has 3 buttons (or 2 buttons) are present in one row with at least 5dp space in between them
        - [x] 7.5.5. button row spans full width of the app (i.e. each button's width will be set based on app's width)
        - [x] 7.5.6. icon and title are displayed on top and in one row horizontally centered. Contents inside this row should be vertically aligned in the centre (while the row itself is at the top of the page)
- [x] 8. Coding Practices (Hint: Check online if you don't know what the right/best practice is):
    - [x] 8.1. Variable and File Naming conventions are followed
    - [x] 8.2. Code is properly indented
    - [x] 8.3. Right File Structure is followed (e.g. Layout xml files placed directly under resources directory is bad, place it in "layout" folder instead)
- [x] 9. Hard:
    - [x] 9.1. Use at least one FrameLayout as a separator e.g. to separate two LinearLayouts or TextViews (Hint: Set height 1dp with a light gray background)
    - [x] 9.2. Show both icons and text in buttons (except home icon)
    - [x] 9.3. Make ImageView display your photo with rounded corners (without editing your photo) 

## Part 2: Extra features implemented

In addition to having followed all the guidelines and fulfilled all the requirements stated in the assessment's brief, here is a list of extra features that were implemented during development:

- **1. View biding**
- **2. Classes**
    - **2.1. Content**  
      This class implements the blueprint for the basic Content objects used to feed the recycler views. One of its properties is a list of image IDs, whose length may vary.
    - **2.2. Datasource**  
      This class implements a source for the data content used to feed the recycler views. Its main function loadContent() returns a list of objects of type Content. The contents of this list vary depending on which activity called the method.
    - **2.3. ItemAdapter**  
      This class implements an adapter for a recycler view in the layout. It loads items into a list. It is a recycler view of card views with a second recycler view of images nested in it. The nested recycler view is handled by another adapter, ImageAdapter, called from within this one.
    - **2.4. ImageAdapter**  
      This class implements an adapter for a recycler view in the layout. It loads items into a list. It is a recycler view of images.
- **3. Interfaces**
    - **3.1. ActivitySetter**  
      This interface implements methods that are shared by all activities in the application. The goal here is to avoid code repetition and promote reusability. Its main method, setMeUp(), can be called by any one of the activities. It allows for the activities to request setup of top bar, bottom bar and floating buttons, all of which are laid out by the same layout resources.
- **4. Layouts**
    - **4.1. bar_bottom**  
      Template layout file for the bottom bar shared by the four secondary activities.
    - **4.2. bar_top**  
      Template layout file for the top bar shared by all five activities.
    - **4.3. button_floating**  
      Template layout file for the five floating buttons in Main Activity.
    - **4.4. content_separator**  
      Template layout file the draws a line to separate sections within a page. Present in all activities.
    - **4.5. list_image**  
      Horizontal recycler view that loads images into view as needed. Shared by the five secondary activities.
    - **4.6. list_item**  
      Vertical recycler view that loads card views into view as needed. Shared by the five secondary activities.
    - **4.7. text_copyright**  
      Template layout file for the copyright message at bottom of every page.
- **5. Dark theme color**
- **6. Personalized app launcher icon**

## Part 3: Report

In-class exercises aside, this was the first android app I ever developed. The difficulties began pretty early. Actually, they began even before I could start working on the project itself. As Android Studio turned out to require a considerable amount of RAM to run, I had no other option but to upgrade my computer.

Past the stage of purely physical issues, I finally started coding. To be honest, most requirements on the list were dealt with quite easily, but some of them are certainly worth mentioning:

- **Managing the back stack:** since it was required that all button links were to open a new activity, but the home button should open the same activity every time, and this one should be terminated upon hitting either the exit button or the back button, I had to study how android handles its back stack, its tasks and the activity life-cycle. The work around can be divided into two steps. First I added *android:launchMode="singleTop"* to the android manifest, under the activity tag associated with the main activity. This guarantees that the activity will not be created anew if it is currently on top of the stack. The second step is to pass in the flag *FLAG_ACTIVITY_CLEAR_TOP* with the intent, every time the home button is pressed. This flag tells android to destroy all activities on top of the one being called, in this case, Main. The combination of these two pieces ensures that, every time Main Activity is called, it rests alone on the stack and is never instantiated again.

- **Buttons with both icon and text:** instead of creating clickable linear layouts with an image view and a text view aligned, I used *MaterialButton*, which offers attributes for both text and icon.

- **Circular profile picture:** without editing the photography itself, the image can be placed in a *MaterialCardView*, which offers a corner radius attribute that can be used to set it either slightly rounded or totally circular.

As I mentioned, most of the requirements were simple. But as I worked through the codes, both with the layouts and the actual kotlin files, I realized that the same blocks were repeated many times. I decided to try to make the project more compliant with OOP principles by increasing its re-usability and bringing repetition to a minimum.

I introduced recycler views and adapters to handle repetitive content listing as well as template layouts for components that were created in various occasions. For the second case, especially, I created an interface, *ActivitySetter*, which is implemented by all five activities in the application. The goal of this interface is to offer an automated setup of the shared layout components based on the type of the activity making the call.

The trickiest part here was that, at first, I had enabled view binding so that I could more easily access layout components for a particular view. But, as it turned out, passing bindings as arguments/parameters between function calls, especially if they are not part of the same class, can lead to unexpected results. I could not find a way of using generic binding, that is, a binding object that could be used to manipulate layout components for all activities at once. Also, casting a binding object from one activity to another is not allowed and upcasting it to a super *ViewBinding* object is not enough. In the end, I had to go back to using *findViewById()* within the *ActivitySetter* interface. View biding is still being used locally to each activity though.

Admittedly, the visuals of my app are not its strongest point. During the completion of this assessment, I must say, design was never my main concern. Although I acknowledge its relevance, I am always more likely to focus my efforts on the programming side of things.

**P.S.: Kotlin is beautiful!** :heart:

## Part 4: References

Conceptually, every line of code in this project was written based on official documentation:

- **Android Developers Docs:** https://developer.android.com/docs
- **Kotlin Docs:** https://kotlinlang.org/docs/home.html
- **Material Design:** https://material.io/

Visits to our most beloved **StackOverflow** (https://stackoverflow.com/) certainly happened, for insight and understanding. No code was directly copied from anywhere though.

## Part 5: Copyright Disclaimer

This project may feature content that is copyright protected. Please, keep in mind this is an student's project and has no commercial purpose whatsoever. Having said that, if you are the owner of any content featured here and would like for it to be removed, please, contact me and I will do so promptly.

Thank you very much,  
Mateus Campos.