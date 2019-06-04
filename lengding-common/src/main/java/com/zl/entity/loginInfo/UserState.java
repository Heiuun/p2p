package com.zl.entity.loginInfo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 用户状态
 */
@Data
public class UserState implements Serializable{

	
	private static final long serialVersionUID = 1L;
	/**
	 * user_state_id number(10) primary key, --状态编号
       state_code number(4) unique,    --状态代号 -1:待定 0:已删除 1:已冻结 2正常用户
       state_detial varchar2(100),     --状态描述
       create_time Date,               --创建日期
       update_time Date,               --修改日期
	   state number(4)                 --状态类型的状态 -1:弃用 1:启用
	 */   
	/**-1:待定*/
	public static int UNDETER_MIND=-1;
	/**0:已删除*/
	public static int DELETED=0;
	/**1:已冻结*/
	public static int FORZEN=1;
	/**2正常用户*/
	public static int NOMAL=2;
	/**状态编号*/
	private Long userStateId;
	/**状态代号 1:待定 0:已删除 1:已冻结 2正常用户*/
	private Integer stateCode;
	/**状态描述-1:待定 0:已删除 1:已冻结 2正常用户*/
	private String stateDetial;
	/**创建日期*/
	private Date createTime;
	/**修改日期*/
	private Date updateTime;
	/**状态类型的状态 -1:弃用 1:启用*/
	private Integer state;
}
