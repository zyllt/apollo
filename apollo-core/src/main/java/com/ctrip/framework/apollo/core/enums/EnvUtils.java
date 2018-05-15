package com.ctrip.framework.apollo.core.enums;

import com.ctrip.framework.apollo.core.utils.StringUtils;

public final class EnvUtils {

    public static Env transformEnv(String envName) {
        if (StringUtils.isBlank(envName)) {
            return null;
        }
        switch (envName.trim().toUpperCase()) {
            case "LPT":
                return Env.LPT;
            case "FAT":
            case "FWS":
                return Env.FAT;
            case "UAT":
                return Env.UAT;
            case "PRO":
                return Env.PRO;
            case "PROD": //just in case
                return Env.PROD;
            case "DEV":
                return Env.DEV;
            case "LOCAL":
                return Env.LOCAL;
            case "TOOLS":
                return Env.TOOLS;
            case "TEST":
                return Env.TEST;
            default:
                return null;
        }
    }
}
