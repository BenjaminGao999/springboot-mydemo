package com.example.springboot.mybatis.mybatisdemo.config;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
//@MapperScan("com.microfinance.market.database.biz.mapper")
@AutoConfigureAfter(PageHelperAutoConfiguration.class)
public class MybatisConfiguration {


//    private static String MAPPER_LOCATION = "classpath:/com/microfinance/market/database/biz/mapper/*.xml";

//    private static String TYPE_ALIASES_PACKAGE = "com.microfinance.market.database.biz.model";

    @Autowired
    DataSource dataSource;

    //
    @Bean(name = "sqlSessionFactory")
    public SqlSessionFactory sqlSessionFactoryBean() throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        // 分页插件
//        PageHelper pageHelper = new PageHelper();
//        Properties props = new Properties();
//        props.setProperty("supportMethodsArguments", "true");
//        props.setProperty("returnPageInfo", "check");
//        props.setProperty("reasonable", "false");
//        props.setProperty("params", "count=countSql");
//        pageHelper.setProperties(props);

//        sqlSessionFactoryBean.setPlugins(new Interceptor[]{pageHelper});
        //mybatis.typeAliasesPackage：指定domain类的基包，即指定其在*Mapper.xml文件中可以使用简名来代替全类名（看后边的UserMapper.xml介绍）
//        sqlSessionFactoryBean.setTypeAliasesPackage(TYPE_ALIASES_PACKAGE);
//        sqlSessionFactoryBean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources(MAPPER_LOCATION));
        return sqlSessionFactoryBean.getObject();
    }

    //
    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
