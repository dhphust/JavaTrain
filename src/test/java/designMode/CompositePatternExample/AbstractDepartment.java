package designMode.CompositePatternExample;


/**
 * 部门抽象构件类
 */
public interface AbstractDepartment {
    /**
     * 分公司各部门通知
     * @param name 公司名
     */
    void notice(String name);

    /**
     * 添加部门
     * @param department
     */
    default void addDepatment(AbstractDepartment department){}

    /**
     * 删除部门
     * @param department
     */
    default void delDepatment(AbstractDepartment department){}

    /**
     * 获取子部门
     * @param i
     * @return
     */
    default AbstractDepartment getChild(int i) {
        return null;
    }
}
