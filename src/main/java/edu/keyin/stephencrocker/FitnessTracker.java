package edu.keyin.stephencrocker;

import java.util.ArrayList;
import java.util.List;

public class FitnessTracker {
    public List<Workout> workouts;
    public List<Goal> goals;

    public FitnessTracker() {
        this.workouts = new ArrayList<>();
        this.goals = new ArrayList<>();
        System.out.println("\nFitnessTracker initialized.\n");
    }

    public void addWorkout(Workout workout) {
        workouts.add(workout);
    }

    public void addGoal(Goal goal) {
        goals.add(goal);
    }

    public List<Workout> getWorkouts() {
        return new ArrayList<>(workouts);
    }

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


    public List<Goal> getGoals() {
        return new ArrayList<>(goals);
    }

    public void displayGoals() {
        if (goals.isEmpty()) {
            System.out.println("No goals to display.");
        }
        else{
            for (Goal goal : goals) {
                System.out.println("Goal: " + goal.getDescription() +
                        ", Target Goal: " + goal.getTargetVal() + " " +goal.getMetric() +
                        ", Goal Achieved: " + goal.isAchieved());
            }
        }
    }

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

    public int getTotalCaloriesBurned() {
        return workouts.stream()
                .mapToInt(Workout::getCaloriesBurned)
                .sum();
    }

    public int getTotalWorkoutMinutes() {
        return workouts.stream()
                .mapToInt(Workout::getDuration)
                .sum();
    }
}
