package vn.fis.account.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "transaction")
@Data
public class Transaction implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transactionId;

    @Column(name = "transaction_date")
    private Date transactionDate;

    private Integer fromAccount;

    private Integer toAccount;

    private Double amount;
    private Integer status;

    @Column(name = "content")
    private String content;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "account_id",referencedColumnName="accountId")
    @JsonIgnoreProperties("transactionList")
    private Account account;
}
