
package nl.tudelft.sem.template.menu.authentication;

public class Credentials {
    public transient String name;
    public transient String role;

    public Credentials(String n, String r) {
        this.name = n;
        this.role = r;
    }
}