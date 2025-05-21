package com.jsun.teacher.model;

import com.jsun.teacher.enums.DayOfWeek;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

@Data
@Document(collection = "lessions")
public class Lession {
    @Id
    private String id;

    @NotNull(message = "星期几不能为空")
    private DayOfWeek dayOfWeek;

    @NotBlank(message = "科目不能为空")
    private String subject;

    @NotBlank(message = "教师不能为空")
    private String teacher;

    @NotBlank(message = "时间不能为空")
    private String time;

    @NotNull(message = "日期不能为空")
    private Date date;

    @NotBlank(message = "创建人不能为空")
    private String createdBy;

    @NotNull(message = "创建时间不能为空")
    private Date createdOn;

    @NotBlank(message = "更新人不能为空")
    private String updatedBy;

    @NotNull(message = "更新时间不能为空")
    private Date updatedOn;
} 