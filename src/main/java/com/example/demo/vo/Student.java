package com.example.demo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    /** 学号 */
    private long id;

    private String name;

    private int age;

    /** 年级 */
    private int grade;

    /** 专业 */
    private String major;

    /** 学校 */
    private String school;

}
