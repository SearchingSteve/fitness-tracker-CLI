# Fitness Tracker Application

## Overview

The Fitness Tracker Application is a simple Java-based console application designed to help users manage their workouts and fitness goals. Users can add workouts, set fitness goals, check the status of their goals, and view summaries of their workouts and goals. The application provides a user-friendly menu-driven interface for easy interaction.

## Features

- **Add Workouts**: Users can add new workouts by specifying the workout name, duration in minutes, and calories burned.
- **Add Goals**: Users can set fitness goals by providing a description, a metric (e.g., minutes or calories), and a target value.
- **Check Goal Status**: Users can check the status of their goals to see if they have been achieved.
- **Display Workouts**: Users can view a list of all workouts they have added.
- **Display Goals**: Users can view a list of all goals they have set.
- **Total Calories Burned**: Users can see the total number of calories burned across all workouts.
- **Total Workout Minutes**: Users can see the total number of minutes spent on all workouts.
- **Exit**: Users can exit the application.

## How to Use

1. **Compile and Run**: Compile the Java files and run the `FitnessTrackerApp` class.
2. **Main Menu**: Upon running the application, the main menu will be displayed with options numbered 1 through 8.
3. **Adding a Workout**:
   - Select option 1 from the menu.
   - Enter the workout name, duration in minutes, and calories burned when prompted.
4. **Adding a Goal**:
   - Select option 2 from the menu.
   - Enter the goal description, metric (either "minutes" or "calories"), and target value when prompted.
5. **Checking Goal Status**:
   - Select option 3 from the menu.
   - Enter the description of the goal you want to check.
6. **Displaying Workouts**:
   - Select option 4 from the menu to view all added workouts.
7. **Displaying Goals**:
   - Select option 5 from the menu to view all set goals.
8. **Viewing Total Calories Burned**:
   - Select option 6 from the menu to see the total calories burned.
9. **Viewing Total Workout Minutes**:
   - Select option 7 from the menu to see the total minutes spent on workouts.
10. **Exiting the Application**:
    - Select option 8 from the menu to exit the application.

## Code Structure

- **`FitnessTrackerApp.java`**: The main class that contains the user interface and menu logic.
- **`FitnessTracker.java`**: A class that manages the collection of workouts and goals.
- **`Workout.java`**: A class representing a workout with properties like name, duration, and calories burned.
- **`Goal.java`**: A class representing a fitness goal with properties like description, metric, and target value.

## Testing

The project includes unit tests to ensure functionality. Run tests with Maven:

    mvn test

## Continuous Integration (GitHub Actions)

The project uses GitHub Actions to automatically run tests on every push. The workflow is defined in `.github/workflows/maven.yml`.

## Example Usage

    Fitness Tracker Menu:
    1. Add Workout
    2. Add Goal
    3. Check Goal Status
    4. Display Workouts
    5. Display Goals
    6. Get Total Calories Burned
    7. Get Total Workout Minutes
    8. Exit
    Please choose an option (1-8): 1

    Enter workout name: Running
    Enter workout duration in minutes: 30
    Enter calories burned: 300

    Workout added: Running, Duration: 30 minutes, Calories: 300

## Requirements

- Java Development Kit (JDK) 8 or higher.
- Maven (for testing).

## Installation

1. Clone the repository or download the source code.
2. Compile and run the `FitnessTrackerApp` class.

## License

This project is provided for personal use only. Redistribution, modification, or commercial use in any form is strictly prohibited without prior written permission from the author.
For detailed license terms, refer to the [LICENSE](./LICENSE.md) file.

## Author
[SearchingSteve](https://github.com/SearchingSteve)
