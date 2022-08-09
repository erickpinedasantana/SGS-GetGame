package mx.com.anerware.workshop.postgresql.videogamestore;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jndi.JndiObjectFactoryBean;

import javax.naming.NamingException;
import javax.sql.DataSource;

@Configuration
@PropertySource("classpath:application.properties")
public class ProfileDatabaseConfig {

    @Value("${jndi.app}")
    private String jndiApp;

    @Bean("dataSource")
    @Qualifier("developDatabase")
    @Profile("PROD")
    public DataSource developDatabase() throws NamingException {
        JndiObjectFactoryBean jndiObjectFactoryBean = new JndiObjectFactoryBean();
        jndiObjectFactoryBean.setJndiName(jndiApp);
        jndiObjectFactoryBean.setExpectedType(DataSource.class);
        jndiObjectFactoryBean.setLookupOnStartup(true);
        jndiObjectFactoryBean.setResourceRef(true);
        jndiObjectFactoryBean.afterPropertiesSet();
        return (DataSource) jndiObjectFactoryBean.getObject();
    }
}
