package mapp;

import guice.service.GuiceServiceLoader;
import stringer.StringTransformer;

public class App {

    public static void main(String[] args) throws Exception {
        for (StringTransformer s : GuiceServiceLoader.load(StringTransformer.class)) {
            System.out.println(s + " " + s.description());
        }

        for (StringTransformer s : GuiceServiceLoader.load(StringTransformer.class)) {
            System.out.println(s + " " + s.description());
        }
    }
}