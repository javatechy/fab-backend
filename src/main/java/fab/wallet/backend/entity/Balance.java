/**
 * 
 */
package fab.wallet.backend.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fab.wallet.backend.util.LocalDateTimeAttributeConverter;

/**
 * @author deepak
 */

@Entity
@Table(name = "BALANCE")
public class Balance implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "USER_ID")
	private Long userId;

	@Column(name = "BALANCE")
	private Long balance;

	@Column(name = "CREATED_ON")
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime createdOn;

	@Column(name = "UPDATED_ON")
	@Convert(converter = LocalDateTimeAttributeConverter.class)
	private LocalDateTime updatedOn;

	public LocalDateTime getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDateTime createdOn) {
		this.createdOn = createdOn;
	}

	public LocalDateTime getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(LocalDateTime updatedOn) {
		this.updatedOn = updatedOn;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getBalance() {
		return balance;
	}

	public void setBalance(Long balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Balance [id=" + id + ", userId=" + userId + ", balance=" + balance + ", createdOn=" + createdOn
				+ ", updatedOn=" + updatedOn + "]";
	}
}
