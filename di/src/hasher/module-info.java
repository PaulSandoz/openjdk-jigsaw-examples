module hasher@1.0 {
    requires guice.service;
    requires stringer;
        
    provides service guice.service.GuiceInjectorService with hasher.HasherInjectorProvider;
}
