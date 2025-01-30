package edu.keyin.stephencrocker;

import java.time.LocalDateTime;
public class Workout {
    private String type;
    private int duration;
    private int caloriesBurned;
    private LocalDateTime timestamp;

    public Workout(String type, int duration, int caloriesBurned) {
        this.type = type;
        this.duration = duration;
        this.caloriesBurned = caloriesBurned;
        this.timestamp = LocalDateTime.now();
    }

    public String getType() {
        return type;
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
