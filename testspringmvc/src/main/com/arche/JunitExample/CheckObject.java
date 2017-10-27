package arche.JunitExample;

/**
 * Created by ZhangGuozhao on 2017/9/29.
 */
public class CheckObject {
    private static CheckObject instance;


    public CheckObject() {
    }

//线程安全的单例模式写法
    public static synchronized CheckObject getInstance() {
        if (instance == null) {
             instance = new CheckObject();
        }
        return instance;
    }

    public boolean getBoolean() {
        return true;
    }

    public Object getObject() {
        Object o = null;
        return o;
    }
}
