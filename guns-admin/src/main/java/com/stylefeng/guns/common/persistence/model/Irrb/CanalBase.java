package com.stylefeng.guns.common.persistence.model.Irrb;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 渠道基本信息
 * </p>
 *
 * @author hnsl
 * @since 2017-10-23
 */
@TableName("canal_base")
public class CanalBase extends Model<CanalBase> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
	@TableId(value="canal_id", type= IdType.AUTO)
	private Integer canalId;
    /**
     * 渠道编码
     */
	@TableField("canal_code")
	private String canalCode;
    /**
     * 灌区编码
     */
	@TableField("irr_id")
	private Integer irrId;
    /**
     * 渠道名称
     */
	@TableField("canal_name")
	private String canalName;
    /**
     * 渠道类型
     */
	@TableField("canal_type")
	private String canalType;
    /**
     * 渠道长度（公里）
     */
	@TableField("canal_length")
	private BigDecimal canalLength;
    /**
     * 控制面积（万亩）
     */
	@TableField("canal_control_area")
	private BigDecimal canalControlArea;
    /**
     * 规划供水面积（万亩）
     */
	@TableField("canal_plan_area")
	private BigDecimal canalPlanArea;
    /**
     * 上级渠道标识符
     */
	@TableField("upper_canal_id")
	private Integer upperCanalId;
    /**
     * 上级渠道桩号
     */
	@TableField("upper_canal_stake")
	private BigDecimal upperCanalStake;
    /**
     * 创建时间
     */
	private Date created;
    /**
     * 更新时间
     */
	private Date modified;
    /**
     * 上级渠道集合
     */
	@TableField("upper_canal_ids")
	private String upperCanalIds;


	public Integer getCanalId() {
		return canalId;
	}

	public void setCanalId(Integer canalId) {
		this.canalId = canalId;
	}

	public String getCanalCode() {
		return canalCode;
	}

	public void setCanalCode(String canalCode) {
		this.canalCode = canalCode;
	}

	public Integer getIrrId() {
		return irrId;
	}

	public void setIrrId(Integer irrId) {
		this.irrId = irrId;
	}

	public String getCanalName() {
		return canalName;
	}

	public void setCanalName(String canalName) {
		this.canalName = canalName;
	}

	public String getCanalType() {
		return canalType;
	}

	public void setCanalType(String canalType) {
		this.canalType = canalType;
	}

	public BigDecimal getCanalLength() {
		return canalLength;
	}

	public void setCanalLength(BigDecimal canalLength) {
		this.canalLength = canalLength;
	}

	public BigDecimal getCanalControlArea() {
		return canalControlArea;
	}

	public void setCanalControlArea(BigDecimal canalControlArea) {
		this.canalControlArea = canalControlArea;
	}

	public BigDecimal getCanalPlanArea() {
		return canalPlanArea;
	}

	public void setCanalPlanArea(BigDecimal canalPlanArea) {
		this.canalPlanArea = canalPlanArea;
	}

	public Integer getUpperCanalId() {
		return upperCanalId;
	}

	public void setUpperCanalId(Integer upperCanalId) {
		this.upperCanalId = upperCanalId;
	}

	public BigDecimal getUpperCanalStake() {
		return upperCanalStake;
	}

	public void setUpperCanalStake(BigDecimal upperCanalStake) {
		this.upperCanalStake = upperCanalStake;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Date getModified() {
		return modified;
	}

	public void setModified(Date modified) {
		this.modified = modified;
	}

	public String getUpperCanalIds() {
		return upperCanalIds;
	}

	public void setUpperCanalIds(String upperCanalIds) {
		this.upperCanalIds = upperCanalIds;
	}

	@Override
	protected Serializable pkVal() {
		return this.canalId;
	}

	@Override
	public String toString() {
		return "CanalBase{" +
			"canalId=" + canalId +
			", canalCode=" + canalCode +
			", irrId=" + irrId +
			", canalName=" + canalName +
			", canalType=" + canalType +
			", canalLength=" + canalLength +
			", canalControlArea=" + canalControlArea +
			", canalPlanArea=" + canalPlanArea +
			", upperCanalId=" + upperCanalId +
			", upperCanalStake=" + upperCanalStake +
			", created=" + created +
			", modified=" + modified +
			", upperCanalIds=" + upperCanalIds +
			"}";
	}
}
