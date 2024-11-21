package be.nsi.labo.jpa.labojpa;

import be.nsi.labo.jpa.labojpa.domain.LogWSEntity;
import be.nsi.labo.jpa.labojpa.repository.LogWsRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.time.LocalDateTime;
import java.util.Map;

@SpringBootApplication
@Slf4j
public class LaboJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(LaboJpaApplication.class, args);
    }

/*    @Bean
    CommandLineRunner runner(TypeNotificationRepository repository) {
        return args -> {

            var results = repository.findAll();
            log.info("results {}",results.size());
        };
    }*/


    @Bean
    @Transactional
    CommandLineRunner runner(LogWsRepository repository, PlatformTransactionManager transactionManager) {
        return args -> {

            /*LogWSEntity logWSEntity = new LogWSEntity();
            logWSEntity.setLabels(Map.of("test", "vtest", "test2", "vtest2"));
            logWSEntity.setCreateAt(LocalDateTime.now());
            logWSEntity.setCreateBy("me");
            logWSEntity= repository.save(logWSEntity);
            log.info("logWs ID {}",logWSEntity.getId());*/
            var tt= new TransactionTemplate(transactionManager);
            tt.execute(status -> {
                var logws=repository.getReferenceById(9143301L);
                logws.getLabels().forEach((s, s2) -> {
                    log.info("item {} : {}", s, s2);
                });
                return null;
            });

        };
    }
}
