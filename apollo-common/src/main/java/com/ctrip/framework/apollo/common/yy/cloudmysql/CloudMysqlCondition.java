package com.ctrip.framework.apollo.common.yy.cloudmysql;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * 功能：CloudMysql激活
 *
 * @author zengyuan on 2018/5/15.
 * @see
 */
public class CloudMysqlCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata annotatedTypeMetadata) {

        if (StringUtils.isNotBlank(context.getEnvironment().getProperty("cloudapp_cloudmysql_id_prod"))) {
            return true;
        }
        if (StringUtils.isNotBlank(context.getEnvironment().getProperty("cloudapp_cloudmysql_id_test"))) {
            return true;
        }
        return false;
    }
}
