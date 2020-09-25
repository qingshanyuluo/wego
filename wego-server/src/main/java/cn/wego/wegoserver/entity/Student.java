package cn.wego.wegoserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生实体类
 *
 * @author Trey
 * @since 2020/9/25
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private Integer id;
    private String name;
    private String password;
    private String clazz;
    private String studentId;
    private String qqNumber;
    private String email;
    private String selfIntroduction;

    public Student(String name, String password, String clazz, String studentId, String qqNumber, String email, String selfIntroduction) {
        this.name = name;
        this.password = password;
        this.clazz = clazz;
        this.studentId = studentId;
        this.qqNumber = qqNumber;
        this.email = email;
        this.selfIntroduction = selfIntroduction;
    }
}
