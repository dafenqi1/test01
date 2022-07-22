package com.offcn.service;

import com.offcn.bean.Book;
import com.offcn.bean.Page;
import com.offcn.dao.BookDao;
import com.offcn.dao.impl.BookDaoImpl;

import java.util.List;

public class BookServiceImpl implements BookService{

    private BookDao bd = new BookDaoImpl();

    @Override
    public int insertBook(Book book) {
        return bd.insertBook(book);
    }

    @Override
    public List<Book> selectAll() {
        return bd.selectAll();
    }

    @Override
    public List<Book> selectByCondition(Book book) {
        return bd.selectByCondition(book);
    }

    @Override
    public Book selectById(int id) {
        return bd.selectById(id);
    }

    @Override
    public int updateById(Book book) {
        return bd.updateById(book);
    }

    @Override
    public int delById(int id) {
        return bd.delById(id);
    }

    @Override
    public List<Book> selectByPage(Page page) {
        return null;
    }

    @Override
    public Integer getCount() {
        return 0;
    }
}
