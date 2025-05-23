package cc.mrbird.febs.cos.service;

import cc.mrbird.febs.cos.entity.ChatInfo;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;

import java.util.LinkedHashMap;
import java.util.List;

/**
 * 沟通信息 service层
 *
 * @author FanK
 */
public interface IChatInfoService extends IService<ChatInfo> {

    /**
     * 分页获取沟通信息
     *
     * @param page     分页对象
     * @param chatInfo 沟通信息
     * @return 结果
     */
    IPage<LinkedHashMap<String, Object>> selectChatPage(Page<ChatInfo> page, ChatInfo chatInfo);

    /**
     * 根据用户编号获取联系人
     *
     * @param userCode 用户编号
     * @param flag     1.用户 2.企业
     * @return 结果
     */
    List<LinkedHashMap<String, Object>> selectContactPerson(String userCode, Integer flag);

    /**
     * 查询聊天记录
     *
     * @param expertCode     用户编号
     * @param enterpriseCode 企业编号
     * @return 结果
     */
    List<LinkedHashMap<String, Object>> selectChatList(String expertCode, String enterpriseCode);
}
