package com.shenchao.constant;

import com.shenchao.exception.CommonConfigException;
import org.springframework.util.StringUtils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 系统常量.
 * 说明：
 * 此文件中已存在的常量不可进行修改，会影响到rpc接口异常码.
 * 系统名称和系统编码不可重复.
 * 在不修改本类的情况下可以通过addProject(String projectName, int projectCode)方法添加系统.
 */
public class ProjectConstant {

    // 2.0部分系统
    public static final String CORE_BUSINESS = "core-business";
    public static final int CORE_BUSINESS_CODE = 0; // 为了不改变core-business rpc 接口异常编码

    public static final String CORE_API = "core-api";
    public static final int CORE_API_CODE = 10;
    public static final String UPAY_GATEWAY = "upay-gateway";
    public static final int UPAY_GATEWAY_CODE = 11;
    public static final String UPAY_WALLET = "upay-wallet";
    public static final int UPAY_WALLET_CODE = 12;
    public static final String UPAY_QRCODE = "upay-qrcode";
    public static final int UPAY_QRCODE_CODE = 13;
    public static final String UPAY_MEMBER = "upay-member";
    public static final int UPAY_MEMBER_CODE = 14;
    public static final String UPAY_SIDE = "upay-side";
    public static final int UPAY_SIDE_CODE = 15;
    public static final String UPAY_ACTIVITY = "upay-activity";
    public static final int UPAY_ACTIVITY_CODE = 16;
    public static final String UPAY_ACTIVITY_MONITOR = "upay-activity-monitor";
    public static final int UPAY_ACTIVITY_MONITOR_CODE = 17;

    public static final String WEB_PLATFORMS = "web-platforms";
    public static final int WEB_PLATFORMS_CODE = 20;
    public static final String WEB_PLATFORMS_VSP = "web-platforms-vsp";
    public static final int WEB_PLATFORMS_VSP_CODE = 21;
    public static final String WEB_PLATFORMS_SSP = "web-platforms-ssp";
    public static final int WEB_PLATFORMS_SSP_CODE = 22;
    public static final String WEB_PLATFORMS_MSP = "web-platforms-msp";
    public static final int WEB_PLATFORMS_MSP_CODE = 23;
    public static final String WEB_PLATFORMS_OSP = "web-platforms-osp";
    public static final int WEB_PLATFORMS_OSP_CODE = 24;
    public static final String SHOUQIANBA_WITHDRAW_SERVICE = "shouqianba-withdraw-service";
    public static final int SHOUQIANBA_WITHDRAW_SERVICE_CODE = 25;
    public static final String BUSINESS_LOG = "business-log";
    public static final int BUSINESS_LOG_CODE = 26;

    // 其他
    public static final String ALIPAY_AUTHINTO = "alipay-authinto";
    public static final int ALIPAY_AUTHINTO_CODE = 30;
    public static final String TRADE_COPROCESSOR = "trade-coprocessor";
    public static final int TRADE_COPROCESSOR_CODE = 31;
    public static final String SALES_SYSTEM_BACKEND = "sales-system-backend";
    public static final int SALES_SYSTEM_BACKEND_CODE = 32;
    public static final String WEIXIN_OPEN = "weixin-open";
    public static final int WEIXIN_OPEN_CODE = 33;
    public static final String WEIXIN_SERVICE = "weixin-service";
    public static final int WEIXIN_SERVICE_CODE = 34;
    public static final String LOAN_PROXY = "loan-proxy";
    public static final int LOAN_PROXY_CODE = 35;
    public static final String MERCHANT_CONTRACT_SERVICE = "merchant-contract-service";
    public static final int MERCHANT_CONTRACT_SERVICE_CODE = 36;

    // 1.0部分系统
    public static final String BACKEND_UPAY = "backend-upay";
    public static final int BACKEND_UPAY_CODE = 40;
    public static final String UPAY_WEB_BACKEND = "upay-web-backend";
    public static final int UPAY_WEB_BACKEND_CODE = 41;
    public static final String MARKETING_SERVICE = "marketing-service";
    public static final int MARKETING_SERVICE_CODE = 42;


