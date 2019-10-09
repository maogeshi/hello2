package com.atguigu.scw.order.vo.request;

import java.io.Serializable;

import com.atguigu.scw.common.vo.BaseVo;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class OrderComfirmVo implements Serializable{
	private Integer returnid;
	private String ordernum;
	private String createdate;
	private Integer money;	
	private Integer rtncount;
	private Integer status;
	private String address;
	private Integer invoice;
	private String invoicetitle;
	private String remark;
	private Integer memberid;
	private Integer projectid;
	 private String accessToken; //用户登录成功的token
}
