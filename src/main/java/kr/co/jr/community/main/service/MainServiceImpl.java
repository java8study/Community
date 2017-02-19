package kr.co.jr.community.main.service;

import kr.co.jr.community.main.dao.MainDao;
import kr.co.jr.community.main.dao.MainRepository;
import kr.co.jr.community.main.entity.Test;
import kr.co.jr.community.main.entity.TestGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by LeeJongRyul on 2017-02-12.
 */

@Slf4j
@Service
public class MainServiceImpl implements MainService {

    @Autowired
    MainRepository mainRepository;

    @Autowired
    MainDao mainDao;

    public List<Test> getTestInfo() {
        mainRepository.findOne(1L);
        return mainRepository.findAll();
    }

    public void insertTestInfo() {
        List<Test> list = new ArrayList<Test>();
        Test test1 = new Test();
        test1.setName("test5");
        Test test2 = new Test();
        test2.setName("test6");
        Test test3 = new Test();
        test3.setId(2L);
        test3.setName("test222");
        list.add(test1);
        list.add(test2);
        list.add(test3);

        mainRepository.save(list);
    }

    public List<Test> getGrouppingTest() {
//        List<TestGroup> list = mainRepository.findTestGroupSum();
        List<TestGroup> list = mainRepository.getGroupBy();
        String str = mainDao.getTest();
        log.debug("getTest : {}", str);
        for(TestGroup test : list){
            System.out.println(test);
        }
        return null;
    }

}
