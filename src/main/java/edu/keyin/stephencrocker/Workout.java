package edu.keyin.stephencrocker;

import java.time.LocalDateTime;
public class Workout {
    private String name;
    private int duration;
    private int caloriesBurned;
    private LocalDateTime timestamp;

    public Workout(String name, int duration, int caloriesBurned) {
        this.name = name;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
        this.timestamp = LocalDateTime.now();
    }

    public String getName() {
        return name;
    }
    public int getDuration() {
        return duration;
    }
    public int getCaloriesBurned() {
        return caloriesBurned;
    }
    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
