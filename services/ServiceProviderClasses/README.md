This example is a variant of the ServiceExample example.

It presents an example that is possible with modular services
but is not possible using META-INF/services.

The service provider modules, mhasher and mrotter, are split
into separate source layouts and are compiled and installed separately.

Each module contains a service provider class of the same name.
Note that each module does not export the package containing the
service provider class. Thus that class remains private to the module
and is not visible or accessible to other modules.

When in classpath mode duplicate class names in META-INF/services files 
are ignored (not just in one META-INF/service file but all files that are
loaded using the selected class loader).

To compile, install and execute set the environment variable JAVA8_HOME to
the build of OpenJDK Jigsaw and then execute:

  ant -f build8.xml all
