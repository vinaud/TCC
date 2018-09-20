package persistence;

import entities.User;



public class AddUser {

    public static void main(String[] args) {
    User u = new User();
    u.setName("Robert E. Speedwagon");
    u.setUsername("speedwagon");
    u.setLevel(1);
    u.setPatente("iniciante");
    u.setIcon("icon1");

    UserDAOHibernate dao = new UserDAOHibernate();
    dao.inserirusuario(u);
}}
