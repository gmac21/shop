package dao;

import java.util.List;
import persistence.PersistenceUtil;
import entity.User;

import javax.persistence.Entity;
import javax.persistence.EntityManager;


public class UserDao {

    public static void main(String[] args){
        UserDao config = new UserDao();


    }

    public UserDao(){
        User p = new User("Gar", "hello");
        createUser(p);
    }


    public void viewUser(){
        List<User> users = PersistenceUtil.findAllUsers();
        for(User s:users){
            System.out.println("User "+s.getUsername()+ " exists.");
        }
    }


    public static void createUser(User u){


        PersistenceUtil.persist(u);
        System.out.println("User registered");
    }

    EntityManager em = PersistenceUtil.createEM();


    public List<User> findAll(){
        return em.createNamedQuery("User.findAllUsers").getResultList();
    }


}
