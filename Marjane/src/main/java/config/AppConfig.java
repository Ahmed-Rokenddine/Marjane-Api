package config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import static org.hibernate.cfg.Environment.*;

@Configuration
@PropertySource("classpath:application.properties") // Updated to a properties file
@EnableTransactionManagement
@ComponentScans(value = {
        @ComponentScan("dao"),      // Update to your PostgreSQL DAO package
        @ComponentScan("service")  // Update to your PostgreSQL service package
})
public class AppConfig {
    @Autowired
    private Environment env;

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        Properties props = new Properties();

        // Setting JDBC properties
        props.put(DRIVER, env.getProperty("spring.datasource.driver-class-name"));
        props.put(URL, env.getProperty("spring.datasource.url"));
        props.put(USER, env.getProperty("spring.datasource.user"));
        props.put(PASS, env.getProperty("spring.datasource.password"));

        // Setting Hibernate properties
        props.put(SHOW_SQL, env.getProperty("spring.jpa.show-sql"));
        props.put(HBM2DDL_AUTO, env.getProperty("spring.jpa.hibernate.ddl-auto"));

        // Setting C3P0 properties
        props.put(C3P0_MIN_SIZE, env.getProperty("spring.datasource.hikari.minimumIdle"));
        props.put(C3P0_MAX_SIZE, env.getProperty("spring.datasource.hikari.maximumPoolSize"));
        props.put(C3P0_TIMEOUT, env.getProperty("spring.datasource.hikari.idleTimeout"));
        props.put(C3P0_MAX_STATEMENTS, env.getProperty("spring.datasource.hikari.maxLifetime"));

        factoryBean.setHibernateProperties(props);
        factoryBean.setPackagesToScan("Entity"); // Update the package name

        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }
}
