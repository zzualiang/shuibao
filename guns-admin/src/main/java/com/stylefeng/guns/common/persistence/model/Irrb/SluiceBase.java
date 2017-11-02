package com.stylefeng.guns.common.persistence.model.Irrb;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 水闸信息
 * </p>
 *
 * @author hnsl
 * @since 2017-10-20
 */
@TableName("sluice_base")
public class SluiceBase extends Model<SluiceBase> {

    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
	@TableId(value="sluice_id", type= IdType.AUTO)
	private Integer sluiceId;
    /**
     * 水闸编码
     */
	@TableField("sluice_code")
	private String sluiceCode;
    /**
     * 工程简称
     */
	@TableField("sluice_name")
	private String sluiceName;
    /**
     * 工程全称
     */
	@TableField("sluice_full_name")
	private String sluiceFullName;
    /**
     * 工程别名
     */
	@TableField("sluice_alias_name")
	private String sluiceAliasName;
    /**
     * 水闸类别
     */
	@TableField("sluice_type")
	private String sluiceType;
    /**
     * 所属渠段
     */
	@TableField("canal_id")
	private Integer canalId;
    /**
     * 流量(m^3/s)
     */
	@TableField("sluice_flow")
	private BigDecimal sluiceFlow;
    /**
     * 闸门孔数
     */
	@TableField("strobe_number")
	private Integer strobeNumber;
    /**
     * 闸门型式
     */
	@TableField("strobe_type")
	private String strobeType;
    /**
     * 闸门高度
     */
	@TableField("strobe_height")
	private BigDecimal strobeHeight;
    /**
     * 闸门宽度
     */
	@TableField("strobe_width")
	private BigDecimal strobeWidth;
    /**
     * 闸门厚度
     */
	@TableField("strobe_thickness")
	private BigDecimal strobeThickness;
    /**
     * 启闭机样式
     */
	@TableField("motivity_type")
	private String motivityType;
    /**
     * 启闭机动力
     */
	@TableField("motivity_power")
	private BigDecimal motivityPower;
    /**
     * 启闭速度
     */
	@TableField("motivity_velocity")
	private BigDecimal motivityVelocity;
    /**
     * 消能工型式
     */
	@TableField("dissipation_type")
	private String dissipationType;
    /**
     * 退水渠长(m)
     */
	@TableField("dissipation_length")
	private BigDecimal dissipationLength;
    /**
     * 坡降(上限)
     */
	@TableField("dissipation_slope_upper_limit")
	private BigDecimal dissipationSlopeUpperLimit;
    /**
     * 坡降(下限)
     */
	@TableField("dissipation_slope_lower_limit")
	private BigDecimal dissipationSlopeLowerLimit;
    /**
     * 施工时间(天)上限
     */
	@TableField("construction_time_upper_limit")
	private BigDecimal constructionTimeUpperLimit;
    /**
     * 施工时间(天)下限
     */
	@TableField("construction_time_lower_limit")
	private BigDecimal constructionTimeLowerLimit;
    /**
     * 桩号
     */
	private String stake;


	public Integer getSluiceId() {
		return sluiceId;
	}

	public void setSluiceId(Integer sluiceId) {
		this.sluiceId = sluiceId;
	}

	public String getSluiceCode() {
		return sluiceCode;
	}

	public void setSluiceCode(String sluiceCode) {
		this.sluiceCode = sluiceCode;
	}

	public String getSluiceName() {
		return sluiceName;
	}

	public void setSluiceName(String sluiceName) {
		this.sluiceName = sluiceName;
	}

	public String getSluiceFullName() {
		return sluiceFullName;
	}

	public void setSluiceFullName(String sluiceFullName) {
		this.sluiceFullName = sluiceFullName;
	}

	public String getSluiceAliasName() {
		return sluiceAliasName;
	}

	public void setSluiceAliasName(String sluiceAliasName) {
		this.sluiceAliasName = sluiceAliasName;
	}

	public String getSluiceType() {
		return sluiceType;
	}

	public void setSluiceType(String sluiceType) {
		this.sluiceType = sluiceType;
	}

	public Integer getCanalId() {
		return canalId;
	}

	public void setCanalId(Integer canalId) {
		this.canalId = canalId;
	}

	public BigDecimal getSluiceFlow() {
		return sluiceFlow;
	}

	public void setSluiceFlow(BigDecimal sluiceFlow) {
		this.sluiceFlow = sluiceFlow;
	}

	public Integer getStrobeNumber() {
		return strobeNumber;
	}

