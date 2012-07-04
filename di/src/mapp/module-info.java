module mapp@1.0 {
    requires guice.service;
    requires stringer;
    // This is required to stop logging in Guice outputing errors
    // See java.util.logging.LogManager$3.run(LogManager.java:418)
    // which is trying to load the logging class using the system class
    // loader
    requires jdk.logging;

    requires service guice.service.GuiceInjectorService;

    class mapp.App;
}
