package obp3.cfl.model;

public abstract class Composite extends Language {
    @Override
    public <I, O> O accept (FunctionalVisitor<I, O> visitor, I input) {
        return visitor.visit(this, input);
    }
}
