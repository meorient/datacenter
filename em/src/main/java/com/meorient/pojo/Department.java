package com.meorient.pojo;

import com.meorient.common.pojo.BasePojo;
import lombok.Data;

/**
 * @author sunwanghe
 * @date 2019/4/22 18:20
 */
@Data
public class Department extends BasePojo {

    /** 唯一id */
    private String uId;

    /** 公司id */
    private String companyId;

    /** 部门经理id */
    private Long managerId;

    /** 部门经理姓名 */
    private String managerName;

    /** 部门名称 */
    private String name;

    /** 上级部门id */
    private Long parentId;

    /** 是否拥有被分享权力 */
    private Long shareMark;

}
