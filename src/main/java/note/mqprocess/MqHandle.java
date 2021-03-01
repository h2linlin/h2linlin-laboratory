package note.mqprocess;

//import com.alibaba.fastjson.JSONObject;
//import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @Desc 消息处理器。
 *       根据消息类型，调用对应Bean的对应方法方法处理。
 *       Bean和方法，由注解标出。
 */
//@Slf4j
public class MqHandle {
//    private final Class clazz;
//    private final Method method;
//    private final DcMqParam[] params;
//
//
//    /**
//     * @param mqControllerClass 类型
//     * @param mqMethod  方法
//     * @param params    方法入参
//     */
//    public MqHandle(Class mqControllerClass, Method mqMethod, Parameter[] params) {
//        this.clazz = mqControllerClass;
//        this.method = mqMethod;
//        this.params = parameter2DcMqParam(params);
//    }
//
//    // 原生的参数类型转换为自定义的中台队列参数类型
//    private DcMqParam[] parameter2DcMqParam(Parameter[] params) {
//        DcMqParam[] dcMqParams = new DcMqParam[params.length];
//        for (int i = 0; i < params.length; i++) {
//            dcMqParams[i] = new DcMqParam(params[i]);
//        }
//        return dcMqParams;
//    }
//
//    // 处理消息
//    public boolean handle(JSONObject jsonObject) throws Exception {
//        // 1.处理的controller Bean
//        Object controller = SpringContextUtil.getBean(clazz);
//
//        // 2.入参对象
//        Object[] objs = new Object[params.length];
//        for (int i = 0; i < params.length; i++) {
//            objs[i] = params[i].jsonObj2Object(jsonObject);
//        }
//
//        // 3.方法调用
//        Object result = method.invoke(controller, objs);
//        if(result instanceof Boolean) {
//            return (boolean)result;
//        }
//        return true;
//    }
//
//    /**
//     * 中台的入参类型
//     */
//    private static class DcMqParam {
//        // 参数声明类型
//        private final Class type;
//        // 参数实际类型
//        private Class actualType;
//        // 参数名称
//        private String name;
//
//        DcMqParam(Parameter parameter) {
//            this.type = parameter.getType();
//            this.name = parameter.getName();
//
//            // 如果入参是列表类型，则取到列表泛型中的实际类型
//            if (!this.type.equals(List.class)) {
//                return;
//            }
//            // 获取列表泛型类型对象
//            ParameterizedType p = (ParameterizedType)parameter.getParameterizedType();
//            // 列表泛型只有一个泛型参数，所以取第一个就OK
//            actualType = (Class) p.getActualTypeArguments()[0];
//        }
//
//        // 将入参的jsonObject转换为实际的对象
//        Object jsonObj2Object(JSONObject jsonObject){
//            // 普通对象
//            if (actualType == null) {
//                return jsonObject.getObject(name, type);
//            }
//            // 列表对象
//            return jsonObject.getJSONArray(name).toJavaList(actualType);
//        }
//    }
}
