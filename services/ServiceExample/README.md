This is a simple example consists of four modules.

The service interface module, mstringer, that exports (the package containing) a
service interface, StringTransformer, for transforming strings.

The service consumer module, mapp, that is the application module and consumes
service instances that are instances of StringTransformer.

Two service provider modules, mhasher and mrotter, that provide implementations
of StringTransform that are declared as service provider classes.

The module mapp will create the service instances for StringTransformer 
using java.util.ServiceLoader.

To compile, install and execute set the environment variable JAVA8_HOME to
the build of OpenJDK Jigsaw and then execute:

  ant -f build8.xml all

This example can be loaded and edited in NetBeans, although NetBeans will
of course no nothing about modules, so expect to see some red squiggly lines
in the editor.
