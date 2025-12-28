class StopWatch1 {

    // Private fields
    private boolean running;
    private int ticks;

    // Constructor
    public StopWatch1() {
        running = false;
        ticks = 0;
    }

    // Start the stopwatch
    public void start() {
        running = true;
    }

    // Stop the stopwatch
    public void stop() {
        running = false;
    }

    // Reset ticks to zero
    public void reset() {
        ticks = 0;
    }

    // Return elapsed ticks
    public int elapsed() {
        return ticks;
    }

    // Optional helper method
    public boolean isRunning() {
        return running;
    }

    // Increment tick only when running
    public void incrementTick() {
        if (running) {
            ticks++;
        }
    }
}
