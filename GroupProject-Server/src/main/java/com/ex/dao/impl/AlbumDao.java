package com.ex.dao.impl;

import com.ex.dao.Dao;
import com.ex.model.ChinookAlbum;
import com.ex.util.SessionFactoryUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.io.Serializable;
import java.util.List;

public class AlbumDao implements Dao<ChinookAlbum> {
    @Override
    public List<ChinookAlbum> findAll() {
        Session s = SessionFactoryUtil.getSession();

        try {
            List<ChinookAlbum> list = s.createCriteria(ChinookAlbum.class).list();
            return list;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            s.close();
        }
        return null;
    }

    @Override
    public ChinookAlbum findOne(Serializable id) {
        Session s = SessionFactoryUtil.getSession();

        try {
            ChinookAlbum album = (ChinookAlbum)s.get(ChinookAlbum.class, id);

            //load returns a proxy object
            //a proxy object must be accessed before exiting the session
            //otherwise it will contain no data and will throw a
            //LazyInitializationException if accessed outside of the session
//            ChinookAlbum album2 = (ChinookAlbum)s.load(ChinookAlbum.class, id);
//            album2.getArtist();

            return album;
        } catch (HibernateException ex) {
            ex.printStackTrace();
        } finally {
            s.close();
        }
        return null;
    }

    @Override
    public ChinookAlbum update(ChinookAlbum o) {
        return Dao.super.update(o);
    }

    @Override
    public void delete(Serializable id) {
        Session s = SessionFactoryUtil.getSession();
        Transaction tx = s.beginTransaction();
        try {
            ChinookAlbum a = this.findOne(id);
            if (a != null) {
                s.delete(a);
            } else {
                return;
            }
            tx.commit();
        } catch (HibernateException ex) {
            ex.printStackTrace();
            tx.rollback();
        } finally {
            s.close();
        }
    }
}
