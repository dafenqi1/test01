package com.offcn.service;

import com.offcn.bean.Book;
import com.offcn.bean.Page;

import java.util.List;

public interface BookService {

    int insertBook(Book book);

    List<Book> selectAll();

    List<Book> selectByCondition(Book book);

    Book selectById(int id);

    int updateById(Book book);

    int delById(int id);
    //分页 本质上是查询所有数据
    List<Book> selectByPage(Page page);
    Integer getCount();
}
