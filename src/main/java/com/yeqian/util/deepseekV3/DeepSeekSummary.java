package com.yeqian.util.deepseekV3;

import com.alibaba.dashscope.app.*;
import com.alibaba.dashscope.exception.ApiException;
import com.alibaba.dashscope.exception.InputRequiredException;
import com.alibaba.dashscope.exception.NoApiKeyException;

public class DeepSeekSummary {
    public static String appCall(String content) throws ApiException, NoApiKeyException, InputRequiredException {
        ApplicationParam param = ApplicationParam.builder()
                //连接环境变量中的API密钥
                .apiKey(System.getenv("DASHSCOPE_API_KEY"))
                //连接应用id
                .appId("d98a6d33810e4e5994cbaee4594fe6ca")
                //对话
                .prompt("简单总结以下内容：" + content)
                .build();

        Application application = new Application();
        ApplicationResult result = application.call(param);

        System.out.printf("text: %s\n", result.getOutput().getText());
        return "总结如下：" + result.getOutput().getText();
    }

//    public static void main(String[] args) {
//        try {
//            appCall();
//        } catch (ApiException | NoApiKeyException | InputRequiredException e) {
//            System.err.println("message："+e.getMessage());
//            System.out.println("请参考文档：https://help.aliyun.com/zh/model-studio/developer-reference/error-code");
//        }
//        System.exit(0);
//    }
}