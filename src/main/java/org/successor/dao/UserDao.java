package org.successor.dao;

import org.successor.domin.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserDao {

    /**
     * 通过id查找用户
     *
     * @param id
     * @return
     */
    User queryById(long id);

    // 通过邮箱查找用户
    User queryByMail(String email);

    /**
     * 通过用户名和密码查询用户信息
     *
     * @param userCode
     * @param passwordMd5
     * @return User
     */
    User queryByLogin(@Param("userCode") String userCode,
                             @Param("userPassword") String userPassword);

    /**
     * 查询用户名是否存在
     *
     * @param userCode
     * @return int
     */
    int queryByUserCode(String userCode);

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    int addUser(User user);

    int updateUserPassword(@Param("id") long id,
                           @Param("userPassword") String userPassword);

    int updateUserContribution(@Param("addValue") int addValue,
                               @Param("id") long id);

    int updateUserInfo(User user);

    List<User> queryUserByContribution();

    int queryUserNumber();

    int queryUserNumberByWeek();

    int queryUserNumberByMonth();

    int deleteUser(long id);

    List<User> queryUserByUserName(String userName);

}
