package com.zl.entity.fund;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.bouncycastle.util.test.FixedSecureRandom.BigInteger;

import lombok.Data;

/**
 * 日志实体类
 * @author Mouse
 *
 */
@Data
public class Journal implements Serializable{

	/**
	 * ID NUMBER(10) PRIMARY KEY,               --唯一主键
       journal_order NUMBER(20) unique,         --单号
       journal_money NUMBER(10,2) ,             --操作金额
       journal_time DATE NOT NULL,              --时间
       journal_operation VARCHAR2(20) ,         --操作类型
       journal_remarks VARCHAR2(100),           --备注
	   create_time date,                        --创建日期
       update_time date,                        --修改日期
	   state number(4)                          --状态的状态 -1:删除 1:未删除
	 */
	
	private static final long serialVersionUID = 1L;

	/** 日志id*/
	private Integer id;
	/** 单号*/
	private BigInteger journal_order;
	/** 操作金额*/
	private BigDecimal journal_money;
	/** 时间*/
	private Date journal_time;
	/** 操作类型*/
	private String journal_operation;
	/** 备注*/
	private String journal_remarks;
	/** 创建日期*/
	private Date create_time;
	/** 修改日期*/
	private Date update_time;
	/** 状态(删除/未删除)*/
	private Integer state;
	
	public static final int JOURNAL_DELECT = -1; //删除
	public static final int JOURNAL_NOTMAL = 1;  //未删除
}
