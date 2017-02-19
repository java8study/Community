package kr.co.jr.community.main.service;

import kr.co.jr.community.main.dao.MainRepository;
import kr.co.jr.community.main.entity.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by LeeJongRyul on 2017-01-29.
 */
public interface MainService {

    List<Test> getTestInfo();

    void insertTestInfo();

    List<Test> getGrouppingTest();
}
