package ch6.thread.local;

import java.util.ArrayList;
import java.util.List;

public class PerformanceTracker {

    private static final ThreadLocal<List<Phase>> PHASES = new ThreadLocal<>();
    private static final ThreadLocal<Long> PHASE_START_TIME = new ThreadLocal<>();
    public static void reset() {
        PHASES.set(new ArrayList<>());
        PHASE_START_TIME.set(-1L);
    }

    public static void finish() {
        List<Phase> phases = PHASES.get();
        PHASES.set(null);
        PHASE_START_TIME.set(null);

        StringBuilder out = new StringBuilder("------Thread Execution Phase Durations---------\n");
        phases.forEach(out::append);
        out.append("--------------------------------------\n");
        System.out.println(out);
    }

    public static void startPhase() {
        PHASE_START_TIME.set(System.currentTimeMillis());
    }

    public static void endPhase(String phase) {
        Long start = PHASE_START_TIME.get();
        PHASES.get().add(new Phase(phase, System.currentTimeMillis() - start));
    }

    private static class Phase {
        private String phase;

        private long time;

        public Phase(String phase, long time) {
            this.phase = phase;
            this.time = time;
        }

        @Override
        public String toString() {
            return "Phase{" +
                    "phase='" + phase + '\'' +
                    ", time=" + time +
                    "}\n";
        }
    }
}
