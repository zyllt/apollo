package com.ctrip.framework.apollo.common.yy;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.AbstractEnvironment;

public class EnvUtil {

    private static final Logger logger = LoggerFactory.getLogger(EnvUtil.class);
    public static final String ENV_KEY = "DWENV";
    public static final String ENV_PROD = "prod";
    public static final String ENV_BENCHMARK = "benchmark";
    public static final String ENV_INTEGRATION = "integration";
    public static final String ENV_DEV = "dev";
    public static final String ENV_TEST = "test";

    /**
     * 获取当前项目名称.
     *
     * @return
     */
    public static String getDuowanProjectNo() {
        String project = getenv("DWPROJECTNO");
        return project;
    }

    public static void setProjectName(String projectName) {
        System.setProperty("DWPROJECTNO", projectName);
    }

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
            return EnvUtil.ENV_DEV;
        }
        return env;
    }

    public static boolean isDevEnv() {
        String env = getDuowanEnv();
        return EnvUtil.ENV_DEV.equalsIgnoreCase(env);
    }

    public static boolean isTestEnv() {
        String env = getDuowanEnv();
        return EnvUtil.ENV_TEST.equalsIgnoreCase(env);
    }


    public static boolean isProductEnv() {
        String env = getDuowanEnv();
        return EnvUtil.ENV_PROD.equalsIgnoreCase(env);
    }


    protected static String getenv(String name) {
        String value = System.getenv(name);
        if (StringUtils.isEmpty(value)) {
            value = System.getProperty(name);
        }
        return value;
    }


    /**
     * 根据配置的环境变量记录spring.profiles.active
     */
    public static void activeProfileByEnv() {
        String duowanEnv = EnvUtil.getDuowanEnv();
        System.setProperty(AbstractEnvironment.ACTIVE_PROFILES_PROPERTY_NAME, duowanEnv);
        logger.info("根据duowan运行环境激活profile成功 | duowanEnv:{}", duowanEnv);
    }


}
