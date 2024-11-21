package be.nsi.labo.jpa.labojpa.domain;

import java.time.LocalDateTime;

/**
 * The Interface IAuditingEntity.
 */
public interface AuditingEntity {
	
	/**
	 * Sets the creates the by.
	 *
	 * @param createBy the new creates the by
	 */
	void setCreateBy(String createBy);
	
	/**
	 * Sets the creates the at.
	 *
	 * @param createAt the new creates the at
	 */
	void setCreateAt(LocalDateTime createAt);
	
	/**
	 * Sets the update by.
	 *
	 * @param updateBy the new update by
	 */
	void setUpdateBy(String updateBy);
	
	/**
	 * Sets the update at.
	 *
	 * @param updateAt the new update at
	 */
	void setUpdateAt(LocalDateTime updateAt);
	
//	/**
//	 * Sets the delete by.
//	 *
//	 * @param deleteBy the new delete by
//	 */
//	void setDeleteBy(String deleteBy);
//
//	/**
//	 * Sets the delete at.
//	 *
//	 * @param deleteAt the new delete at
//	 */
//	void setDeleteAt(LocalDateTime deleteAt);
}
