package com.offcn.dao;

import com.offcn.bean.Book;
import com.offcn.bean.Page;

import java.util.List;

public interface BookDao {

    //添加书籍
    int insertBook(Book book);

    //查询全部
    List<Book> selectAll();

    //根据条件查询
    List<Book> selectByCondition(Book book);

    //根据id查询
    Book selectById(int id);

    //根据id修改
    int updateById(Book book);

    //根据id删除
    int delById(int id);

    //分页 本质上是查询所有数据
    List<Book> selectByPage(Page page);
    //
        Integer getCount();
}
