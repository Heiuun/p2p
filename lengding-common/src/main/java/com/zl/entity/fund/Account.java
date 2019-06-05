package com.zl.entity.fund;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import lombok.Data;

/**
 * 账户实体类
 * @author Mouse
 *
 */
@Data
public class Account implements Serializable{

	/**
	 * ID NUMBER(10) PRIMARY KEY,      --唯一主键
       balance NUMBER(20,2),           --账户余额
       avaliable_balance NUMBER(20,2), --可用余额
       total_loan NUMBER(20,2),        --贷款总额
       total_num NUMBER(20),           --贷款笔数
       principal NUMBER(20,2),         --待还本息
       create_time date,               --创建日期
       update_time date ,              --修改日期
	   state number(4)                 --状态的状态 -1:删除 1:未删除
	 */
	
	private static final long serialVersionUID = 1L;

	/** 账户信息id*/
	private Integer id;
	/** 账户余额*/
	private BigDecimal balance;
	/** 可用余额*/
	private BigDecimal avaliable_balance;
	/** 贷款总额*/
	private BigDecimal total_loan;
	/** 贷款笔数*/
	private BigInteger total_num;
	/** 待还利息*/
	private BigInteger principal;
	/** 创建日期*/
	private Date create_time;
	/** 修改日期*/
	private Date update_time;
	/** 状态(删除/未删除)*/
	private Integer state;
	
	public static final int ACCOUNT_DELECT = -1; //删除
	public static final int ACCOUNT_NOTMAL = 1;  //未删除
}
