package com.hjcrm.system.entity;

/**
 * 角色  用户关系表
 */
public class Role_menu {
    private int id;//主键
    private int roleid;//角色id
    private int menuid;//用户id
    private int dr;//删除 0 1

    public Role_menu(int id, int roleid, int menuid, int dr) {
        this.id = id;
        this.roleid = roleid;
        this.menuid = menuid;
        this.dr = dr;
    }

    @Override
    public String toString() {
        return "Role_menu{" +
                "id=" + id +
                ", roleid=" + roleid +
                ", menuid=" + menuid +
                ", dr=" + dr +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRoleid() {
        return roleid;
    }

    public void setRoleid(int roleid) {
        this.roleid = roleid;
    }

    public int getMenuid() {
        return menuid;
    }

    public void setMenuid(int menuid) {
        this.menuid = menuid;
    }

    public int getDr() {
        return dr;
    }

    public void setDr(int dr) {
        this.dr = dr;
    }

    public Role_menu() {
        super();
    }
}
