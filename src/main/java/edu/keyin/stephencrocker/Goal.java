package edu.keyin.stephencrocker;

/**
 * The Goal class represents a fitness goal with a description, metric, target value, and status indicating whether the goal is achieved.
 */
public class Goal {
    /**
     * The description of the goal.
     */
    private String description;

    /**
     * The metric used to measure progress toward the goal (e.g., "minutes" or "calories").
     */
    private String metric;

    /**
     * The target value to achieve for the goal.
     */
    private int targetVal;

    /**
     * Indicates whether the goal has been achieved.
     */
    private boolean achieved;

    /**
     * Constructs a new Goal with the specified description, metric, and target value.
     * The goal is initially marked as not achieved.
     *
     * @param description A description of the goal.
     * @param metric      The metric used to measure progress (e.g., "minutes" or "calories").
     * @param targetVal   The target value for the goal.
     */
    public Goal(String description, String metric, int targetVal) {
        this.description = description;
        this.metric = metric;
        this.targetVal = targetVal;
        this.achieved = false;
    }

    /**
     * Marks the goal as achieved by setting the {@code achieved} field to true.
     */
    public void markAsAchieved() {
        this.achieved = true;
    }

    /**
     * Gets the description of the goal.
     *
     * @return The description of the goal.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Gets the metric used to measure progress toward the goal.
     *
     * @return The metric of the goal (e.g., "minutes" or "calories").
     */
    public String getMetric() {
        return metric;
    }

    /**
     * Gets the target value of the goal.
     *
     * @return The target value for the goal.
     */
    public int getTargetVal() {
        return targetVal;
    }

    /**
     * Checks whether the goal has been achieved.
     *
     * @return {@code true} if the goal is achieved, {@code false} otherwise.
     */
    public boolean isAchieved() {
        return achieved;
    }
}
