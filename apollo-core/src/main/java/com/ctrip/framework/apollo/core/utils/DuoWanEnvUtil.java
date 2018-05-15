package com.ctrip.framework.apollo.core.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DuoWanEnvUtil {

    private static final Logger logger = LoggerFactory.getLogger(DuoWanEnvUtil.class);
    public static final String ENV_KEY = "DWENV";
    public static final String ENV_PROD = "prod";
    public static final String ENV_BENCHMARK = "benchmark";
    public static final String ENV_INTEGRATION = "integration";
    public static final String ENV_DEV = "dev";
    public static final String ENV_TEST = "test";

    /**
     * 获取当前运行环境(dev|test|prod)
     *
     * @return
     */
    public static String getDuowanEnv() {
        String env = getenv(ENV_KEY);
        if (StringUtils.isEmpty(env)) {
            if (StringUtils.isBlank(env)) {
                logger.info("未配置环境变量DWENV. | env:{}", env);
            }
            return DuoWanEnvUtil.ENV_DEV;
        }
        return env;
    }

    public static boolean isDevEnv() {
        String env = getDuowanEnv();
        return DuoWanEnvUtil.ENV_DEV.equalsIgnoreCase(env);
    }

    public static boolean isTestEnv() {
        String env = getDuowanEnv();
        return DuoWanEnvUtil.ENV_TEST.equalsIgnoreCase(env);
    }


    public static boolean isProductEnv() {
        String env = getDuowanEnv();
        return DuoWanEnvUtil.ENV_PROD.equalsIgnoreCase(env);
    }

    protected static String getenv(String name) {
        String value = System.getenv(name);
        if (StringUtils.isEmpty(value)) {
            value = System.getProperty(name);
        }
        return value;
    }

}
