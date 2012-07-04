package hasher;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import stringer.StringTransformer;

public class HasherModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(StringTransformer.class).to(HasherStringTransformer.class).in(Scopes.SINGLETON);
    }
}
