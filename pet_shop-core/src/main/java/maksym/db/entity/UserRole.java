package maksym.db.entity;

public enum UserRole {
    USER(0),
    ADMIN(1);

    private final int roleId;

    UserRole(int roleId) {
        this.roleId = roleId;
    }

    public int getRoleId() {
        return roleId;
    }

    public static UserRole fromId(int id) {
        for (UserRole role : values()) {
            if (role.roleId == id) {
                return role;
            }
        }
        return null;
    }
}
