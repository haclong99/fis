package vn.fis.account.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "account")
@Data
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;

    @Column(name = "account_number")
    @Max(value = 12, message = "số tài khoản ít hơn 12 chữ số")
    private String accountNumber;

    @Column(name = "account_name")
    @Size(max = 100, min = 5, message = "Tên tài khoản lớn hơn 5 ký tự và nhỏ hơn 100 ký tự")
    private String accountName;


    @Column(name = "balance")
    private Double balance;

    private Integer status;

    @OneToMany(fetch = FetchType.EAGER, mappedBy="account", cascade = CascadeType.ALL)
    @JsonIgnoreProperties("account")
    private List<Transaction> transactionList = new ArrayList<>();

}
