package ua.lib.model.services;

import ua.lib.model.dao.DaoFactory;
import ua.lib.model.dao.UserDao;
import ua.lib.model.entity.User;

import java.util.List;
import java.util.Optional;

public class UserService{
    DaoFactory daoFactory = DaoFactory.getInstance();

    public void registrationUser(User user){
        try(UserDao dao = daoFactory.createUserDao()){
            dao.create(user);
        }
    }

    public Optional<User> login(String email){
        Optional<User> result;
        try(UserDao dao = daoFactory.createUserDao()){
            result = dao.findByEmail(email);
        }
        return result;
    }

    public List<User> getAllLibrarians(){
        List<User> result;
        try(UserDao dao = daoFactory.createUserDao()){
            result = dao.findAllLibrarians();
        }
        return result;
    }

    public void delete(int id){
        try(UserDao dao = daoFactory.createUserDao()){
            dao.delete(id);
        }
    }

    public List<User> getAllUsers(){
        List<User> result;
        try(UserDao dao = daoFactory.createUserDao()){
            result = dao.findAllUsers();
        }
        return result;
    }

    public void block(int id){
        try(UserDao dao = daoFactory.createUserDao()){
            dao.block(id);
        }
    }

    public void unblock(int id){
        try(UserDao dao = daoFactory.createUserDao()){
            dao.unblock(id);
        }
    }

    public Optional<User> getById(int id){
        Optional<User> result;
        try(UserDao dao = daoFactory.createUserDao()){
            result = dao.findById(id);
        }
        return result;
    }


}
