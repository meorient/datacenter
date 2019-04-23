package com.meorient.pojo;

import com.meorient.common.pojo.BasePojo;
import lombok.Data;

/**
 * @author sunwanghe
 * @date 2019/4/22 18:20
 */
@Data
public class User extends BasePojo {

    /** 唯一id */
    private String uId;

    /** 公司id */
    private Long companyId;

    /** 部门id */
    private Long departmentId;

    /** 上级id */
    private Long parentId;

    /** 关联企业微信id */
    private String wechatUserId;

    /** 用户姓名 */
    private String name;

    /** 用户密码*/
    private String password;

    /** 电话号码 */
    private String mobile;

    /** 电子邮件 */
    private String email;

    /** 是否离职 */
    private Integer isResigned;

}
