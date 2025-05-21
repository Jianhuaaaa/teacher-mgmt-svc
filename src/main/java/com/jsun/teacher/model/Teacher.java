package com.jsun.teacher.model;

import com.jsun.teacher.enums.Gender;
import com.jsun.teacher.enums.Level;
import com.jsun.teacher.enums.Role;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.util.Date;
import java.util.List;

@Data
@Document(collection = "teachers")
public class Teacher {
    @Id
    private String id;

    @NotBlank(message = "姓名不能为空")
    private String name;

    @NotNull(message = "性别不能为空")
    private Gender gender;

    @NotNull(message = "年龄不能为空")
    @Positive(message = "年龄必须为正数")
    private Integer age;

    @NotNull(message = "科目不能为空")
    private List<String> subject;

    @NotBlank(message = "学校不能为空")
    private String school;

    private String education;

    private Level level;

    private Integer serviceYears;

    @NotNull(message = "基本工资不能为空")
    @Positive(message = "基本工资必须为正数")
    private Double baseSalary;

    @NotNull(message = "课时费不能为空")
    @Positive(message = "课时费必须为正数")
    private Double subjectFee;

    private Boolean headTeacher;

    @NotNull(message = "总工资不能为空")
    @Positive(message = "总工资必须为正数")
    private Double pay;

    private Role role;

    @NotBlank(message = "创建人不能为空")
    private String createdBy;

    @NotNull(message = "创建时间不能为空")
    private Date createdOn;

    @NotBlank(message = "更新人不能为空")
    private String updatedBy;

    @NotNull(message = "更新时间不能为空")
    private Date updatedOn;
} 