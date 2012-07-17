package hasher;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Scopes;
import com.google.inject.name.Named;
import javax.inject.Singleton;
import stringer.StringTransformer;

public class HasherModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(StringTransformer.class).to(HasherStringTransformer.class).
                in(Scopes.NO_SCOPE);
    }
    
    @Provides
    @Named("ToLowerCaseHasher")
    @Singleton
    protected StringTransformer toLowerCase(final StringTransformer st) {
        return new StringTransformer() {

            @Override
            public String description() {
                return "LowerCase: " + st.description();
            }

            @Override
            public String transform(String s) {
                return st.transform(s).toLowerCase();
            }
        };
    }
}
