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
 *
 */
@Entity
@Table(name = "TRANSACTION")
public class Transaction implements Serializable, Cloneable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TRANSACTION_ID")
	private Long trasnactionId;

	@Column(name = "USER_ID")
	private Long userId;

	@Column(name = "OLD_BALANCE")
	private Long oldBalance;

	@Column(name = "NEW_BALANCE")
	private Long newBalance;

	@Column(name = "TRANSACTION_AMOUNT")
	private Long transactionAmount;

	@Column(name = "TRANSACTION_TYPE")
	private String transactionType;

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

	public Long getTrasnactionId() {
		return trasnactionId;
	}

	public void setTrasnactionId(Long trasnactionId) {
		this.trasnactionId = trasnactionId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getOldBalance() {
		return oldBalance;
	}

	public void setOldBalance(Long oldBalance) {
		this.oldBalance = oldBalance;
	}

	public Long getNewBalance() {
		return newBalance;
	}

	public void setNewBalance(Long newBalance) {
		this.newBalance = newBalance;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}

	public Long getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Long transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	@Override
	public String toString() {
		return "Transaction [trasnactionId=" + trasnactionId + ", userId=" + userId + ", oldBalance=" + oldBalance
				+ ", newBalance=" + newBalance + ", transactionType=" + transactionType + ", createdOn=" + createdOn
				+ ", updatedOn=" + updatedOn + "]";
	}
}
