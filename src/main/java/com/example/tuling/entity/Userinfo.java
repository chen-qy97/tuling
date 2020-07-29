package com.example.tuling.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import java.util.Date;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author wangqiang
 * @since 2020-07-29
 */
public class Userinfo extends Model<Userinfo> {

    private static final long serialVersionUID = 1L;

	@TableId(value="ID", type= IdType.AUTO)
	private Long id;
	@TableField("MEMO")
	private String memo;
	@TableField("EMAIL")
	private String email;
	@TableField("MOBILE")
	private String mobile;
	@TableField("LOGIN_ID")
	private String loginId;
	@TableField("PASSWORD")
	private String password;
	@TableField("IS_ADMIN")
	private Long isAdmin;
	@TableField("USER_NAME")
	private String userName;
	@TableField("SEX_ID")
	private Long sexId;
	@TableField("ORGINFO_ID")
	private String orginfoId;
	@TableField("TENANT_ID")
	private String tenantId;
	@TableField("UPDATE_DATE")
	private Date updateDate;
	@TableField("CREATE_DATE")
	private Date createDate;
	@TableField("CREATE_USER")
	private String createUser;
	@TableField("IS_NORAML")
	private Long isNoraml;
	@TableField("RESERVE1")
	private String reserve1;
	@TableField("RESERVE2")
	private String reserve2;
	@TableField("RESERVE3")
	private String reserve3;
	@TableField("RESERVE4")
	private String reserve4;
	@TableField("RESERVE5")
	private String reserve5;
    /**
     * 用户头像
     */
	@TableField("IMG_URL")
	private String imgUrl;
	@TableField("PWD_EXPIRE_DATE")
	private Date pwdExpireDate;
	@TableField("ORGTYPE")
	private String orgtype;
	@TableField("COMPANYNAME")
	private String companyname;
	@TableField("INDUSTRY")
	private String industry;
	@TableField("COMPANYSCALE")
	private String companyscale;
	@TableField("ASSIGNREASON")
	private String assignreason;
	@TableField("TEST22")
	private String test22;
	@TableField("TEST11")
	private String test11;
	@TableField("TEST44")
	private String test44;
	@TableField("TEST55")
	private String test55;
	@TableField("TEST66")
	private String test66;
	@TableField("TEST77")
	private String test77;
	@TableField("TEST88")
	private String test88;
	@TableField("TEST99")
	private String test99;
	@TableField("TEST100")
	private String test100;
	private String TEST101;
	@TableField("TEST102")
	private String test102;
	@TableField("TEST103")
	private String test103;
	@TableField("TEST104")
	private String test104;
	@TableField("TEST105")
	private String test105;
	@TableField("TEST106")
	private String test106;
	@TableField("TEST107")
	private String test107;
	@TableField("TEST108")
	private String test108;
	@TableField("TEST615")
	private String test615;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getIsAdmin() {
		return isAdmin;
	}

	public void setIsAdmin(Long isAdmin) {
		this.isAdmin = isAdmin;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Long getSexId() {
		return sexId;
	}

	public void setSexId(Long sexId) {
		this.sexId = sexId;
	}

	public String getOrginfoId() {
		return orginfoId;
	}

	public void setOrginfoId(String orginfoId) {
		this.orginfoId = orginfoId;
	}

	public String getTenantId() {
		return tenantId;
	}

	public void setTenantId(String tenantId) {
		this.tenantId = tenantId;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateUser() {
		return createUser;
	}

	public void setCreateUser(String createUser) {
		this.createUser = createUser;
	}

	public Long getIsNoraml() {
		return isNoraml;
	}

	public void setIsNoraml(Long isNoraml) {
		this.isNoraml = isNoraml;
	}

	public String getReserve1() {
		return reserve1;
	}

	public void setReserve1(String reserve1) {
		this.reserve1 = reserve1;
	}

	public String getReserve2() {
		return reserve2;
	}

	public void setReserve2(String reserve2) {
		this.reserve2 = reserve2;
	}

	public String getReserve3() {
		return reserve3;
	}

	public void setReserve3(String reserve3) {
		this.reserve3 = reserve3;
	}

	public String getReserve4() {
		return reserve4;
	}

	public void setReserve4(String reserve4) {
		this.reserve4 = reserve4;
	}

	public String getReserve5() {
		return reserve5;
	}

	public void setReserve5(String reserve5) {
		this.reserve5 = reserve5;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

	public Date getPwdExpireDate() {
		return pwdExpireDate;
	}

	public void setPwdExpireDate(Date pwdExpireDate) {
		this.pwdExpireDate = pwdExpireDate;
	}

	public String getOrgtype() {
		return orgtype;
	}

	public void setOrgtype(String orgtype) {
		this.orgtype = orgtype;
	}

	public String getCompanyname() {
		return companyname;
	}

	public void setCompanyname(String companyname) {
		this.companyname = companyname;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getCompanyscale() {
		return companyscale;
	}

	public void setCompanyscale(String companyscale) {
		this.companyscale = companyscale;
	}

	public String getAssignreason() {
		return assignreason;
	}

	public void setAssignreason(String assignreason) {
		this.assignreason = assignreason;
	}

	public String getTest22() {
		return test22;
	}

	public void setTest22(String test22) {
		this.test22 = test22;
	}

	public String getTest11() {
		return test11;
	}

	public void setTest11(String test11) {
		this.test11 = test11;
	}

	public String getTest44() {
		return test44;
	}

	public void setTest44(String test44) {
		this.test44 = test44;
	}

	public String getTest55() {
		return test55;
	}

	public void setTest55(String test55) {
		this.test55 = test55;
	}

	public String getTest66() {
		return test66;
	}

	public void setTest66(String test66) {
		this.test66 = test66;
	}

	public String getTest77() {
		return test77;
	}

	public void setTest77(String test77) {
		this.test77 = test77;
	}

	public String getTest88() {
		return test88;
	}

	public void setTest88(String test88) {
		this.test88 = test88;
	}

	public String getTest99() {
		return test99;
	}

	public void setTest99(String test99) {
		this.test99 = test99;
	}

	public String getTest100() {
		return test100;
	}

	public void setTest100(String test100) {
		this.test100 = test100;
	}

	public String getTEST101() {
		return TEST101;
	}

	public void setTEST101(String TEST101) {
		this.TEST101 = TEST101;
	}

	public String getTest102() {
		return test102;
	}

	public void setTest102(String test102) {
		this.test102 = test102;
	}

	public String getTest103() {
		return test103;
	}

	public void setTest103(String test103) {
		this.test103 = test103;
	}

	public String getTest104() {
		return test104;
	}

	public void setTest104(String test104) {
		this.test104 = test104;
	}

	public String getTest105() {
		return test105;
	}

	public void setTest105(String test105) {
		this.test105 = test105;
	}

	public String getTest106() {
		return test106;
	}

	public void setTest106(String test106) {
		this.test106 = test106;
	}

	public String getTest107() {
		return test107;
	}

	public void setTest107(String test107) {
		this.test107 = test107;
	}

	public String getTest108() {
		return test108;
	}

	public void setTest108(String test108) {
		this.test108 = test108;
	}

	public String getTest615() {
		return test615;
	}

	public void setTest615(String test615) {
		this.test615 = test615;
	}

	@Override
	protected Serializable pkVal() {
		return this.id;
	}

}
