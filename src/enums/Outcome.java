package enums;

public enum Outcome {
    MISS(0), HIT(1);

    private int value;

    Outcome(int val) {
        this.value = val;
    }
}
