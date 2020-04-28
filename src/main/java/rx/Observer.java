package rx;

/**
 * Created by 1 on 2017/12/21 0021.
 */

public interface Observer {
    /**
     * 更新接口
     * @param state    更新的状态
     */
    public void update(String state);
}
