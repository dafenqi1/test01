package com.offcn.dao.impl;

import com.offcn.bean.Book;
import com.offcn.bean.Page;
import com.offcn.dao.BookDao;
import com.offcn.utils.DataSourceUtils;
import com.offcn.utils.DateUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class BookDaoImpl implements BookDao {

    @Override
    public int insertBook(Book book) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into book value (null,?,?,?,?,?,?)";
        int i = 0;
        try {
            i = qr.update(sql, book.getBooknum(), book.getBookname(), book.getBookauthor(),
                    book.getBookpublish(), book.getBookdate(), book.getBookprice());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    @Override
    public List<Book> selectAll() {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from book";
        List<Book> blist = null;
        try {
            blist = qr.query(sql, new BeanListHandler<>(Book.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return blist;
    }

    @Override
    public List<Book> selectByCondition(Book book) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = getSql(book);
        List<Book> blist = null;
        try {
            blist = qr.query(sql, new BeanListHandler<>(Book.class));
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return blist;
    }

    @Override
    public Book selectById(int id) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from book where id = ?";
        Book book = null;
        try {
            book = qr.query(sql, new BeanHandler<>(Book.class), id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return book;
    }

    @Override
    public int updateById(Book book) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "update book set booknum = ?,bookname = ?,bookauthor = ?,bookpublish = ?," +
                "bookdate = ?,bookprice = ? where id = ?";
        int i = 0;
        try {
            i = qr.update(sql, book.getBooknum(), book.getBookname(), book.getBookauthor(),
                    book.getBookpublish(), book.getBookdate(), book.getBookprice(), book.getId());
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    @Override
    public int delById(int id) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "delete from book where id = ?";
        int i = 0;
        try {
            i = qr.update(sql, id);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return i;
    }

    @Override
    public List<Book> selectByPage(Page page) {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select * from book order by id limit ?,?";
        //
        List<Book> list = null ;
        //                                                 数据库中查询的索引值  每页显示条数
        try {
          list = qr.query(sql,new BeanListHandler<>(Book.class),page.getPageIndex(),page.getPageSize());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    //查询总条数
    @Override
    public Integer getCount() {
        QueryRunner qr = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "select count(id) from book";
        long count = 0;
        try {
            count =  qr.query(sql, new ScalarHandler<>());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return (int) count;
    }


    /*
    select * from book where 1=1
    and booknum like '%00%'
    and bookname like '%三%'
    and bookauthor like '%罗贯中%'
    and bookdate = '2008-11-12'
    and bookprice = 140;
     */
    //拼接sql
    private String getSql(Book book) {
        StringBuilder sb = new StringBuilder("select * from book where 1=1");
        //and booknum like '%00%'
        if(book.getBooknum() != null && !"".equals(book.getBooknum().trim())){
            sb.append(" and booknum like '%").append(book.getBooknum()).append("%'");
        }
        if(book.getBookname() != null && !"".equals(book.getBookname().trim())){
            sb.append(" and bookname like '%").append(book.getBookname()).append("%'");
        }
        if(book.getBookauthor() != null && !"".equals(book.getBookauthor().trim())){
            sb.append(" and bookauthor like '%").append(book.getBookauthor()).append("%'");
        }
        if(book.getBookpublish() != null && !"".equals(book.getBookpublish().trim())){
            sb.append(" and bookpublish like '%").append(book.getBookpublish()).append("%'");
        }
        //and bookdate = '2008-11-12'
        if(book.getBookdate() != null){
            sb.append(" and bookdate = '").append(DateUtil.dateToString(book.getBookdate())).append("'");
        }
        //and bookprice = 140;
        if(book.getBookprice() != 0){
            sb.append(" and bookprice = ").append(book.getBookprice());
        }
        return sb.toString();
    }


}
