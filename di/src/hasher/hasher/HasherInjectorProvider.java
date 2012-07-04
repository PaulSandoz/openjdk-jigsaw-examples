package hasher;

import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.service.GuiceInjectorService;

public class HasherInjectorProvider implements GuiceInjectorService {

    @Override
    public Injector getInjector() {
        return Guice.createInjector(new HasherModule());
    }
}