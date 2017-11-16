package com.ex.dao;

import com.ex.util.SessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public interface Dao<T> {
    public List<T> findAll();
    public T findOne(Serializable id);
    default T update(T o) {
        Session session = SessionFactoryUtil.getSession();
        Transaction tx = null;

        try{
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
        }catch (HibernateException e) {
            if (tx!=null) {
                tx.rollback();
            }
            e.printStackTrace();
        }finally {
            session.close();
        }
        return null;
    };
    public void delete(Serializable id);
}
