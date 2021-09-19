# GithubSearch
Application which allows a user to search through a Github Repositories

<img src="/assets/screen_demo.gif" width="25%" height="25%"/>

## Project Details
This project was setup with (Kotlin Multiplatform Mobile)[https://kotlinlang.org/docs/multiplatform.html] in mind.

A (Common module)[https://github.com/archiegq21/GithubSearch/tree/master/common] houses the shared logic for all possible platform targets.

The project currently have a working Andoid Application while the iOS Application is still in development.

The Android Application uses fully (Jetpack Compose)[https://developer.android.com/jetpack/compose] for UI while the iOS uses (SwiftUI)[https://developer.apple.com/tutorials/swiftui](Still in Inprogress...).

## TODO
List of Libraries used for the Project:
1) (Ktor)[https://github.com/ktorio/ktor] for Networking
2) (Kotlin Serializationx)[https://github.com/Kotlin/kotlinx.serialization] for Serialization
3) (Koin)[https://github.com/InsertKoinIO/koin] for Dependency Injection

All the libraries above were choosen over their counterpart solely because of their Kotlin Multiplatform Support.

Pending items to work on for Android Application:
 1) Add Unit Test, UI and Integration Test
 2) Review existing compose components
 3) Create custom theme (currently uses default theme)
 4) Add BuildTypes and Variants

Pending items to work on Common Module:
 1) Register the application for Github API to increase request limit
 2) Moveout the Paging Logic out to a Usecase Layer
 3) Indicate a better Error typing
 
Pending items to work on iOS:
 * Since the iOS still totally incomplete, this would be defined later on.
