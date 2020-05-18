package cn.com.xinxin.sass.repository.dao;

import cn.com.xinxin.sass.repository.model.GroupChatDO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GroupChatDOMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_chat
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_chat
     *
     * @mbg.generated
     */
    int insert(GroupChatDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_chat
     *
     * @mbg.generated
     */
    int insertSelective(GroupChatDO record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_chat
     *
     * @mbg.generated
     */
    GroupChatDO selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_chat
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(GroupChatDO record);



    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table group_chat
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(GroupChatDO record);

    /**
     * 通过群聊id查询群信息
     * @param chatIdS 群id
     * @return 群信息
     */
    List<GroupChatDO> selectByChatIdS(@Param(value = "chatIdS") List<String> chatIdS);

    /**
     * 批量插入记录
     * @param groupChatDOS 记录
     * @return 成功插入记录的条数
     */
    int insertBatch(@Param(value = "groupChatDOS") List<GroupChatDO> groupChatDOS);

    /**
     * 批量更新记录
     * @param groupChatDOS 记录
     * @return 成功更新记录的条数
     */
    int updateBatch(@Param(value = "groupChatDOS") List<GroupChatDO> groupChatDOS);

    /**
     * 通过chatId查询记录
     * @param chatId 群id
     * @return 记录
     */
    GroupChatDO selectByChatId(@Param(value = "chatId") String chatId);
}