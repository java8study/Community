package kr.co.jr.community.main.dao;

import com.mysema.query.jpa.impl.JPAQuery;
import com.mysema.query.types.Projections;
import kr.co.jr.community.main.entity.QTest;
import kr.co.jr.community.main.entity.Test;
import kr.co.jr.community.main.entity.TestGroup;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by LeeJongRyul on 2017-02-13.
 */
public class MainRepositoryImpl extends QueryDslRepositorySupport implements MainRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    @PersistenceContext
    public void setEntityManager(EntityManager entityManager) {
        super.setEntityManager(entityManager);
    }

    public MainRepositoryImpl() {
        super(MainRepositoryImpl.class);
    }

    public List<TestGroup> getGroupBy() {
        QTest entity = QTest.test;

        JPAQuery query = new JPAQuery(entityManager);
        List<TestGroup> list = query.from(entity)
                .where(entity.name.isNotNull())
                .groupBy(entity.name)
                .list(Projections.bean(TestGroup.class, entity.name.as("name"), entity.name.count().as("summing")));

        return list;
    }
}
