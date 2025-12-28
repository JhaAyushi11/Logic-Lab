public class StopWatchMain {
    public static void main(String[] args) {

        StopWatch1 sw = new StopWatch1();

        sw.start();

        // Simulate time using loop-based ticks
        for (int i = 0; i < 1000; i++) {
            if (sw.isRunning()) {
                sw.incrementTick();
            }
        }

        sw.stop();

        System.out.println(sw.elapsed()); // Expected output: 1000

        sw.reset();
        System.out.println(sw.elapsed()); // Expected output: 0
    }
}
