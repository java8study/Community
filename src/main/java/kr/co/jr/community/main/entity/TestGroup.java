package kr.co.jr.community.main.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Created by LeeJongRyul on 2017-02-12.
 */
@Getter
@Setter
public class TestGroup {

//    public TestGroup (String name, long summing){
//        this.name = name;
//        this.summing = summing;
//    }

    private String name;

    private long summing;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
