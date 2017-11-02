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
 * 灌区基本信息
 * </p>
 *
 * @author hnsl
 * @since 2017-10-20
 */
@TableName("irr_base")
public class IrrBase extends Model<IrrBase> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
	@TableId(value="irr_id", type= IdType.AUTO)
	private Integer irrId;
    /**
     * 灌区编码
     */
	@TableField("irr_code")
	private String irrCode;
    /**
     * 水源编码
     */
	@TableField("source_id")
	private Integer sourceId;
    /**
     * 灌区名称
     */
	@TableField("irr_name")
	private String irrName;
    /**
     * 灌区类型
     */
	@TableField("irr_type")
	private String irrType;
    /**
     * 上级管理单位
     */
	@TableField("upper_manageunit")
	private String upperManageunit;
    /**
     * 设计灌溉面积
     */
	@TableField("design_irrigate_area")
	private BigDecimal designIrrigateArea;
    /**
     * 渠首取水位置
     */
	@TableField("chead_site")
	private String cheadSite;
    /**
     * 渠首设计流量
     */
	@TableField("chead_flux")
	private BigDecimal cheadFlux;
    /**
     * 总干渠长度
     */
	@TableField("trunk_legth")
	private BigDecimal trunkLegth;
    /**
     * 灌溉范围
     */
	@TableField("irrigation_area")
	private String irrigationArea;
    /**
     * 创建时间
     */
	private Date created;
    /**
     * 更新时间
     */
	private Date modified;


	public Integer getIrrId() {
		return irrId;
	}

	public void setIrrId(Integer irrId) {
		this.irrId = irrId;
	}

	public String getIrrCode() {
		return irrCode;
	}

	public void setIrrCode(String irrCode) {
		this.irrCode = irrCode;
	}

	public Integer getSourceId() {
		return sourceId;
	}

	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}

	public String getIrrName() {
		return irrName;
	}

	public void setIrrName(String irrName) {
		this.irrName = irrName;
	}

	public String getIrrType() {
		return irrType;
	}

	public void setIrrType(String irrType) {
		this.irrType = irrType;
	}

	public String getUpperManageunit() {
		return upperManageunit;
	}

	public void setUpperManageunit(String upperManageunit) {
		this.upperManageunit = upperManageunit;
	}

	public BigDecimal getDesignIrrigateArea() {
		return designIrrigateArea;
	}

	public void setDesignIrrigateArea(BigDecimal designIrrigateArea) {
		this.designIrrigateArea = designIrrigateArea;
	}

	public String getCheadSite() {
		return cheadSite;
	}

	public void setCheadSite(String cheadSite) {
		this.cheadSite = cheadSite;
	}

	public BigDecimal getCheadFlux() {
		return cheadFlux;
	}

	public void setCheadFlux(BigDecimal cheadFlux) {
		this.cheadFlux = cheadFlux;
	}

	public BigDecimal getTrunkLegth() {
		return trunkLegth;
	}

	public void setTrunkLegth(BigDecimal trunkLegth) {
		this.trunkLegth = trunkLegth;
	}

	public String getIrrigationArea() {
		return irrigationArea;
	}

	public void setIrrigationArea(String irrigationArea) {
		this.irrigationArea = irrigationArea;
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

	@Override
	protected Serializable pkVal() {
		return this.irrId;
	}

	@Override
	public String toString() {
		return "IrrBase{" +
			"irrId=" + irrId +
			", irrCode=" + irrCode +
			", sourceId=" + sourceId +
			", irrName=" + irrName +
			", irrType=" + irrType +
			", upperManageunit=" + upperManageunit +
			", designIrrigateArea=" + designIrrigateArea +
			", cheadSite=" + cheadSite +
			", cheadFlux=" + cheadFlux +
			", trunkLegth=" + trunkLegth +
			", irrigationArea=" + irrigationArea +
			", created=" + created +
			", modified=" + modified +
			"}";
	}
}
