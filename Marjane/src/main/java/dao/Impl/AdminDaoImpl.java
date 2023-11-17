package dao.Impl;

import java.util.List;


import Entity.AdminEntity;
import dao.AbstractDao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class AdminDaoImpl implements AbstractDao <AdminEntity> {
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public int save(AdminEntity admin) {

        System.out.println(admin.getEmail());
        sessionFactory.getCurrentSession().save(admin);
        return admin.getId();

    }

    @Override
    public AdminEntity get(int id) {
        return sessionFactory.getCurrentSession().get(AdminEntity.class, id);
    }

    @Override
    public List<AdminEntity> list() {
        List<AdminEntity> list = sessionFactory.getCurrentSession().createQuery("from AdminEntity ").list();
        return list;
    }

    @Override
    public void update(int id, AdminEntity admin) {
        Session session = sessionFactory.getCurrentSession();
        AdminEntity admin2 = session.byId(AdminEntity.class).load(id);
        admin2.setEmail(admin.getEmail());
        admin2.setFullname(admin.getFullname());
        admin2.setVille(admin.getVille());
        admin2.setPassword(admin.getPassword());
        session.flush();
    }

    @Override
    public void delete(int id) {
        AdminEntity admin = sessionFactory.getCurrentSession().byId(AdminEntity.class).load(id);
        sessionFactory.getCurrentSession().delete(admin);

    }


}