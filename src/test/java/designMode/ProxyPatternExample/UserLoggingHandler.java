package designMode.ProxyPatternExample;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 插入查询用户时间、结果log
 */
public class UserLoggingHandler implements InvocationHandler {
    private Log log = LogFactory.getLog(this.getClass());
    private Object target;

    public UserLoggingHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //方法执行前，打印调用时间
        log.info("查询时间：" + selectTime());
        Object result = method.invoke(target,args);
        //方法执行后，打印结果
        log.info("查询结果：" + result);
        return result;
    }

    private String selectTime() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        return dtf.format(now);
    }

    public static Object createProxy(Object target){
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new UserLoggingHandler(target));
    }
}
