package com.example.bank.demobank.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Table (name = "customer")
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Customer {
	@Id
	@GeneratedValue
	@Column(name = "customer_id")
	private Long customerId;
	private String name;
	private String surname;
	private String nif;
	@OneToMany
	@JoinColumn(name = "customer_id", referencedColumnName = "customer_id", insertable = false, updatable = false)

	private List<Account> accountList;

}
