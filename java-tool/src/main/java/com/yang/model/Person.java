package com.yang.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Person extends BaseModel {
    private String name;
    private Integer age;
    private Integer sex;
}
