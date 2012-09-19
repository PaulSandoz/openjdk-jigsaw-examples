package bar;

import foo.Foo;

public class Bar {

    public static void main(String[] args) {
        System.out.println("Bar");
        
        Foo f = new Foo();
        System.out.println(f.stuff());
    }
}
