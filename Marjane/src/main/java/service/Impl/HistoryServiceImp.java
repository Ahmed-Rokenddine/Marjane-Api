package service.Impl;


import Entity.HistoryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import dao.AbstractDao;
import service.AbstractService;

import java.util.List;

@Service
@Transactional
public class HistoryServiceImp implements AbstractService <HistoryEntity> {
    @Qualifier("historyDaoImpl")
    @Autowired
    private AbstractDao historyDao;
    @Override
    public int save(HistoryEntity entity) {
        return 0;
    }

    @Override
    public HistoryEntity get(int id) {
        return (HistoryEntity) historyDao.get(id);
    }

    @Override
    public List<HistoryEntity> list() {
        return historyDao.list();
    }

    @Override
    public void update(int id, HistoryEntity entity) {

    }

    @Override
    public void delete(int id) {

    }
}
