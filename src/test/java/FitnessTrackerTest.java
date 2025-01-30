
import edu.keyin.stephencrocker.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FitnessTrackerTest {
    private FitnessTracker tracker;

    @BeforeEach
    void setUp() {
        tracker = new FitnessTracker();
    }

    @Test
    void testAddWorkout() {
        Workout workout = new Workout("Running", 30, 300);
        tracker.addWorkout(workout);

        List<Workout> workouts = tracker.getWorkouts();
        assertEquals(1, workouts.size(), "Workout list size should be 1.");
        assertEquals("Running", workouts.get(0).getName(), "Workout name should be 'Running'.");
        assertEquals(30, workouts.get(0).getDuration(), "Workout duration should be 30 minutes.");
        assertEquals(300, workouts.get(0).getCaloriesBurned(), "Calories burned should be 300.");
    }

    @Test
    void testAddGoal() {
        Goal goal = new Goal("Run for 100 minutes", "minutes", 100);
        tracker.addGoal(goal);

        List<Goal> goals = tracker.getGoals();
        assertEquals(1, goals.size(), "Goal list size should be 1.");
        assertEquals("Run for 100 minutes", goals.get(0).getDescription(), "Goal description mismatch.");
        assertFalse(goals.get(0).isAchieved(), "Goal should initially be marked as not achieved.");
    }

    @Test
    void testUpdateGoals_AchieveMinutesGoal() {
        Goal goal = new Goal("Run for 100 minutes", "minutes", 100);
        tracker.addGoal(goal);

        Workout workout1 = new Workout("Running", 60, 500);
        Workout workout2 = new Workout("Cycling", 40, 300);
        tracker.addWorkout(workout1);
        tracker.addWorkout(workout2);

        tracker.updateGoals();

        assertTrue(goal.isAchieved(), "Goal should be marked as achieved.");
    }

    @Test
    void testUpdateGoals_AchieveCaloriesGoal() {
        Goal goal = new Goal("Burn 600 calories", "calories", 600);
        tracker.addGoal(goal);

        Workout workout1 = new Workout("Running", 30, 300);
        Workout workout2 = new Workout("Cycling", 40, 350);
        tracker.addWorkout(workout1);
        tracker.addWorkout(workout2);

        tracker.updateGoals();

        assertTrue(goal.isAchieved(), "Calories goal should be marked as achieved.");
    }

    @Test
    void testUpdateGoals_NotAchieved() {
        Goal goal = new Goal("Run for 100 minutes", "minutes", 100);
        tracker.addGoal(goal);

        Workout workout = new Workout("Running", 50, 300);
        tracker.addWorkout(workout);

        tracker.updateGoals();

        assertFalse(goal.isAchieved(), "Goal should not be marked as achieved.");
    }

    @Test
    void testGetTotalCaloriesBurned() {
        tracker.addWorkout(new Workout("Running", 30, 300));
        tracker.addWorkout(new Workout("Cycling", 40, 400));

        int totalCalories = tracker.getTotalCaloriesBurned();
        assertEquals(700, totalCalories, "Total calories burned should be 700.");
    }

    @Test
    void testGetTotalWorkoutMinutes() {
        tracker.addWorkout(new Workout("Running", 30, 300));
        tracker.addWorkout(new Workout("Cycling", 40, 400));

        int totalMinutes = tracker.getTotalWorkoutMinutes();
        assertEquals(70, totalMinutes, "Total workout minutes should be 70.");
    }

    @Test
    void testWorkoutTimestamp() {
        Workout workout = new Workout("Running", 30, 300);
        tracker.addWorkout(workout);

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime timestamp = workout.getTimestamp();

        assertNotNull(timestamp, "Timestamp should not be null.");
        assertTrue(timestamp.isBefore(now.plusSeconds(1)), "Timestamp should be before or equal to the current time.");
    }
}