    public static final String UPAY_TRANSACTION = "upay-transaction";
    public static final int UPAY_TRANSACTION_CODE = 43;

    public static final String UNKNOWN = "unknown";
    public static final int UNKNOWN_CODE = 99;

    /**
     * 项目名映射编码Map.
     */
    public static final Map<String, Integer> CODES_MAP = new LinkedHashMap<String, Integer>() {{
        put(UPAY_TRANSACTION, UPAY_TRANSACTION_CODE);
        put(CORE_BUSINESS, CORE_BUSINESS_CODE);
        put(CORE_API, CORE_API_CODE);
        put(UPAY_GATEWAY, UPAY_GATEWAY_CODE);
        put(UPAY_WALLET, UPAY_WALLET_CODE);
        put(UPAY_QRCODE, UPAY_QRCODE_CODE);
        put(UPAY_MEMBER, UPAY_MEMBER_CODE);
        put(UPAY_SIDE, UPAY_SIDE_CODE);
        put(UPAY_ACTIVITY, UPAY_ACTIVITY_CODE);
        put(UPAY_ACTIVITY_MONITOR, UPAY_ACTIVITY_MONITOR_CODE);
        put(WEB_PLATFORMS, WEB_PLATFORMS_CODE);
        put(WEB_PLATFORMS_VSP, WEB_PLATFORMS_VSP_CODE);
        put(WEB_PLATFORMS_SSP, WEB_PLATFORMS_SSP_CODE);
        put(WEB_PLATFORMS_MSP, WEB_PLATFORMS_MSP_CODE);
        put(WEB_PLATFORMS_OSP, WEB_PLATFORMS_OSP_CODE);
        put(SHOUQIANBA_WITHDRAW_SERVICE, SHOUQIANBA_WITHDRAW_SERVICE_CODE);
        put(BUSINESS_LOG, BUSINESS_LOG_CODE);

        put(ALIPAY_AUTHINTO, ALIPAY_AUTHINTO_CODE);
        put(TRADE_COPROCESSOR, TRADE_COPROCESSOR_CODE);
        put(SALES_SYSTEM_BACKEND, SALES_SYSTEM_BACKEND_CODE);
        put(WEIXIN_OPEN, WEIXIN_OPEN_CODE);
        put(WEIXIN_SERVICE, WEIXIN_SERVICE_CODE);
        put(LOAN_PROXY, LOAN_PROXY_CODE);
        put(MERCHANT_CONTRACT_SERVICE, MERCHANT_CONTRACT_SERVICE_CODE);


        put(BACKEND_UPAY, BACKEND_UPAY_CODE);
        put(UPAY_WEB_BACKEND, UPAY_WEB_BACKEND_CODE);
        put(MARKETING_SERVICE, MARKETING_SERVICE_CODE);

        put(UNKNOWN, UNKNOWN_CODE);
    }};

    /**
     * 编码映射项目名Map.
     */
    public static final Map<Integer, String> NAMES_MAP = getNamesMap();

    private static Map<Integer, String> getNamesMap() {
        Map<Integer, String> namesMap = new LinkedHashMap<Integer, String>();
        for (String name : CODES_MAP.keySet()) {
            namesMap.put(CODES_MAP.get(name), name);
        }
        return namesMap;
    }

    /**
     * 增加系统.
     * 如果已存在系统或者系统编码则增加失败.
     *
     * @param projectName
     * @param projectCode
     */
    public static void addProject(String projectName, int projectCode) throws CommonConfigException {
        if (StringUtils.isEmpty(projectName)) {
            throw new CommonConfigException("projectName must not null.");
        }
        if (CODES_MAP.containsKey(projectName)) {
            throw new CommonConfigException("projectName '" + projectName + "' already exists, mapping projectCode=" + CODES_MAP.get(projectName) + ".");
        }
        if (NAMES_MAP.containsKey(projectCode)) {
            throw new CommonConfigException("projectCode " + projectCode + " already exists, mapping projectName=" + NAMES_MAP.get(projectCode) + ".");
        }
        CODES_MAP.put(projectName, projectCode);
        NAMES_MAP.put(projectCode, projectName);
    }

}