package enums;

import enums.inter.Behaviour;

/**
 * @author wangyong
 */

public enum Colors implements Behaviour {
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLOw("黄色", 4);
    /**
     * 成员变量
     */
    private String name;
    private int index;

    /**
     * 构造方法
     *
     * @param name
     * @param index
     * @return
     */
    Colors(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法
    public static String getName(int index) {
        for (Colors c : Colors.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    // get set 方法
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return this.index + "_" + this.name;
    }

    //接口方法
    @Override
    public String getInfo() {
        return this.name;
    }

    //接口方法
    @Override
    public void print() {
        System.out.println(toString());
    }
}
