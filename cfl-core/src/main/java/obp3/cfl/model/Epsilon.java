package obp3.cfl.model;

public class Epsilon extends Terminal {
    @Override
    public <I, O> O accept (FunctionalVisitor<I, O> visitor, I input) {
        return visitor.visit(this, input);
    }
}
