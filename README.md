# Paper Rock Scissors Exercise

This repository implements the Paper Rock Scissors exercise according to the original instructions copied below.

I initially wrote a quick implementation in `bash`, see [bash-prs.sh](bash-prs.sh), then the proper implementation in Java.

## Building

To unit test and build:

    mvn clean package

To run the game:

    java -jar target/paper-rock-scissors-1.0.0.jar

## Design Notes

See the the JavaDoc in various classes.  This was a fun exercise, even if at this scale I had to force the OO design in here and there. :-)

![design abstraction evolution curve](design-abstraction-curve.jpg)

---

# Original instructions

The following is a small exercise to get an idea of your coding and design skills. We would like you to develop a simple interactive game of [Paper Rock Scissors](https://en.wikipedia.org/wiki/Rock_paper_scissors)

It's intentionally not an algorithmically complex problem, so we're looking more at modelling and structure. We are trying to get a feel for how you code in a professional setting.

## Functional Requirements
* The user is presented with a CLI to play the game. 
* A user can enter one of 3 inputs: paper, rock or scissors.
* The computer will choose one input at random.
* The game rules will be applied and a winner is chosen: 
  - Paper beats Rock
  - Rock beats Scissors
  - Scissors beats Paper. 
  - The same input is a tie. 
* The game will repeat until the user explictly chooses to exit.
* On exit a summary is displayed of games won, lost, and tied.

## Non-Functional Requirements
* Create a branch of this repo and submit your solution as a PR. 
* You can use any language you like, but we'd like to see your object oriented design skills, so best to use a language supporting OO. 
* Write your code to the same standard you would professionally (object structure, design patterns, readability, testing/testability, extensibility)
* Write some unit tests for the key pieces of logic. 
* Don't go overboard, this should only take a few hours.


