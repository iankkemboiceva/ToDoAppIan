# My Notes App
Below are my comments on my approach to this interview challenge and tools used.The main approach I used was Android Architecture Components with Kotlin as the development language

# MVVM
The app architecture design pattern I elected to go with was MVVM to enjoy the benefits associated with it.These include:
a) Allows for even easier testability of code in comparison with MVC and MVP
b) The ViewModel allows for more decoupling of business logic away from the View making the View as dumb as possible
c) Google highly recommends it as the proposed architectural pattern for Android hence likely to receive more support from them in the future 
d) This architecture is also very lifecycle aware leading to predictable behavior on activity/app lifecycle changes etc etc

#Room
Implemented Room for data persistence of the saved notes
# LiveData
I implemented LiveData to observe underlying changes to the Room database and update UI elements accordingly
# Koin
Used Koin to implement Dependency Injection severally throughout the app.This allows easier separation of concerns and hence easier testability
# Data Binding
Implemented Data Binding to bind all UI components on the app to the data sources in View Model

# RxJava 2
Implemented Reactive Programming using RxJava 2 to implement and observe reactive changes to underlying database source

# Unit Tests
Ran unit tests to ensure the critical CRUD operations happen correctly on the Room database






