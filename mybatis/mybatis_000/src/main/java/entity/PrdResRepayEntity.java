package entity;

import java.math.BigDecimal;
import java.sql.Date;

@SuppressWarnings("serial")
public class PrdResRepayEntity {
	private Integer reserveId;
	private Integer periods;
	private BigDecimal repayAmount;// 回款收益
	private BigDecimal repayCapital;// 回款本金
	private Date startDate;
	private Date endDate;// 预计回款日期
	private Date actualRepayDate;
	private String repayNo;
	private Integer status;
	private Integer releaseStatus;
	private Integer source;

	public Integer getSource() {
		return source;
	}

	public void setSource(Integer source) {
		this.source = source;
	}

	public Integer getReserveId() {
		return reserveId;
	}

	public void setReserveId(Integer reserveId) {
		this.reserveId = reserveId;
	}

	public Integer getPeriods() {
		return periods;
	}

	public void setPeriods(Integer periods) {
		this.periods = periods;
	}

	public BigDecimal getRepayAmount() {
		return repayAmount;
	}

	public void setRepayAmount(BigDecimal repayAmount) {
		this.repayAmount = repayAmount;
	}

	public BigDecimal getRepayCapital() {
		return repayCapital;
	}

	public void setRepayCapital(BigDecimal repayCapital) {
		this.repayCapital = repayCapital;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Date getActualRepayDate() {
		return actualRepayDate;
	}

	public void setActualRepayDate(Date actualRepayDate) {
		this.actualRepayDate = actualRepayDate;
	}

	public String getRepayNo() {
		return repayNo;
	}

	public void setRepayNo(String repayNo) {
		this.repayNo = repayNo;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getReleaseStatus() {
		return releaseStatus;
	}

	public void setReleaseStatus(Integer releaseStatus) {
		this.releaseStatus = releaseStatus;
	}

}
