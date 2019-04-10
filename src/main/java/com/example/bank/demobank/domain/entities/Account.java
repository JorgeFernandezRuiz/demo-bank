package com.example.bank.demobank.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Table(name = "account")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Account {
	@Id
	@GeneratedValue
	private Long accountId;
	@Column (nullable = false, name = "customer_id")
	private Long customerId;
	private String accountNumber;
	private Double balance;
	private Boolean active;
}
