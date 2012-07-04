module rotter@1.0 {
    requires guice.multibindings@3.0;
    requires guice.service;
    requires stringer;
        
    provides service guice.service.GuiceInjectorService with rotter.RotterInjectorProvider;
}
