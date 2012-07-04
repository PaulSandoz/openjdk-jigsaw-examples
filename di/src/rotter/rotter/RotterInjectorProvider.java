package rotter;

import com.google.inject.Guice;
import com.google.inject.Injector;
import guice.service.GuiceInjectorService;

public class RotterInjectorProvider implements GuiceInjectorService {

    @Override
    public Injector getInjector() {
        return Guice.createInjector(new RotterModule());
    }
}