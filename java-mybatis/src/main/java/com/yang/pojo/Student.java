package com.yang.pojo;

import lombok.Data;

@Data
public class Student {

    private Integer sno;
    private String sname;
    private String ssex;
    private Integer sclass;
    private StudentMajor studentmajor;

}
