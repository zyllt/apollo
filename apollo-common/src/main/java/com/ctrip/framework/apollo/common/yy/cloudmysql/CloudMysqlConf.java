package com.ctrip.framework.apollo.common.yy.cloudmysql;

import com.ctrip.framework.apollo.core.utils.DuoWanEnvUtil;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.math.NumberUtils;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * 功能：yy的云数据库
 *
 * @author zengyuan on 2018/5/15.
 * @see
 */
@Component
public class CloudMysqlConf implements EnvironmentAware {

    private static final String CLOUDMYSQL_ID_PREFIX = "cloudapp_cloudmysql_id_";

    private Environment environment;

    public JdbcUrlInfo getCloudMysqlUrl() {
        String key = CLOUDMYSQL_ID_PREFIX + DuoWanEnvUtil.getDuowanEnv();
        String name = environment.getProperty(key);
        String database = getDatabase();

        int port = NumberUtils.toInt(System.getenv(name + "_port"));
        String host = System.getenv(name + "_host");
        String user = System.getenv(name + "_user");
        String password = System.getenv(name + "_password");
        if (StringUtils.isEmpty(host) || StringUtils.isEmpty(user) || StringUtils.isEmpty(password) || port <= 0 || port >= 65533) {
            throw new RuntimeException("获取当前环境变量出错,请检查数据源实例ID是否填写正确,确保dsn.properties文件已删除!实例ID:[" + name + "]");
        }
        String url = buildJdbcUrl(host, port, database);

        return new JdbcUrlInfo(url, user, password);
    }

    private String buildJdbcUrl(String host, int port, String database) {
        String jdbcUrl = "jdbc:mysql://" + host + ":" + port + "/" + database + "?useUnicode=true&characterEncoding=UTF8";
        return jdbcUrl;
    }


    /**
     * 根据启动的项目确定
     *
     * @return
     */
    private String getDatabase() {
        String applicationName = environment.getProperty("spring.application.name");
        if (StringUtils.isBlank(applicationName)) {
            throw new RuntimeException("未配置spring.application.name，无法判定database");
        }
        if (applicationName.equalsIgnoreCase("apollo-portal")) {
            return "ApolloPortalDB";
        }
        return "ApolloConfigDB";
    }

    @Override
    public void setEnvironment(Environment environment) {
        this.environment = environment;
    }
}
























