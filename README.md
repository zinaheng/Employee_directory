# Employee_directory

## Build tools & versions used
IDE Android Studio Bumblebee | 2021.1.1 Patch 2

## Open-source libraries used

- [Android Async HTTP](https://github.com/codepath/CPAsyncHttpClient) - Simple asynchronous HTTP requests with JSON parsing
- [Glide](https://github.com/bumptech/glide) - Image loading and caching library for Android

## Steps to run the app
Run->Run App

## What areas of the app did you focus on?
focused on parsing the json file correct and display the data to the screen

## What was the reason for your focus? What problems were you trying to solve?
focused on the paring part because it the main part of the project. I was trying to repesent json data into a user friendly interface.
## How long did you spend on this project?
Time spent: **6** hours spent in total

## Did you make any trade-offs for this project? What would you have done differently with more time?
one of the trade offs was not implementing a horizontal view, where I could have used a wider image when the phone is on horizonatal view if I had more time.
## What do you think is the weakest part of your project?
My Unit test was the weakest.
## Did you copy any code or dependencies? Please make sure to attribute them here!
these are the dependencies that I used for the project
    implementation 'com.codepath.libraries:asynchttpclient:2.2.0'
    implementation 'androidx.recyclerview:recyclerview:1.2.1'
    implementation 'com.github.bumptech.glide:glide:4.12.0'
    // Glide v4 uses this new annotation processor -- see https://bumptech.github.io/glide/doc/generatedapi.html
    annotationProcessor 'com.github.bumptech.glide:compiler:4.12.0'
    implementation 'androidx.swiperefreshlayout:swiperefreshlayout:1.1.0'
    testImplementation 'org.json:json:20180813'
    
    I used one of my codepath class project as a reference here is the gitHub link to it, https://github.com/zinaheng/flixster
     
## Is there any other information you’d like us to know?
I used dummy data to show the effect of pull to refresh. The app start with the dummy data then once it's pulled to refresh, it will show the actual json data.

## Video Walkthrough

Here's a walkthrough of the App:

<img src='https://github.com/zinaheng/Employee_directory/blob/master/Walkthrough.gif' title='Video Walkthrough' width='' alt='Video Walkthrough' />

