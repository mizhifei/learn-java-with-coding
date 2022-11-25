package ch6.thread.local;

public class InputHandler {
    public String getInput() {
        return getString();
    }

    private String getString() {
        PerformanceTracker.startPhase();
        StringBuilder ret = new StringBuilder();
        for (int i = 0; i < 128; i++) {
            int rand = ((int) (Math.random() * 100)) % 26;
            char ch = (char) (rand + 'a');
            ret.append(ch);
        }
        PerformanceTracker.endPhase("InputGen");
        return ret.toString();
    }
}
