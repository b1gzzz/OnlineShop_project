package Essences;

// admin data

public class Admin {
    private static final String ADMIN_NAME = "admin";
    private static final long ADMIN_PASS = 6576;

    public String getName() {
        return ADMIN_NAME;
    }

    public long getPassword() {
        return ADMIN_PASS;
    }

    @Override
    public String toString() {
        return "Admin{" +
                "name='" + ADMIN_NAME + '\'' +
                ", password=" + ADMIN_PASS +
                '}';
    }
}
