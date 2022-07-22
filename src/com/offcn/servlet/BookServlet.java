package com.offcn.servlet;

import com.offcn.bean.Book;
import com.offcn.bean.Page;
import com.offcn.service.BookService;
import com.offcn.service.BookServiceImpl;
import com.offcn.utils.DateUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/BookServlet")
public class BookServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //判断执行哪个功能   通过method的值
        String method = req.getParameter("method");
        if("add".equals(method)){
            addBook(req,resp);
        }else if ("selectAll".equals(method)){
            selectAll(req,resp);
        }else if("selectByCondition".equals(method)){
            selectByCondition(req,resp);
        }else if("preUpdate".equals(method)){
            selectById(req,resp);
        }else if("updateById".equals(method)){
            updateById(req,resp);
        }else if("del".equals(method)){
            delById(req,resp);
        }else if("selectByPage".equals(method)){
            selectByPage(req, resp);

        }
        else {
            System.out.println();
        }
    }
      //分页查询
    private void selectByPage(HttpServletRequest req,HttpServletResponse resp) throws ServletException,IOException{
        //创建service方法 调用分页方法
        BookService bs = new BookServiceImpl();
        //创建Page
        Page page = new Page();
        //获取当前的页面 点击index.jsp 存在页码 获取页码 页码不存在 设置当前页码为一
        String pageNum = req.getParameter("pageNum");
        if (pageNum != null && ! "".equals(pageNum.trim()) ){
            page.setPageNum(Integer.parseInt(pageNum));
        }else {
            page.setPageNum(1);
        }
        //查询总页码  设置总条数 同时设置总页码
        page.setTotalCount(bs.getCount());
      //  System.out.println(bs.getCount());
        //调用分页的方法
        List<Book> list = bs.selectByPage(page); // 查询到的是前两条记录
        //存到作用域
        req.setAttribute("list",list);
        req.setAttribute("page",page);
        //跳转页面
        req.getRequestDispatcher("showByPage.jsp").forward(req,resp);


    }
    //根据id删除
    private void delById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取id
        String id = req.getParameter("id");
        //调用方法
        BookService bs = new BookServiceImpl();
        int i = bs.delById(Integer.parseInt(id));
        if(i > 0){
            resp.sendRedirect("BookServlet?method=selectAll");
        }else{
            resp.sendRedirect("error.jsp");
        }
    }

    //更新  修改   根据条件id更新
    private void updateById(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取参数
        String id = req.getParameter("id");
        String booknum = req.getParameter("booknum");
        String bookname = req.getParameter("bookname");
        String bookauthor = req.getParameter("bookauthor");
        String bookpublish = req.getParameter("bookpublish");
        String bookdate = req.getParameter("bookdate");
        String bookprice = req.getParameter("bookprice");
        //创建对象
        Book book = new Book();
        book.setId(Integer.parseInt(id));
        book.setBooknum(booknum);
        book.setBookname(bookname);
        book.setBookauthor(bookauthor);
        book.setBookpublish(bookpublish);
        if(bookdate != null && !"".equals(bookdate.trim())){
            book.setBookdate(DateUtil.stringToDate(bookdate));
        }
        if(bookprice != null && !"".equals(bookprice.trim())){
            book.setBookprice(Integer.parseInt(bookprice));
        }
        //调用方法
        BookService bs = new BookServiceImpl();
        int i = bs.updateById(book);
        if(i > 0){
            resp.sendRedirect("BookServlet?method=selectAll");
        }else{
            resp.sendRedirect("error.jsp");
        }
    }

    //根据id查询
    private void selectById(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取id
        String id = req.getParameter("id");
        //调用方法
        BookService bs = new BookServiceImpl();
        Book book = bs.selectById(Integer.parseInt(id));
        //存值
        req.setAttribute("book",book);
        req.getRequestDispatcher("updateBook.jsp").forward(req,resp);
    }

    //通过条件查询
    private void selectByCondition(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取参数
        String booknum = req.getParameter("booknum");
        String bookname = req.getParameter("bookname");
        String bookauthor = req.getParameter("bookauthor");
        String bookpublish = req.getParameter("bookpublish");
        String bookdate = req.getParameter("bookdate");
        String bookprice = req.getParameter("bookprice");
        //创建对象
        Book book = new Book();
        book.setBooknum(booknum);
        book.setBookname(bookname);
        book.setBookauthor(bookauthor);
        book.setBookpublish(bookpublish);
        if(bookdate != null && !"".equals(bookdate.trim())){
            book.setBookdate(DateUtil.stringToDate(bookdate));
        }
        if(bookprice != null && !"".equals(bookprice.trim())){
            book.setBookprice(Integer.parseInt(bookprice));
        }
        //调用方法
        BookService bs = new BookServiceImpl();
        List<Book> list = bs.selectByCondition(book);
        System.out.println(list);
        req.setAttribute("blist",list);
        req.getRequestDispatcher("showBook.jsp").forward(req,resp);
    }

    //查询全部
    private void selectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //调用方法
        BookService bs = new BookServiceImpl();
        List<Book> blist = bs.selectAll();
        //存储在作用域中   显示页面
        req.setAttribute("blist",blist);
        //跳转到展示全部页面
        req.getRequestDispatcher("showBook.jsp").forward(req,resp);
    }

    //添加
    private void addBook(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //获取参数
        String booknum = req.getParameter("booknum");
        String bookname = req.getParameter("bookname");
        String bookauthor = req.getParameter("bookauthor");
        String bookpublish = req.getParameter("bookpublish");
        String bookdate = req.getParameter("bookdate");
        String bookprice = req.getParameter("bookprice");
        //创建对象
        Book book = new Book(booknum,bookname,bookauthor,bookpublish,
                DateUtil.stringToDate(bookdate),Integer.parseInt(bookprice));
        //添加功能
        BookService bs = new BookServiceImpl();
        int i = bs.insertBook(book);
        if(i > 0){
            //添加成功   跳转到查询全部
            resp.sendRedirect("BookServlet?method=selectAll");
        }else{
            //添加失败
            resp.sendRedirect("error.jsp");
        }

    }
}
