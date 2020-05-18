package maksym.db.entity;

/**
 * User entity
 *
 * @author Maks
 */
public class User {

    private int id;
    private String name;
    private String surname;
    private String pass;
    private int role;
    private String phone;
    private String email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", pass='" + pass + '\'' +
                ", role=" + role +
                ", phone='" + phone + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public static User createUser(String n, String sur, String phone, String mail, String pass, int role) {
        User user = new User();
        user.setName(n);
        user.setSurname(sur);
        user.setPhone(phone);
        user.setEmail(mail);
        user.setPass(pass);
        user.setRole(role);
        return user;

    }
}
