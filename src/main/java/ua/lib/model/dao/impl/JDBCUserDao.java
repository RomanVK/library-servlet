package ua.lib.model.dao.impl;

import ua.lib.model.dao.UserDao;
import ua.lib.model.dao.mappers.UserMapper;
import ua.lib.model.entity.RoleType;
import ua.lib.model.entity.User;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCUserDao implements UserDao {
    private Connection connection;

    public JDBCUserDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(User entity) {
        try (PreparedStatement ps = connection.prepareStatement
                ("insert into user (email, first_name, last_name, role, password) values(?,?,?,?,?)")){

            ps.setString(1, entity.getEmail());
            ps.setString(2, entity.getFirstName());
            ps.setString(3, entity.getLastName());
            ps.setString(4, entity.getRole().toString());
            ps.setString(5, entity.getPassword());

            int i = ps.executeUpdate();

            if(i > 0) {
                System.out.println(entity + " are successfully registered");//TODO make log
            }
        }
        catch(Exception se) {
            throw new RuntimeException(se.getMessage());
        }
    }

    @Override
    public User findById(String email) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public void update(User entity) {

    }

    @Override
    public void delete(int id) {
        try (PreparedStatement ps = connection.prepareStatement
                ("delete from user where id= ?")){
            ps.setInt(1, id);
            int i = ps.executeUpdate();
            if(i > 0) {
                System.out.println("User with id " + id + " is successfully deleted");//TODO make a logging
            }
        }
        catch(Exception se) {
            throw new RuntimeException(se.getMessage());//TODO make a logging and a handling exception
        }
    }

    @Override
    public void close() {

    }

    @Override
    public Optional<User> findByEmail(String email) {
        Optional<User> result = Optional.empty();

        try(PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE email = ?")){
            ps.setString( 1, email);
            ResultSet rs;
            rs = ps.executeQuery();
            UserMapper mapper = new UserMapper();
            if (rs.next()){
                result = Optional.of(mapper.extractFromResultSet(rs));
            }
        }catch (Exception ex){
            throw new RuntimeException(ex);//TODO make a logging
        }

        return result;
    }

    @Override
    public List<User> findAllLibrarians() {
        List<User> result = new ArrayList<>();

        try(PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE role = ?")){
            ps.setString( 1, "LIBRARIAN");
            ResultSet rs;
            rs = ps.executeQuery();
            UserMapper mapper = new UserMapper();
            while (rs.next()){
                User user = mapper.extractFromResultSet(rs);
                result.add(user);
            }
            return result;
        }catch (Exception ex){
            throw new RuntimeException(ex.getMessage());//TODO make a logging  and a handling exception
        }
    }

    @Override
    public List<User> findAllUsers() {

        List<User> result = new ArrayList<>();

        try(PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE role = ?")){
            ps.setString( 1, "USER");
            ResultSet rs;
            rs = ps.executeQuery();
            UserMapper mapper = new UserMapper();
            while (rs.next()){
                User user = mapper.extractFromResultSet(rs);
                result.add(user);
            }
            return result;
        }catch (Exception ex){
            throw new RuntimeException(ex.getMessage());//TODO make a logging  and a handling exception
        }
    }

    @Override
    public void block(int id) {
        try (PreparedStatement ps = connection.prepareStatement
                ("update user set blocked=1 where id= ?")){
            ps.setInt(1, id);
            int i = ps.executeUpdate();
            if(i > 0) {
                System.out.println("User with id =" + id + " is successfully blocked");//TODO make a logging
            }
        }
        catch(Exception se) {
            throw new RuntimeException(se.getMessage());//TODO make a logging and a handling exception
        }
    }

    @Override
    public void unblock(int id) {
        try (PreparedStatement ps = connection.prepareStatement
                ("update user set blocked=0 where id= ?")){
            ps.setInt(1, id);
            int i = ps.executeUpdate();
            if(i > 0) {
                System.out.println("User with id =" + id + " is successfully unblocked");//TODO make a logging
            }
        }
        catch(Exception se) {
            throw new RuntimeException(se.getMessage());//TODO make a logging and a handling exception
        }
    }
}
