package ua.lib.model.services;

import ua.lib.model.dao.BookDao;
import ua.lib.model.dao.DaoFactory;
import ua.lib.model.entity.Book;

import java.util.List;
import java.util.Optional;

public class BookService {
    DaoFactory daoFactory = DaoFactory.getInstance();

    public void create(Book book) {
        try (BookDao dao = daoFactory.createBookDao()) {
            dao.create(book);
        }
    }

    public List<Book> getAll() {
        List<Book> result;
        try (BookDao dao = daoFactory.createBookDao()) {
            result = dao.findAll();
        }
        return result;
    }

    public Optional<Book> getById(int id) {
        Optional<Book> result;
        try (BookDao dao = daoFactory.createBookDao()) {
            result = dao.findById(id);
        }
        return result;
    }

    public void update(Book book) {
        try (BookDao dao = daoFactory.createBookDao()) {
            dao.update(book);
        }
    }


}
