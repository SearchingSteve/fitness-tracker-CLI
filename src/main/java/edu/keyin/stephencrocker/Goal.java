package edu.keyin.stephencrocker;

public class Goal {
    private String description;
    private int targetVal;  // Changed from targetValue to match your code
    private String metric;
    private boolean achieved;

    public Goal(String description, int targetVal, String metric) {
        this.description = description;
        this.targetVal = targetVal;
        this.metric = metric;
        this.achieved = false;
    }

    public void markAsAchieved() {
        this.achieved = true;
    }

    // Getters
    public String getDescription() { return description; }
    public int getTargetVal() { return targetVal; }  // Changed from getTargetValue to match your code
    public String getMetric() { return metric; }
    public boolean isAchieved() { return achieved; }
}