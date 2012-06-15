package hasher;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import stringer.StringTransformer;

public class HasherStringTransformer implements StringTransformer {

    @Override
    public String description() {
        return "MD5";
    }

    @Override
    public String transform(String s) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            StringBuilder sb = new StringBuilder();
            for (byte b: md.digest(s.getBytes(Charset.forName("UTF-8")))) {
                sb.append(String.format("%02X", b));
            }
            return sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}