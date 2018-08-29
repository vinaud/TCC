package persistence;

import entities.User;



public class AddUser {

    public static void main(String[] args) {
    User u = new User();
    u.setName("Franky");
    u.setUsername("tom");
    u.setLevel(40);

    UserDAOHibernate dao = new UserDAOHibernate();
    dao.inserirusuario(u);
}}
