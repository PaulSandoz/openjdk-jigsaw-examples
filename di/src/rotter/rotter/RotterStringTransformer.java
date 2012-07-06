package rotter;

import stringer.StringTransformer;

public class RotterStringTransformer implements StringTransformer {

    @Override
    public String description() {
        return "ROT13";
    }

    @Override
    public String transform(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            sb.append(transform(c));
        }

        return sb.toString();
    }

    private char transform(char c) {
        if (c >= 'a' && c <= 'm') {
            c += 13;
        } else if (c >= 'n' && c <= 'z') {
            c -= 13;
        } else if (c >= 'A' && c <= 'M') {
            c += 13;
        } else if (c >= 'N' && c <= 'Z') {
            c -= 13;
        }
        return c;
    }
}