package com.ctrip.framework.apollo.common.yy.cloudmysql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Component
@Conditional(CloudMysqlCondition.class)
public class CloudMysqlDataSource {

    @Autowired
    private CloudMysqlConf cloudMysqlConf;

    @Bean
    @Primary
    public DataSource dataSource() {
        JdbcUrlInfo info = cloudMysqlConf.getCloudMysqlUrl();
        return DataSourceBuilder
                .create()
                .url(info.getUrl())
                .password(info.getPwd())
                .username(info.getName())
                .build();
    }

}
