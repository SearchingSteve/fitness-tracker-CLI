package edu.keyin.stephencrocker;

import java.util.ArrayList;
import java.util.List;

/**
 * The FitnessTracker class is responsible for managing a collection of workouts and fitness goals.
 * It provides methods to add workouts and goals, display them, update goal status, and retrieve
 * aggregate statistics such as total calories burned or total workout minutes.
 */
public class FitnessTracker {

    /**
     * A list of workouts tracked by the fitness tracker.
     */
    public List<Workout> workouts;

    /**
     * A list of goals set by the user for the fitness tracker.
     */
    public List<Goal> goals;

    /**
     * Initializes a new instance of the FitnessTracker class with empty lists of workouts and goals.
     */
    public FitnessTracker() {
        this.workouts = new ArrayList<>();
        this.goals = new ArrayList<>();
        System.out.println("\nFitnessTracker initialized.\n");
    }

    /**
     * Adds a new workout to the fitness tracker.
     *
     * @param workout The workout to be added.
     */
    public void addWorkout(Workout workout) {
        workouts.add(workout);
    }

    /**
     * Adds a new goal to the fitness tracker.
     *
     * @param goal The goal to be added.
     */
    public void addGoal(Goal goal) {
        goals.add(goal);
    }

    /**
     * Retrieves a copy of the list of workouts.
     *
     * @return A new list containing all workouts.
     */
    public List<Workout> getWorkouts() {
        return new ArrayList<>(workouts);
    }

    /**
     * Displays all workouts tracked by the fitness tracker. If no workouts are available,
     * a message is displayed indicating this.
     */
    public void displayWorkouts() {
        if (workouts.isEmpty()) {
            System.out.println("No workouts to display.");
        } else {
            for (Workout workout : workouts) {
                System.out.println("Workout: " + workout.getName() +
                        ", Duration: " + workout.getDuration() + " minutes" +
                        ", Calories: " + workout.getCaloriesBurned() +
                        ", Timestamp: " + workout.getTimestamp());
            }
        }
    }

    /**
     * Retrieves a copy of the list of goals.
     *
     * @return A new list containing all goals.
     */
    public List<Goal> getGoals() {
        return new ArrayList<>(goals);
    }

    /**
     * Displays all goals tracked by the fitness tracker. If no goals are available,
     * a message is displayed indicating this.
     */
    public void displayGoals() {
        if (goals.isEmpty()) {
            System.out.println("No goals to display.");
        } else {
            for (Goal goal : goals) {
                System.out.println("Goal: " + goal.getDescription() +
                        ", Target Goal: " + goal.getTargetVal() + " " + goal.getMetric() +
                        ", Goal Achieved: " + goal.isAchieved());
            }
        }
    }

    /**
     * Updates the status of all goals based on the tracked workouts. If the total
     * workout data (e.g., duration or calories burned) meets or exceeds the goal's
     * target, the goal is marked as achieved.
     */
    public void updateGoals() {
        for (Goal goal : goals) {
            if (!goal.isAchieved()) {
                int total = 0;

                switch (goal.getMetric().toLowerCase()) {
                    case "minutes":
                        total = workouts.stream()
                                .mapToInt(Workout::getDuration)
                                .sum();
                        break;
                    case "calories":
                        total = workouts.stream()
                                .mapToInt(Workout::getCaloriesBurned)
                                .sum();
                        break;
                    default:
                        System.out.println("Unknown metric: " + goal.getMetric());
                }

                if (total >= goal.getTargetVal()) {
                    goal.markAsAchieved();
                }
            }
        }
    }

    /**
     * Calculates the total calories burned from all tracked workouts.
     *
     * @return The total number of calories burned.
     */
    public int getTotalCaloriesBurned() {
        return workouts.stream()
                .mapToInt(Workout::getCaloriesBurned)
                .sum();
    }

    /**
     * Calculates the total duration of all tracked workouts in minutes.
     *
     * @return The total number of workout minutes.
     */
    public int getTotalWorkoutMinutes() {
        return workouts.stream()
                .mapToInt(Workout::getDuration)
                .sum();
    }
}
