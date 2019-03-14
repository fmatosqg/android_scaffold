# Setup
Configure the flavor to mockDebug for development
Configure the flavor to prodDebug for using internet with real data

# Architecture
## Flavors
- There is a flavor dimension "api", with the possible values being mock, server. This is helpful for configuring different servers according to the environment such as staging, production etc. 
- The mock flavor is especially useful since it feeds the UI with static preconfigured data, which allows the developer to exercise the UI with all the edge cases. If espresso is also supported it's the recommended flavor, because of its predictability.

The specific way it's configured allows for installing both Mock and Prod flavors side by side, very useful for communicating when prod bugs inevitably arise.

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

