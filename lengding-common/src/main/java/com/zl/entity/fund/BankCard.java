package com.zl.entity.fund;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 银行卡实体类
 * @author Mouse
 *
 */
@Data
public class BankCard implements Serializable{

	/**
	 * ID NUMBER(10) PRIMARY KEY,       --唯一主键
       real_name VARCHAR2(20),          --开户名
       REPLACE VARCHAR2(100) ,          --开户行所在地
       card_num VARCHAR2(50) unique,    --银行卡号
       account_type NUMBER(5),          --账户类型
	   create_time date,                --创建日期
       update_time date,                --修改日期
	   state number(4)                  --状态的状态 -1:删除 1:未删除
	 */
	
	private static final long serialVersionUID = 1L;
	
	/** 银行卡id*/
	private Integer id;
	/** 开户名*/
	private String real_name;
	/** 开户行所在地*/
	private String replace;
	/** 银行卡号*/
	private String card_num;
	/** 账户类型*/
	private Integer account_type;
	/** 创建日期*/
	private Date create_time;
	/** 修改日期*/
	private Date update_time;
	/** 状态(删除/未删除)*/
	private Integer state;
	
	public static final int BANKCARDSTATE_DELECT = -1; //删除
	public static final int BANKCARDSTATE_NOTMAL = 1;  //未删除
}
