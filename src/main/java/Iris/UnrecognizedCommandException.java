package iris;

public class UnrecognizedCommandException extends IrisException {
    @Override
    public String toString() {
        return "I'm sorry but I don't know what that means.";
    }
}