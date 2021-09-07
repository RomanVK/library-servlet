package ua.lib.model.dao;

import ua.lib.model.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserDao extends GenericDao<User>{

    Optional<User> findByEmail(String email);

    List<User> findAllLibrarians();

    List<User> findAllUsers();

    void block(int id);

    void unblock(int id);
}
