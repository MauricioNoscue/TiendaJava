package com.Sena.CrudJava.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity(name = "UserRole")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserRoleId")
    private int UserRoleId;
    @ManyToOne
    @JoinColumn(name = "userId", referencedColumnName = "UserId", nullable = false)
    private Users user;

    @ManyToOne
    @JoinColumn(name = "roleId", referencedColumnName = "RoleId", nullable = false)
    private Role role;

    public UserRole() {
    }

    public UserRole(int userRoleId, Users user, Role role) {
        UserRoleId = userRoleId;
        this.user = user;
        this.role = role;
    }

    public int getUserRoleId() {
        return UserRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        UserRoleId = userRoleId;
    }

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
    

}
