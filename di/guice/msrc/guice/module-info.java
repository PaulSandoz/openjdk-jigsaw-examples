module guice@3.0 {
    requires public javax.inject@1;
    requires public aopalliance@1.0;
    requires jdk.logging;

    exports com.google.inject;
    exports com.google.inject.binder;
    exports com.google.inject.matcher;
    exports com.google.inject.name;
    exports com.google.inject.spi;
    exports com.google.inject.util;

    view guice.internal {
        permits guice.multibindings;

        exports com.google.inject.internal.util;
    }
}
