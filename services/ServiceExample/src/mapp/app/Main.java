package app;

import java.util.ServiceLoader;
import stringer.StringTransformer;

public class Main {
    public static void main(String[] args) {
        final String s = "The quick brown fox jumped over the lazy dog";
        
        transform(s, ServiceLoader.load(StringTransformer.class));
        transform(s, ServiceLoader.loadInstalled(StringTransformer.class));
        transform(s, ServiceLoader.load(StringTransformer.class, ClassLoader.getSystemClassLoader()));
    }
    
    private static void transform(String s, Iterable<StringTransformer> i) {
        System.out.println("Transform: " + s);
        for (StringTransformer st: i) {
            System.out.println(st.description() + ": " + st.transform(s));
        }        
    }
}
