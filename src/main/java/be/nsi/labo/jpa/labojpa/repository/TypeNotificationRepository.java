package be.nsi.labo.jpa.labojpa.repository;

import be.nsi.labo.jpa.labojpa.domain.notifications.TypeNotificationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.List;
/**
 * Spring Data  repository for the TypeNotificationEntity entity.
 */
@SuppressWarnings("unused")
@Repository
public interface TypeNotificationRepository extends JpaRepository<TypeNotificationEntity, Long>, PagingAndSortingRepository<TypeNotificationEntity, Long>, JpaSpecificationExecutor<TypeNotificationEntity> {

    TypeNotificationEntity findOneByTypeInstanceCode(String code);

    Optional<TypeNotificationEntity> findByCode(String code);

    List<TypeNotificationEntity> findAllByOrderByOrder();

    List<TypeNotificationEntity> findAllByDossierTypeName(String dossierType);

    List<TypeNotificationEntity> findAllByDossierTypeNameOrderByOrder(String dossierType);

    List<TypeNotificationEntity> findAllByContexteDomCodeOrContexteNullAndDossierTypeName(String contexte, String dossierTypeName);

    List<TypeNotificationEntity> findAllByModesEnvoiDomCodeContainsOrderByOrder(String modeEnvoi);

    void deleteByCode(String code);

    boolean existsByCode(String code);
}
