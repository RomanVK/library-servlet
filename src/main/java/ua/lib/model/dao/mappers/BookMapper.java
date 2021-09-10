package ua.lib.model.dao.mappers;

import ua.lib.model.entity.Book;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

public class BookMapper implements ObjectMapper<Book> {
    @Override
    public Book extractFromResultSet(ResultSet rs) throws SQLException {
        Book book = new Book();
        book.setId(rs.getInt("id"));
        book.setTitle(rs.getString("title"));
        book.setAuthor(rs.getString("author"));
        book.setPublisher(rs.getString("publisher"));
        book.setPublishingDate(rs.getDate("publishing_date").toLocalDate());
        book.setISBN(rs.getString("isbn"));
        book.setQuantity(rs.getInt("quantity"));
        return book;
    }

    @Override
    public Book makeUnique(Map<Long, Book> cache, Book book) {
        cache.putIfAbsent(book.getId(), book);
        return cache.get(book.getId());
    }
}