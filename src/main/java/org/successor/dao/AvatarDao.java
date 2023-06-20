package org.successor.dao;

import org.successor.domin.Avatar;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AvatarDao {

    /**
     * 通过头像编号获取图像
     * @param id
     * @return
     */
    Avatar queryById(int id);

    /**
     * 查询所有头像
     * @return
     */
    List<Avatar> queryAll();

    int queryByImgPath(String avatar_img);
}
