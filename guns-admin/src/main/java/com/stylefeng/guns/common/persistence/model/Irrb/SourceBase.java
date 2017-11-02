package com.stylefeng.guns.common.persistence.model.Irrb;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 水源信息
 * </p>
 *
 * @author hnsl
 * @since 2017-10-20
 */
@TableName("source_base")
public class SourceBase extends Model<SourceBase> {

    private static final long serialVersionUID = 1L;

    /**
     * 水源编码
     */
	@TableId(value="source_id", type= IdType.AUTO)
	private Integer sourceId;
    /**
     * 水源编码
     */
	@TableField("source_code")
	private String sourceCode;
    /**
     * 水源名称
     */
	@TableField("source_name")
	private String sourceName;
    /**
     * 水源工程类型
     */
	@TableField("source_type_b")
	private String sourceTypeB;
    /**
     * 水源类型
     */
	@TableField("source_type_s")
	private String sourceTypeS;
    /**
     * 创建时间
     */
	private Date created;
    /**
     * 更新时间
     */
	private Date modified;


	public Integer getSourceId() {
		return sourceId;
	}

	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}

	public String getSourceCode() {
		return sourceCode;
	}

	public void setSourceCode(String sourceCode) {
		this.sourceCode = sourceCode;
	}

	public String getSourceName() {
		return sourceName;
	}

	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	public String getSourceTypeB() {
		return sourceTypeB;
	}

	public void setSourceTypeB(String sourceTypeB) {
		this.sourceTypeB = sourceTypeB;
	}

	public String getSourceTypeS() {
		return sourceTypeS;
	}

	public void setSourceTypeS(String SourceTypeS) {
		this.sourceTypeS = SourceTypeS;
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
		return this.sourceId;
	}

	@Override
	public String toString() {
		return "SourceBase{" +
			"sourceId=" + sourceId +
			", sourceCode=" + sourceCode +
			", sourceName=" + sourceName +
			", sourceTypeB=" + sourceTypeB +
			", sourceTypeS=" + sourceTypeS +
			", created=" + created +
			", modified=" + modified +
			"}";
	}
}
