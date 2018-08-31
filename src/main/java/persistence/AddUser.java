package persistence;

import entities.User;



public class AddUser {

    public static void main(String[] args) {
    User u = new User();
    u.setName("uSer omega");
    u.setUsername("xomega");
    u.setLevel(33);

    UserDAOHibernate dao = new UserDAOHibernate();
    dao.inserirusuario(u);
}}
