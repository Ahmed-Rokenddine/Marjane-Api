package dao.Impl;

import java.util.List;

import Entity.HistoryEntity;
import dao.AbstractDao;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class HistoryDaoImpl implements AbstractDao <HistoryEntity> {
    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public int save(HistoryEntity entity) {
        return 0;
    }

    @Override
    public HistoryEntity get(int id) {
        return sessionFactory.getCurrentSession().get(HistoryEntity.class, id);
    }

    @Override
    public List<HistoryEntity> list() {
        List<HistoryEntity> list = sessionFactory.getCurrentSession().createQuery("from HistoryEntity").list();
        return list;
    }

    @Override
    public void update(int id, HistoryEntity entity) {

    }

    @Override
    public void delete(int id) {

    }


}
