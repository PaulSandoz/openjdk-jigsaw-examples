package mapp;

import guice.service.GuiceServiceLoader;
import stringer.StringTransformer;

public class App {

    public static void main(String[] args) throws Exception {
        GuiceServiceLoader<StringTransformer> gsl =
                GuiceServiceLoader.load(StringTransformer.class);

        for (StringTransformer s : gsl) {
            System.out.println(s.description());
        }
    }
}