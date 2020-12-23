 # Basic Overview 
This app will download a list of albums .
https://static.leboncoin.fr/img/shared/technical-test.json.

# Libraries and technical decisions

# Architecture :
MVVM : 
First, let’s talk about what the MVVM pattern is. The MVVM pattern is a pattern derived from the MVP pattern defined by Martin Fowler in the 1990s. The MVVM (Model-View-ViewModel) pattern helps to completely separate the business and presentation logic from the UI, and the business logic and UI can be clearly separated for easier testing and easier maintenance. Let’s take a look at View, ViewModel and Model.

# Language 
Kotlin 
Kotlin has fixed many issues present in the the Java language. For example, the null references in Kotlin are controlled by the type system. Kotlin has proper function types and it has no raw types. Kotlin is less verbose in comparison to Java .


# Librairies
Room Persistence Library
Room is an Android persistence library that is part of Google’s Android Jetpack project. According to the documentation, Room provides an abstraction layer over SQLite to allow fluent database access while harnessing the full power of SQLite.

# Dargger
Dagger 2 is dependency injection framework. It is based on the Java Specification Request (JSR) 330. It uses code generation and is based on annotations. The generated code is very relatively easy to read and debug.

# Live Data
Some advantages of using LiveData:
Ensures your UI matches your data state
No memory leaks
No crashes due to stopped activities
Sharing resources
RxJava
Provides easier way to handle asynchronous operations and manages the concurrency. If you have multiples asynchronous operation in background RxJava can manage this.

# Retrofit
Easy to connect to web-services by translating the API into Java or Kotlin.
Easy to add Headers and request types.
Easily Customisable, you can customise it and add say any convertors like Gson, JackSon, Moshi, Prtobuf, XML etc.
It provides additional functionalities such as custom headers, file uploads, downloads, mocking responses (for testing).

# Glide
The glide library in terms of optimization is superior to picasso and still supports animated gifs.Also, because of Glide integrates with the activity life-cycle, animated GIFs are also paused in onStop() to avoid draining the battery in the background. I used the library in my app without handle with large images and loading.
# Navigation

The Navigation component consists of three key parts that are described below:

Navigation graph: An XML resource that contains all navigation-related information in one centralized location. This includes all of the individual content areas within your app, called destinations, as well as the possible paths that a user can take through your app.
NavHost: An empty container that displays destinations from your navigation graph. The Navigation component contains a default NavHost implementation, NavHostFragment, that displays fragment destinations.
NavController: An object that manages app navigation within a NavHost. The NavController orchestrates the swapping of destination content in the NavHost as users move throughout your app.
As you navigate through your app, you tell the NavController that you want to navigate either along a specific path in your navigation graph or directly to a specific destination. The NavController then shows the appropriate destination in the NavHost.

The Navigation component provides a number of other benefits, including the following:

Handling fragment transactions.
Handling Up and Back actions correctly by default.
Providing standardized resources for animations and transitions.
Implementing and handling deep linking.
Including Navigation UI patterns, such as navigation drawers and bottom navigation, with minimal additional work.
Safe Args - a Gradle plugin that provides type safety when navigating and passing data between destinations.
ViewModel support - you can scope a ViewModel to a navigation graph to share UI-related data between the graph's destinations.
In addition, you can use Android Studio's Navigation Editor to view and edit your navigation graphs









