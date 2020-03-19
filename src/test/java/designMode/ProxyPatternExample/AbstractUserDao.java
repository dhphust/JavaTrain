package designMode.ProxyPatternExample;

/**
 * 抽象用户主题
 */
public interface AbstractUserDao {
    /**
     * 查询指定id的用户信息
     * @param userId
     * @return
     */
    Boolean findUserById(String userId);
}
