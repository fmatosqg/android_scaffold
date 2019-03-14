# Setup
Configure the flavor to mockDebug for development
Configure the flavor to cloudDebug for using internet with real data

# Running UI tests with Espresso
Running UI tests with only the mock flavor will ensure consistent results even. Plus, you don't need the server to be online ;)

`./gradlew connectedMockDebugAndroidTest`

# Architecture
## Flavors
- There is a flavor dimension "api", with the possible values being mock, cloud. 
- The mock flavor is especially useful since it feeds the UI with static preconfigured data, which allows the developer to exercise the UI with all the edge cases. If espresso is also supported it's the recommended flavor, because of its predictability.
- The cloud flavor means that data will be obtained using Retrofit from somewhere in the cloud.


## Java packages convention
- This app is packaged by feature. What it means is that if it has a feature called login and another called list the following tree is expected:

ui
 | 
 \ login
 \ list
domain
 |
 \ login
 \ list 
utils 

Which is an advantage once the app has over 20 activities and presenters.

