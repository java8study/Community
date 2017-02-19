package kr.co.jr.community.main.dao;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * Created by LeeJongRyul on 2017-02-14.
 */

@Repository
public class MainDaoImpl implements MainDao {

    @Resource(name = "sqlSession")
    SqlSessionTemplate sqlSession;

    public String getTest(){
        return sqlSession.selectOne("main.test");
    }
}
