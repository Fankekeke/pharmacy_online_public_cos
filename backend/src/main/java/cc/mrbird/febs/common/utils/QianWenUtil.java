package cc.mrbird.febs.common.utils;

import cn.hutool.core.io.IoUtil;
import com.alibaba.dashscope.aigc.conversation.Conversation;
import com.alibaba.dashscope.aigc.conversation.ConversationParam;
import com.alibaba.dashscope.aigc.conversation.ConversationResult;
import com.alibaba.dashscope.aigc.imagesynthesis.ImageSynthesis;
import com.alibaba.dashscope.aigc.imagesynthesis.ImageSynthesisParam;
import com.alibaba.dashscope.aigc.imagesynthesis.ImageSynthesisResult;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;
import com.google.common.base.Throwables;
import io.reactivex.Flowable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;
import org.springframework.beans.factory.annotation.Value;

import java.io.IOException;
import java.net.URL;
import java.util.Base64;


/**
 * @author FanK
 **/
@Slf4j
public class QianWenUtil {

    /**
     * 全量输出
     * @param prompt
     * @return
     */
    public static String getAnswer(String prompt){
        try {
            Conversation conversation = new Conversation();

            ConversationParam param = ConversationParam
                    .builder()
                    .model(Conversation.Models.QWEN_TURBO)
                    .apiKey("sk-ebb4821588054a66aa1951d7f239f77c")
                    .prompt(prompt)
                    .build();
            ConversationResult result = conversation.call(param);
            return result.getOutput().getText();
        } catch (ApiException | NoApiKeyException | InputRequiredException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * 增量输出-打字机效果
     * @param sseEmitter
     * @param prompt
     */
    public static void getFlowAnswer(SseEmitter sseEmitter,String prompt){
        try {
            Conversation conversation = new Conversation();
            ConversationParam param = ConversationParam
                    .builder()
                    .model(Conversation.Models.QWEN_MAX)
                    .apiKey("sk-ebb4821588054a66aa1951d7f239f77c")
                    .prompt(prompt)
                    .incrementalOutput(Boolean.TRUE)
                    .build();
            Flowable<ConversationResult> result = conversation.streamCall(param);
            result.blockingForEach(message -> {
                //log.info("message====>{}", JSON.toJSONString(message));
                String outPut = message.getOutput().getText();
                if (("stop").equals(message.getOutput().getFinishReason())) {
                    sseEmitter.send("DONE");
                }
                else {
                    outPut = outPut.replaceAll("\\n", "</br>");
                    sseEmitter.send(outPut);
                }
            });
        } catch (ApiException | NoApiKeyException | InputRequiredException e) {
            log.error("===>发送流式结果ERROR-{}", Throwables.getStackTraceAsString(e));
        }
        finally {
            //结束推流
            //sseEmitter.complete();
        }
    }

    /**
     * 生成图片的base64编码
     * @param prompt
     * @return
     */
    public static String getImageBase64(String prompt){
        try {
            ImageSynthesis is = new ImageSynthesis();
            ImageSynthesisParam param =
                    ImageSynthesisParam.builder()
                            .model(ImageSynthesis.Models.WANX_V1)
                            .n(1)
                            .size("1024*1024")
                            .apiKey("sk-ebb4821588054a66aa1951d7f239f77c")
                            .prompt(prompt)
                            .build();

            ImageSynthesisResult result = is.call(param);
            String url = result.getOutput().getResults().get(0).get("url");
            byte[] urlByteArray = IoUtil.readBytes(new URL(url).openStream());
            String base64Encoded = Base64.getEncoder().encodeToString(urlByteArray);
            log.info("===>生成图片完成-RUL-{}",url);
            return base64Encoded;
        } catch (NoApiKeyException | IOException e) {
            log.error("===>生成图片失败-ERROR-{}", Throwables.getStackTraceAsString(e));
        }
        return null;
    }
}
