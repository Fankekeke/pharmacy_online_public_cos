package cc.mrbird.febs.cos.service.impl;

import cc.mrbird.febs.common.utils.QianWenUtil;
import cc.mrbird.febs.cos.service.SseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Service
public class SseServiceImpl implements SseService {

    private static final Map<String, SseEmitter> SSE_CACHE = new ConcurrentHashMap<>();


    @Override
    public SseEmitter getConn(String clientId) {
        final SseEmitter sseEmitter = SSE_CACHE.get(clientId);

        if (sseEmitter != null) {
            return sseEmitter;
        } else {
            // 设置连接超时时间，需要配合配置项 spring.mvc.async.request-timeout: 600000 一起使用
            final SseEmitter emitter = new SseEmitter(3600*1000L);
            // 注册超时回调，超时后触发
            emitter.onTimeout(() -> {
                log.info("连接已超时，正准备关闭，clientId = "+clientId);
                SSE_CACHE.remove(clientId);
            });
            //处理完回调，调用 emitter.complete() 触发
            emitter.onCompletion(() -> {
                log.info("处理已完成，clientId = "+clientId);
            });
            // 注册异常回调，调用 emitter.completeWithError() 触发
            emitter.onError(throwable -> {
                log.info("连接已异常，正准备关闭，clientId = "+ clientId+"==>"+ throwable);
                SSE_CACHE.remove(clientId);
            });

            SSE_CACHE.put(clientId, emitter);
            return emitter;
        }
    }

    /**
     * 模拟类似于 chatGPT 的流式推送回答
     * @param clientId 客户端 id
     */
    @Override
    public void send(String clientId, String message) {
        final SseEmitter emitter = SSE_CACHE.get(clientId);
        if (Objects.nonNull(emitter)) {
            QianWenUtil.getFlowAnswer(emitter,message);
        }
        else{
            log.error("请刷新页面后重试");
        }

    }

    @Override
    public void closeConn(String clientId) {
        final SseEmitter sseEmitter = SSE_CACHE.get(clientId);
        if (sseEmitter != null) {
            sseEmitter.complete();
        }
    }

    @Override
    public String img(String message) {
        return QianWenUtil.getImageBase64(message);
    }

}
