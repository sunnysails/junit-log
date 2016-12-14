package com.kaishengit.dao;

import com.kaishengit.entity.Book;
import com.kaishengit.util.DbHelp;
import org.apache.commons.dbutils.handlers.BeanHandler;

/**
 * Created by sunny on 2016/12/13.
 */
public class BookDao {
    public void save(Book book){
        String sql = "INSERT INTO t_book(name, author, nowNumber, total, isbn) VALUES (?,?,?,?,?)";
        DbHelp.update(sql,book.getName(),book.getAuthor(),book.getNowNumber(),book.getTotal(),book.getIsbn());
    }
    public Book findById(Integer id){
        String sql= "SELECT * FROM t_book WHERE id = ?";
        return DbHelp.query(sql,new BeanHandler<>(Book.class),id);
    }
}
