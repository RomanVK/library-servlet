package ua.lib.model.dao;

import ua.lib.model.entity.User;

import java.util.Optional;

public interface UserDao extends GenericDao<User>{

    Optional<User> findByEmail(String name);
}
