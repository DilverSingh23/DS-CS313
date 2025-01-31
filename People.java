public abstract class People {
    private String name;
    private String role;
    
    public People (String n, String r) {
        name = n;
        role = r;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }
}
