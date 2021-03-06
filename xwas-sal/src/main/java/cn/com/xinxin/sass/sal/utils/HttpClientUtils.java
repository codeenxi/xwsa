package cn.com.xinxin.sass.sal.utils;


/*
 *
 * Copyright 2020 www.xinxindigits.com
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software
 * and associated documentation files (the "Software"),to deal in the Software without restriction,
 * including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense,
 * and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice
 * shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED,
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 *
 * Redistribution and selling copies of the software are prohibited, only if the authorization from xinxin digits
 * was obtained.Neither the name of the xinxin digits; nor the names of its contributors may be used to
 * endorse or promote products derived from this software without specific prior written permission.
 *
 */

import cn.com.xinxin.sass.common.enums.SassBizResultCodeEnum;
import com.xinxinfinance.commons.exception.BusinessException;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: liuhangzhou
 * @created: 2020/4/15.
 * @updater:
 * @description: http请求工具类
 */
public class HttpClientUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(HttpClientUtils.class);

    /**
     * 发送post请求
     *
     * @param urlParam url
     * @param message 消息
     * @return 响应结果
     */
    public static String sendPost(String urlParam, String message) throws IOException {
        // 创建httpClient实例对象
        HttpClient httpClient = new HttpClient();
        // 设置httpClient连接主机服务器超时时间：15000毫秒
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(60000);
        // 创建post请求方法实例对象
        PostMethod postMethod = new PostMethod(urlParam);
        // 设置post请求超时时间
        postMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);
        //设置post请求头
        postMethod.addRequestHeader("Content-Type", "application/json");
        //设置post请求内容
        postMethod.setRequestEntity(new StringRequestEntity(message ,"application/json" ,"UTF-8"));

        String result;
        try {
            httpClient.executeMethod(postMethod);
            result = postMethod.getResponseBodyAsString();
        } catch (IOException e) {
            LOGGER.error("发送post请求异常", e);
            throw new BusinessException(SassBizResultCodeEnum.FAIL, "发送post请求异常");
        }

        postMethod.releaseConnection();

        return result;
    }

    /**
     * 发送get请求
     *
     * @param urlParam url
     * @return 响应结果
     */
    public static String sendGet(String urlParam) {
        // 创建httpClient实例对象
        HttpClient httpClient = new HttpClient();
        // 设置httpClient连接主机服务器超时时间：15000毫秒
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(60000);
        // 创建GET请求方法实例对象
        GetMethod getMethod = new GetMethod(urlParam);
        // 设置get请求超时时间
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);
        //设置get请求头
        getMethod.addRequestHeader("Content-Type", "application/json");

        String result;

        try {
            httpClient.executeMethod(getMethod);
            result = getMethod.getResponseBodyAsString();
        } catch (IOException e) {
            LOGGER.error("发送get请求异常", e);
            throw new BusinessException(SassBizResultCodeEnum.FAIL, "发送get请求异常");
        }

        getMethod.releaseConnection();
        return result;
    }

    /**
     * 批量发送get请求
     * @param urlParamS urls
     * @return 对应的响应
     */
    public static List<String> sendGetList(List<String> urlParamS) {
        // 创建httpClient实例对象
        HttpClient httpClient = new HttpClient();
        // 设置httpClient连接主机服务器超时时间：15000毫秒
        httpClient.getHttpConnectionManager().getParams().setConnectionTimeout(30000);

        List<String> results = new ArrayList<>();

        // 创建GET请求方法实例对象
        GetMethod getMethod = new GetMethod();
        // 设置get请求超时时间
        getMethod.getParams().setParameter(HttpMethodParams.SO_TIMEOUT, 60000);
        //设置get请求头
        getMethod.addRequestHeader("Content-Type", "application/json");

        urlParamS.forEach(url -> {
            try {
                getMethod.setURI(new URI(url, true, getMethod.getParams().getUriCharset()));
                httpClient.executeMethod(getMethod);
                results.add(getMethod.getResponseBodyAsString());
            } catch (IOException e) {
                LOGGER.error("发送get请求异常", e);
                throw new BusinessException(SassBizResultCodeEnum.FAIL, "发送get请求异常");
            }
        });

        getMethod.releaseConnection();
        return results;
    }
}
