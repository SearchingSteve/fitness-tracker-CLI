package edu.keyin.stephencrocker;

public class Main {
    public static void main(String[] args) {
        FitnessTracker tracker = new FitnessTracker();

        // Example usage
        Workout running = new Workout("Running", 29, 100);  // 29 minutes
        tracker.addWorkout(running);  // Add the workout

        // Add the goal after the workout
        Goal dailyGoal = new Goal("Daily Exercise", 30, "minutes");
        tracker.addGoal(dailyGoal);
        tracker.updateGoals(); // Update the goals now that the goal has been added

        // Output results
        System.out.println("Total workout minutes: " + tracker.getTotalWorkoutMinutes());
        System.out.println("Total calories burned: " + tracker.getTotalCaloriesBurned());
        System.out.println("Daily goal: " + dailyGoal.getTargetVal());

        // Print if goal is achieved or not after all updates
        if (dailyGoal.isAchieved()) {
            System.out.println("Goal achieved: " + dailyGoal.getDescription());
        } else {
            System.out.println("Goal not achieved: " + dailyGoal.getDescription() +".");
        }
    }
}
