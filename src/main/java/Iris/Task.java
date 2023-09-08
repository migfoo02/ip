package iris;

/**
 * An abstract class representing a task in the Iris application.
 */
public abstract class Task {
    private String name;
    private boolean isDone;

    /**
     * Constructor for the Task class.
     *
     * @param name The name of the task.
     */
    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    /**
     * Marks the task as done.
     */
    public void markDone() {
        this.isDone = true;
    }

    /**
     * Marks the task as undone.
     */
    public void markUndone() {
        this.isDone = false;
    }

    /**
     * Checks if the task is done.
     *
     * @return true if the task is done, false otherwise.
     */
    public boolean isDone() {
        return this.isDone;
    }

    /**
     * Gets the name of the task.
     *
     * @return The name of the task.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Abstract method to write the task to a file.
     *
     * @return A string representation of the task for file output.
     */
    public abstract String writeTaskToFile();

    /**
     * Static method to create a Task object from a string representation read from a file.
     *
     * @param input The string representation of the task read from the file.
     * @return A Task object created from the input string.
     */
    public static Task readTaskFromFile(String input) {
        String[] args = input.split(" \\| ");
        Task task;
        switch (args[0]) {
            case "T":
                task = Todo.readTaskFromFile(args);
                break;
            case "D":
                task = Deadline.readTaskFromFile(args);
                break;
            case "E":
                task = Event.readTaskFromFile(args);
                break;
            default:
                task = null;
                break;
        }
        return task;
    }

    /**
     * Overrides the default toString method to provide a custom string representation of the task.
     *
     * @return A formatted string representing the task.
     */
    @Override
    public String toString() {
        String status = this.isDone ? "X" : " ";
        return "[" + status + "] " + this.name;
    }
}