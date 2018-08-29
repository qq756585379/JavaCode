package com.yang.pojo;

import lombok.Data;

import java.util.List;

@Data
public class StudentMajor {

    private Integer id;
    private String mcode;
    private String mname;
    private List<Student> students;

}
