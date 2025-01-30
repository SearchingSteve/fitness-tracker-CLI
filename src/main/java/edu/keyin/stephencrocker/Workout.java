package edu.keyin.stephencrocker;

import java.time.LocalDateTime;

/**
 * The Workout class represents a workout session, including details such as the workout name,
 * duration, calories burned, and the timestamp of when the workout was created.
 */
public class Workout {
    /**
     * The name of the workout.
     */
    private String name;

    /**
     * The duration of the workout in minutes.
     */
    private int duration;

    /**
     * The number of calories burned during the workout.
     */
    private int caloriesBurned;

    /**
     * The timestamp indicating when the workout was created.
     */
    private LocalDateTime timestamp;

    /**
     * Constructs a new Workout instance with the specified name, duration, and calories burned.
     * The timestamp is automatically set to the current time when the workout is created.
     *
     * @param name           The name of the workout.
     * @param duration       The duration of the workout in minutes.
     * @param caloriesBurned The number of calories burned during the workout.
     */
    public Workout(String name, int duration, int caloriesBurned) {
        this.name = name;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
        this.timestamp = LocalDateTime.now();
    }

    /**
     * Gets the name of the workout.
     *
     * @return The name of the workout.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the duration of the workout in minutes.
     *
     * @return The duration of the workout in minutes.
     */
    public int getDuration() {
        return duration;
    }

    /**
     * Gets the number of calories burned during the workout.
     *
     * @return The number of calories burned during the workout.
     */
    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    /**
     * Gets the timestamp of when the workout was created.
     *
     * @return The timestamp of the workout as a {@link LocalDateTime} object.
     */
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
