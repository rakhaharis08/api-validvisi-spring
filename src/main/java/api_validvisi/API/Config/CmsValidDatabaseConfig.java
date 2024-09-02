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
        basePackages = "api_validvisi.API.Repo.CMSValid",  // Adjust the package to your repository package
        entityManagerFactoryRef = "cmsValidEntityManagerFactory",
        transactionManagerRef = "cmsValidTransactionManager"
)
public class CmsValidDatabaseConfig {

    @Bean
    @ConfigurationProperties(prefix = "spring.datasource.cmsvalid")
    public DataSourceProperties cmsValidDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Bean
    @Primary  // Make this the primary DataSource
    public DataSource cmsValidDataSource() {
        return cmsValidDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean
    @Primary  // Make this the primary EntityManagerFactory
    public LocalContainerEntityManagerFactoryBean cmsValidEntityManagerFactory() {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(cmsValidDataSource());
        em.setPackagesToScan("api_validvisi.API.Model.CMSValid");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        return em;
    }

    @Bean
    @Primary  // Make this the primary TransactionManager
    public DataSourceTransactionManager cmsValidTransactionManager() {
        return new DataSourceTransactionManager(cmsValidDataSource());
    }
}
