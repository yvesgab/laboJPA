package be.nsi.labo.jpa.labojpa.repository;

import be.nsi.labo.jpa.labojpa.domain.LogWSEntity;
import be.nsi.labo.jpa.labojpa.domain.notifications.TypeNotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Spring Data  repository for the TypeNotificationEntity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface LogWsRepository extends JpaRepository<LogWSEntity, Long>, JpaSpecificationExecutor<LogWSEntity> {
    @Modifying
    @Query(value = "delete from log_ws where create_at < now()- INTERVAL '3 MONTH'", nativeQuery = true)
    int deleteOldLogWS();
}
