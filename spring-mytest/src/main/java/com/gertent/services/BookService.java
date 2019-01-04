package com.gertent.services;

import com.gertent.dao.BookDao;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 * @Author wyf
 * @Date 2019/1/2 11:39
 * @Desc
 * @Version 1.0
 */
@Service
public class BookService {
    //@Qualifier("bookDao")
    //@Autowired(required=false)
    //@Resource(name="bookDao2")
    @Inject
    private BookDao bookDao;

    public void print(){
        System.out.println(bookDao);
    }

    @Override
    public String toString() {
        return "BookService [bookDao=" + bookDao + "]";
    }
}
