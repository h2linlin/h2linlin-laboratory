package note.mqprocess;

//import com.alibaba.fastjson.JSON;
//import com.alibaba.fastjson.JSONObject;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.amqp.rabbit.annotation.RabbitListener;
//import org.springframework.stereotype.Component;
//import org.springframework.util.StopWatch;

import javax.annotation.Resource;

/**
 * @Desc 消息消费者。DC消息消费总入口
 * @Author wuzh
 * @Date 2021/1/26
 */
//@Slf4j
//@Component
public class MqConsumer {
//    @Resource
//    private MqHandleMap mqHandleMap;
//
//    // 根据消息类型，将消息分发至各个对应的controller处理
//    @RabbitListener(queues = "sz.dc.dman")
//    public void process(String jsonStrMsg) {
//        String resultCode = "失败";
//        final StopWatch sw = new StopWatch();
//        sw.start();
//        try {
//            log.info("========== 收到中台MQ消息：{}", jsonStrMsg);
////            Thread.sleep(100000L);  // TODO 临时注释，提交代码前放开
//
//            // 1.获取消息类型
//            JSONObject jsonObject = JSON.parseObject(jsonStrMsg);
//            DcMsgHeader header = jsonObject.getObject(HEADER_NAME, DcMsgHeader.class);
//            if (header == null) {
//                log.error("^^^^^^^^^^ 消息头为空");
//                return;
//            }
//
//            // 2.根据消息类型匹配对应的消息处理器
//            MqHandle mqHandle = mqHandleMap.getMqHandel(header.getStype());
//            // 没有消息处理器的消息不做处理
//            if (mqHandle == null) {
//                log.info("^^^^^^^^^^ 消息处理器未找到. Msg stype: " + header.getStype());
//                return;
//            }
//
//            // 3.用消息处理器处理消息
//            resultCode = mqHandle.handle(jsonObject) ? "成功" : "失败";
//        } catch (Exception e) {
//            e.printStackTrace();
//            log.error("^^^^^^^^^^ 消息处理异常. e: {}", e);
//        }
//        sw.stop();
//        log.info("========== 消息处理{}。耗时：{}ms", resultCode, sw.getTotalTimeMillis());
//    }
}

