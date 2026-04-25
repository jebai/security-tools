import io.github.jebai.securitytools.SecurityUtils;

public class App {
    public static void main(String[] args) {
        System.out.println("Library version: " + SecurityUtils.getVersion());
    }
}
