package note.mqprocess;

//import lombok.extern.slf4j.Slf4j;
//import note.mqprocess.annotation.DcMqProcessController;
//import note.mqprocess.annotation.DcMqProcessMethod;
//import org.apache.commons.lang3.StringUtils;
//import org.reflections.Reflections;
//import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @Desc 消息处理器字典。用于根据消息头，查找处理这个消息的处理器。
 */
//@Slf4j
//@Component
public class MqHandleMap {
//    // key：消息子类型名称。value：对应的消息处理器。
//    private Map<String, MqHandle> handleMap = new HashMap<>();
//
//    public MqHandleMap() {
//        this.init();
//    }
//
//    // map初始化，根据注解标注的信息，初始化handleMap
//    private void init() {
//        // 1.获取所有含有@DcMqProcessController注解的类
//        Reflections reflections = new Reflections("com.szatc.dman.service.biz.runway.controller.mq");
//        Set<Class<?>> classSet = reflections.getTypesAnnotatedWith(DcMqProcessController.class);
//
//        // 2.获取类中所有含有@DcMqProcessMethod注解的方法，并生成处理器，存入map
//        for (Class clazz : classSet) {
//            Method[] methods = clazz.getMethods();
//            for (Method method : methods) {
//                DcMqProcessMethod dcMqProcessMethod = method.getAnnotation(DcMqProcessMethod.class);
//                if (dcMqProcessMethod == null) {
//                    continue;
//                }
//                // 获取注解上声明的字消息类型
//                String stype = dcMqProcessMethod.value();
//
//                // 判重。一个消息只能用一个方法处理。
//                if (handleMap.get(stype) != null) {
//                    log.error("重复的消息子类型key: " + stype);
//                    throw new RuntimeException("Reduplicative dc msg stype key:" + stype);
//                }
//
//                // 生成该消息对应的处理器
//                MqHandle mqHandle = new MqHandle(clazz, method, method.getParameters());
//                handleMap.put(stype, mqHandle);
//            }
//        }
//        log.info("===== 消息处理器字典初始化完成。MqHandleMapSize:{}", handleMap.size());
//    }
//
//    /**
//     * 根据消息头里的子消息类型获取对应的消息处理器
//     */
//    MqHandle getMqHandel(String sType) {
//        if (StringUtils.isBlank(sType)) {
//            return null;
//        }
//
//        return handleMap.get(sType.trim());
//    }

}
