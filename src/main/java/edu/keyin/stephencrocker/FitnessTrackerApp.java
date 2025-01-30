package edu.keyin.stephencrocker;

import java.util.Scanner;

public class FitnessTrackerApp {
    public static void main(String[] args) {
        FitnessTracker tracker = new FitnessTracker();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            // Display menu
            System.out.println("\nFitness Tracker Menu:");
            System.out.println("1. Add Workout");
            System.out.println("2. Add Goal");
            System.out.println("3. Check Goal Status");
            System.out.println("4. Display Workouts");
            System.out.println("5. Display Goals");
            System.out.println("6. Exit");
            System.out.print("Please choose an option (1-6): ");

            if (!scanner.hasNextInt()) {
                System.out.println("\nInvalid input. Please enter a number between 1 and 6.");
                scanner.next(); // Consume invalid input
                continue;
            }

            int choice = scanner.nextInt(); // Get user input

            switch (choice) {
                case 1:
                    // Add Workout
                    System.out.print("\nEnter workout name: ");
                    String name = scanner.next();
                    System.out.print("Enter workout duration in minutes: ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Invalid input. Please enter a valid number for duration: ");
                        scanner.next(); // Consume invalid input
                    }
                    int duration = scanner.nextInt();
                    System.out.print("Enter calories burned: ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Invalid input. Please enter a valid number for calories: ");
                        scanner.next(); // Consume invalid input
                    }
                    int caloriesBurned = scanner.nextInt();

                    Workout workout = new Workout(name, duration, caloriesBurned);
                    tracker.addWorkout(workout);
                    System.out.println("\nWorkout added: " + name + ", Duration: " + duration + " minutes, Calories: " + caloriesBurned);
                    break;

                case 2:
                    // Add Goal
                    System.out.print("\nEnter goal description: ");
                    scanner.nextLine(); // Consume leftover newline
                    String description = scanner.nextLine();

                    String metric;
                    while (true) {
                        System.out.print("Enter goal metric (e.g., 'minutes' or 'calories'): ");
                        metric = scanner.next().toLowerCase();
                        if (metric.equals("minutes") || metric.equals("calories")) {
                            break;
                        }
                        System.out.println("Invalid input. Metric must be either 'minutes' or 'calories'.");
                    }

                    System.out.print("Enter target value: ");
                    while (!scanner.hasNextInt()) {
                        System.out.print("Invalid input. Please enter a valid number for target value: ");
                        scanner.next(); // Consume invalid input
                    }
                    int targetVal = scanner.nextInt();

                    Goal goal = new Goal(description, metric, targetVal);
                    tracker.addGoal(goal);
                    System.out.println("\nGoal added: " + description + ", Target: " + targetVal + " " + metric);
                    tracker.updateGoals(); // Update the goal status after adding it
                    break;

                case 3:
                    // Check Goal Status
                    if (tracker.getGoals().isEmpty()) {
                        System.out.println("\nNo goals have been added yet.");
                    } else {
                        System.out.println("\nEnter the goal description to check status: ");
                        scanner.nextLine();  // Consume the newline left over
                        String goalDescription = scanner.nextLine();

                        Goal foundGoal = null;
                        for (Goal g : tracker.getGoals()) {
                            if (g.getDescription().equalsIgnoreCase(goalDescription)) {
                                foundGoal = g;
                                break;
                            }
                        }

                        if (foundGoal != null) {
                            System.out.println("\nGoal: " + foundGoal.getDescription() + ", Target: " + foundGoal.getTargetVal() + " " + foundGoal.getMetric());
                            if (foundGoal.isAchieved()) {
                                System.out.println("Goal achieved!");
                            } else {
                                System.out.println("Goal not achieved.");
                            }
                        } else {
                            System.out.println("Goal not found.");
                        }
                    }
                    break;

                // Display Workouts
                case 4:
                    tracker.displayWorkouts();
                    break;
                case 5:
                    tracker.displayGoals();
                    break;
                case 6:
                    running = false;
                    System.out.println("\nExiting the program. Goodbye!");
                    break;

                default:
                    System.out.println("\nInvalid option. Please choose between 1 and 6.");
            }
        }

        scanner.close();
    }
}
