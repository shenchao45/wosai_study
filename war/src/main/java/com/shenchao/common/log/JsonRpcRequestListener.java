package com.shenchao.common.log;

import com.fasterxml.jackson.databind.node.ObjectNode;
import com.googlecode.jsonrpc4j.JsonRpcClient;
import com.googlecode.jsonrpc4j.JsonRpcHttpClient;
import com.shenchao.util.SpringWebUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

public class JsonRpcRequestListener implements JsonRpcClient.RequestListener {
    @Override
    public void onBeforeRequestSent(JsonRpcClient jsonRpcClient, ObjectNode objectNode) {
        if (jsonRpcClient instanceof JsonRpcHttpClient) {
            ((JsonRpcHttpClient) jsonRpcClient).setHeaders(getHeaders());
        }
    }

    @Override
    public void onBeforeResponseProcessed(JsonRpcClient jsonRpcClient, ObjectNode objectNode) {

    }
    private String projectName;

    public Map<String, String> getHeaders() {
        // 无登录态系统或中间系统写法
        HttpServletRequest request = SpringWebUtil.getCurrentRequest();
        Map<String, String> header = JsonRpcCallUtil.getCallHeaderMapFromRequest(request);
        JsonRpcCallUtil.appendCallHeaderMap(header, this.projectName);

        return header;

        // 初始请求发起系统写法, userId, userName从登录态中获取
        // JsonRpcCallUtil.buildCallHeaderMap(this.projectName, userId, userName);
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }
}
