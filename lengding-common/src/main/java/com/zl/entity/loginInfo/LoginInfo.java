package com.zl.entity.loginInfo;

import java.io.Serializable;
import java.util.Date;

import lombok.Data;

/**
 * 登陆信息表的实体
 */
@Data
public class LoginInfo implements Serializable {

	/**
	 * login_info_id number(10) primary key, --用户id
       nick_name varchar2(40) unique,      --用户名
       phone varchar2(20) not null,        --手机号
       pass varchar2(20)not null,          --密码
       login_state number(4)not null,      --状态
       create_time date,                   --创建日期
       update_time date                    --修改日期
	 */
	private static final long serialVersionUID = 1L;
	/**用户id*/
	private Long loginInfoId;
	/**用户名*/
	private String nickName;
	/**手机号*/
	private String phone;
	/**密码*/
	private String pass;
	/**状态*/
	private UserState userState;
	/**创建日期*/
	private Date createTime;
	/**修改日期*/
	private Date updateTime;
}
