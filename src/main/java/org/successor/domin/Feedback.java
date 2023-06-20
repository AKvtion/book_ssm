package org.successor.domin;

import lombok.Data;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by ZhangZijian on 2017/4/25.
 */

/*
    class(Feedback) 反馈实体类
    id: 反馈编号
    loginedUser： 反馈用户（已登陆）
    contact： 联系方式
    suggestion： 建议
    postTime： 提交时间
    status: 状态
 */
@Data
public class Feedback implements Serializable {
    private int id;
    private long loginedUser;
    private String contact;
    private String suggestion;
    private Timestamp postTime;
    private int status;


}
