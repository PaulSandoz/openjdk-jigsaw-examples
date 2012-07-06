package rotter;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.google.inject.multibindings.Multibinder;
import stringer.StringTransformer;

public class RotterModule extends AbstractModule {

    @Override
    protected void configure() {
        Multibinder<StringTransformer> uriBinder = Multibinder.
                newSetBinder(binder(), StringTransformer.class);
        uriBinder.addBinding().to(RotterStringTransformer.class).
                in(Scopes.SINGLETON);
    }
}
