package obp3.cfl.model;

import obp3.cfl.ToString;

public abstract class Language {
    public <I, O> O accept (FunctionalVisitor<I, O> visitor, I input) {
        return visitor.visit(this, input);
    }

    @Override
    public String toString() {
        return ToString.INSTANCE.apply(this);
    }
}

