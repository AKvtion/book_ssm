package org.successor.domin;

import lombok.Data;

import java.io.Serializable;

/*
    class(Contribution) 等级信息实体类
    id: 等级类别编号
    lowerLimit: 每种等级最低分数
    upperLimit: 每种等级最高分数
    level_txt： 等级名称
    level_img： 等级标识图片
 */
@Data
public class Contribution implements Serializable{
    private int id;
    private int lowerLimit;
    private int upperLimit;
    private String level_txt;
    private String level_img;

    public Contribution() {
    }

    public Contribution(int id, int lowerLimit, int upperLimit,
                        String level_txt, String level_img) {
        this.id = id;
        this.lowerLimit = lowerLimit;
        this.upperLimit = upperLimit;
        this.level_txt = level_txt;
        this.level_img = level_img;
    }

}
