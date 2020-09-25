package cn.wego.wegoserver.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 注册状态码
 *
 * @author Trey
 * @since 2020/9/25
 */

@Data
@AllArgsConstructor
public class Status {

    private Integer code;
    private String message;

}
