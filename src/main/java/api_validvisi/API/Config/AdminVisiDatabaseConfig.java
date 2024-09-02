package api_validvisi.API.Config;

import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import javax.sql.DataSource;

@Configuration
@EnableJpaRepositories(
        basePackages = "api_validvisi.API.Repo.AdminVisi",
        entityManagerFactoryRef = "adminVisiEntityManagerFactory",
        transactionManagerRef = "adminVisiTransactionManager"
)
public class AdminVisiDatabaseConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.adminvisi")
    public DataSourceProperties adminVisiDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    public DataSource adminVisiDataSource() {
        return adminVisiDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean adminVisiEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(adminVisiDataSource());
        em.setPackagesToScan("api_validvisi.API.Model.AdminVisi");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

    @Bean
    public DataSourceTransactionManager adminVisiTransactionManager() {
        return new DataSourceTransactionManager(adminVisiDataSource());
    }
}