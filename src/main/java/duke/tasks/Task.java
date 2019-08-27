package duke.tasks;

/**
 * Task.
 */
public class Task {
    boolean done;
    String task;

    /**
     * Initialises Task.
     *
     * @param task
     */
    public Task(String task) {
        this.task = task;
        this.done = false;
    }

    /**
     * Initialises Task with specified status.
     *
     * @param task
     */
    public Task(String task, Boolean done) {
        this.task = task;
        this.done = done;
    }

    /**
     * Set status.
     * @param status
     */
    public void setDone(boolean status) {
        this.done = status;
    }

    @Override
    public String toString() {
        String iconForDone = done ? "\u2713" : "\u2718";
        return String.format("[%s] %s", iconForDone, this.task);
    }
}