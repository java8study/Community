package kr.co.jr.community.main.dao;

import kr.co.jr.community.main.entity.Test;
import kr.co.jr.community.main.entity.TestGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/**
 * Created by LeeJongRyul on 2017-01-29.
 */
public interface MainRepository extends JpaRepository<Test, Long>, MainRepositoryCustom {

//    @Query(value = "select new kr.co.jr.community.main.entity.TestGroup(m.name, sum(m)) from Test m group by m.name")
//    List<TestGroup> findTestGroupSum();
}
