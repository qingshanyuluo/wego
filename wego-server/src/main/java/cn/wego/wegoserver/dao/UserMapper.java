package cn.wego.wegoserver.dao;

import cn.wego.wegoserver.entity.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * 用户管理mapper
 *
 * @author Trey
 * @since 2020/9/25
 */

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO student (name,password,clazz,student_id,qq_number,email,self_introduction) VALUES ('${name}' , '${password}' , '${clazz}' , '${studentId}' , '${qqNumber}' , '${email}', '${selfIntroduction}')")
    void register(Student student);

    @Select("SELECT id FROM student WHERE student_id = '${studentId}'")
    Integer getId(String studentId);
}
