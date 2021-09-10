package ua.lib.model.dao.impl;

import ua.lib.model.dao.BookDao;
import ua.lib.model.dao.mappers.BookMapper;
import ua.lib.model.entity.Book;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class JDBCBookDao implements BookDao {

    private Connection connection;

    public JDBCBookDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void create(Book entity) {
        try (PreparedStatement ps = connection.prepareStatement
                ("insert into book" +
                        "(title, author, publisher, publishing_date, isbn, quantity)" +
                        " values(?,?,?,?,?,?)")) {

            ps.setString(1, entity.getTitle());
            ps.setString(2, entity.getAuthor());
            ps.setString(3, entity.getPublisher());
            ps.setDate(4, Date.valueOf(entity.getPublishingDate()));
            ps.setString(5, entity.getISBN());
            ps.setInt(6, entity.getQuantity());

            int i = ps.executeUpdate();

            if (i > 0) {
                System.out.println(entity + " are successfully create");//TODO make log
            }
        } catch (Exception se) {
            throw new RuntimeException(se.getMessage());
        }
    }

    @Override
    public Optional<Book> findById(int id) {
        Optional<Book> result = Optional.empty();

        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM user WHERE id = ?")) {
            ps.setInt(1, id);
            ResultSet rs;
            rs = ps.executeQuery();
            BookMapper mapper = new BookMapper();
            if (rs.next()) {
                result = Optional.of(mapper.extractFromResultSet(rs));
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);//TODO make a logging
        }

        return result;
    }

    @Override
    public List<Book> findAll() {
        List<Book> result = new ArrayList<>();

        try (PreparedStatement ps = connection.prepareStatement("SELECT * FROM book")) {
            ResultSet rs;
            rs = ps.executeQuery();
            BookMapper mapper = new BookMapper();
            while (rs.next()) {
                Book book = mapper.extractFromResultSet(rs);
                result.add(book);
            }
            return result;
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());//TODO make a logging  and a handling exception
        }
    }

    @Override
    public void update(Book entity) {
        try (PreparedStatement ps = connection.prepareStatement
                ("update book set title=?, author=? , publisher=?, publishing_date=?, isbn=? where id=?")) {

            ps.setString(1, entity.getTitle());
            ps.setString(2, entity.getAuthor());
            ps.setString(3, entity.getPublisher());
            ps.setDate(4, Date.valueOf(entity.getPublishingDate()));
            ps.setString(5, entity.getISBN());
            ps.setLong(5, entity.getId());

            int i = ps.executeUpdate();

            if (i > 0) {
                System.out.println(entity + " are successfully update");//TODO make log
            }
        } catch (Exception se) {
            throw new RuntimeException(se.getMessage());
        }

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public void close() {

    }
}
