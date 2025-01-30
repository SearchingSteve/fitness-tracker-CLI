package edu.keyin.stephencrocker;

public class Goal {
    private String description;
    private String metric;
    private int targetVal;
    private boolean achieved;

    public Goal(String description, String metric, int targetVal) {
        this.description = description;
        this.metric = metric;
        this.targetVal = targetVal;
        this.achieved = false;
    }

    public void markAsAchieved() {
        this.achieved = true;
    }

    // Getters
    public String getDescription() { return description; }
    public String getMetric() { return metric; }
    public int getTargetVal() { return targetVal; }
    public boolean isAchieved() { return achieved; }
}