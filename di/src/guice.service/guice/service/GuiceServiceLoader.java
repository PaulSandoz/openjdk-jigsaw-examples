package guice.service;

import com.google.inject.Binding;
import com.google.inject.Injector;
import com.google.inject.Key;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.ServiceLoader;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class GuiceServiceLoader<T> implements Iterable<T> {

    static class Initializer {

        private static Set<Injector> injectors = load();

        private static Set<Injector> load() {
            final Set<Injector> giss = new LinkedHashSet<>();
            for (GuiceInjectorService g : ServiceLoader.
                    load(GuiceInjectorService.class)) {
                giss.add(g.getInjector());
            }
            return giss;
        }
    }

    static Set<Injector> getInjectors() {
        return new LinkedHashSet<>(Initializer.injectors);
    }

    private static ConcurrentHashMap<Key, Map> cache = new ConcurrentHashMap<>();

    @SuppressWarnings("unchecked")
    private static <T> Map<Injector, List<Key<T>>> getInjectorsAndKeys(Key<T> k) {
        Map v = cache.get(k);
        if (v == null) {
            v = createInjectorsAndKeys(k);

            Map _v = cache.putIfAbsent(k, v);
            if (_v != null) {
                v = _v;
            }
        }
        // Values will always be of Map<Injector, List<Key<T>>>
        return (Map<Injector, List<Key<T>>>) v;
    }

    private static <T> Map<Injector, List<Key<T>>> createInjectorsAndKeys(Key<T> k) {
        Map<Injector, List<Key<T>>> injectorsAndKeys = new LinkedHashMap<>();
        for (Injector i : getInjectors()) {
            for (Binding<T> b : i.findBindingsByType(k.getTypeLiteral())) {
                List<Key<T>> l = injectorsAndKeys.get(i);
                if (l == null) {
                    l = new ArrayList<>();
                    injectorsAndKeys.put(i, l);
                }
                l.add(b.getKey());
            }
        }
        return injectorsAndKeys;
    }

    private final Map<Injector, List<Key<T>>> injectorsAndKeys;

    private GuiceServiceLoader(Class<T> s) {
        this.injectorsAndKeys = getInjectorsAndKeys(Key.get(s));
    }

    @Override
    public Iterator<T> iterator() {
        final Iterator<Map.Entry<Injector, List<Key<T>>>> i = 
                injectorsAndKeys.entrySet().iterator();

        return new Iterator<T>() {

            Injector injector;

            Iterator<Key<T>> keys;

            @Override
            public boolean hasNext() {
                if (keys == null || !keys.hasNext()) {
                    if (i.hasNext()) {
                        final Map.Entry<Injector, List<Key<T>>> e = i.next();
                        injector = e.getKey();
                        keys = e.getValue().iterator();
                        return true;
                    } else {
                        return false;
                    }
                }
                return true;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }

                return injector.getInstance(keys.next());
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }

    public static <T> GuiceServiceLoader<T> load(Class<T> s) {
        return new GuiceServiceLoader<>(s);
    }
}