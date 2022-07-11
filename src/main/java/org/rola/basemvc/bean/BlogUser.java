package org.rola.basemvc.bean;

/**
 * @author D
 * @date 2022/7/11
 * @Class BlogUser
 * @description TODO
 */
public class BlogUser {
    private Integer id;
    private String username;
    private String avatar;
    private String email;
    private String password;
    private String status;
    private String created;
    private String last_login;

    public BlogUser() {
    }

    public BlogUser(Integer id, String username, String avatar, String email, String password, String status, String created, String last_login) {
        this.id = id;
        this.username = username;
        this.avatar = avatar;
        this.email = email;
        this.password = password;
        this.status = status;
        this.created = created;
        this.last_login = last_login;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getLast_login() {
        return last_login;
    }

    public void setLast_login(String last_login) {
        this.last_login = last_login;
    }
}
