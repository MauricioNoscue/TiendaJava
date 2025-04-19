package com.Sena.CrudJava.DTO.requestRegister;

public class requestRegisterRole {
    private int roleId;
    private String roleName;
  
    public requestRegisterRole() {
    }

    public requestRegisterRole(int roleId,String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

}
