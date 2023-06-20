package org.successor.domin;

import lombok.Data;

import java.io.Serializable;

/*
    class(Avatar) 用户头像实体类
    id:
    avatar_txt: 头像名称
    avatar_img: 头像地址
 */

@Data
public class Avatar implements Serializable{
    private int id;
    private String avatar_txt;
    private String avatar_img;

    public Avatar() {
    }

    public Avatar(int id, String avatar_txt, String avatar_img) {
        this.id = id;
        this.avatar_txt = avatar_txt;
        this.avatar_img = avatar_img;
    }


}