	public void setStrobeNumber(Integer strobeNumber) {
		this.strobeNumber = strobeNumber;
	}

	public String getStrobeType() {
		return strobeType;
	}

	public void setStrobeType(String strobeType) {
		this.strobeType = strobeType;
	}

	public BigDecimal getStrobeHeight() {
		return strobeHeight;
	}

	public void setStrobeHeight(BigDecimal strobeHeight) {
		this.strobeHeight = strobeHeight;
	}

	public BigDecimal getStrobeWidth() {
		return strobeWidth;
	}

	public void setStrobeWidth(BigDecimal strobeWidth) {
		this.strobeWidth = strobeWidth;
	}

	public BigDecimal getStrobeThickness() {
		return strobeThickness;
	}

	public void setStrobeThickness(BigDecimal strobeThickness) {
		this.strobeThickness = strobeThickness;
	}

	public String getMotivityType() {
		return motivityType;
	}

	public void setMotivityType(String motivityType) {
		this.motivityType = motivityType;
	}

	public BigDecimal getMotivityPower() {
		return motivityPower;
	}

	public void setMotivityPower(BigDecimal motivityPower) {
		this.motivityPower = motivityPower;
	}

	public BigDecimal getMotivityVelocity() {
		return motivityVelocity;
	}

	public void setMotivityVelocity(BigDecimal motivityVelocity) {
		this.motivityVelocity = motivityVelocity;
	}

	public String getDissipationType() {
		return dissipationType;
	}

	public void setDissipationType(String dissipationType) {
		this.dissipationType = dissipationType;
	}

	public BigDecimal getDissipationLength() {
		return dissipationLength;
	}

	public void setDissipationLength(BigDecimal dissipationLength) {
		this.dissipationLength = dissipationLength;
	}

	public BigDecimal getDissipationSlopeUpperLimit() {
		return dissipationSlopeUpperLimit;
	}

	public void setDissipationSlopeUpperLimit(BigDecimal dissipationSlopeUpperLimit) {
		this.dissipationSlopeUpperLimit = dissipationSlopeUpperLimit;
	}

	public BigDecimal getDissipationSlopeLowerLimit() {
		return dissipationSlopeLowerLimit;
	}

	public void setDissipationSlopeLowerLimit(BigDecimal dissipationSlopeLowerLimit) {
		this.dissipationSlopeLowerLimit = dissipationSlopeLowerLimit;
	}

	public BigDecimal getConstructionTimeUpperLimit() {
		return constructionTimeUpperLimit;
	}

	public void setConstructionTimeUpperLimit(BigDecimal constructionTimeUpperLimit) {
		this.constructionTimeUpperLimit = constructionTimeUpperLimit;
	}

	public BigDecimal getConstructionTimeLowerLimit() {
		return constructionTimeLowerLimit;
	}

	public void setConstructionTimeLowerLimit(BigDecimal constructionTimeLowerLimit) {
		this.constructionTimeLowerLimit = constructionTimeLowerLimit;
	}

	public String getStake() {
		return stake;
	}

	public void setStake(String stake) {
		this.stake = stake;
	}

	@Override
	protected Serializable pkVal() {
		return this.sluiceId;
	}

	@Override
	public String toString() {
		return "SluiceBase{" +
			"sluiceId=" + sluiceId +
			", sluiceCode=" + sluiceCode +
			", sluiceName=" + sluiceName +
			", sluiceFullName=" + sluiceFullName +
			", sluiceAliasName=" + sluiceAliasName +
			", sluiceType=" + sluiceType +
			", canalId=" + canalId +
			", sluiceFlow=" + sluiceFlow +
			", strobeNumber=" + strobeNumber +
			", strobeType=" + strobeType +
			", strobeHeight=" + strobeHeight +
			", strobeWidth=" + strobeWidth +
			", strobeThickness=" + strobeThickness +
			", motivityType=" + motivityType +
			", motivityPower=" + motivityPower +
			", motivityVelocity=" + motivityVelocity +
			", dissipationType=" + dissipationType +
			", dissipationLength=" + dissipationLength +
			", dissipationSlopeUpperLimit=" + dissipationSlopeUpperLimit +
			", dissipationSlopeLowerLimit=" + dissipationSlopeLowerLimit +
			", constructionTimeUpperLimit=" + constructionTimeUpperLimit +
			", constructionTimeLowerLimit=" + constructionTimeLowerLimit +
			", stake=" + stake +
			"}";
	}
}
