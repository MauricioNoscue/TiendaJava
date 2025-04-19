package com.Sena.CrudJava.DTO.requestRegister;

public class requestRegisterUserRole {

    private int userRoleId;
    private int userId;
    private int roleId;

    public requestRegisterUserRole() {
    }

    public requestRegisterUserRole(int userRoleId, int userId, int roleId) {
        this.userRoleId = userRoleId;
        this.userId = userId;
        this.roleId = roleId;
    }

    public int getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(int userRoleId) {
        this.userRoleId = userRoleId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }
}
