package entity;

import java.util.Date;
import java.util.List;

public class ReservationSearchQueryDto {
	private Integer entId;
	private String reservationNo;
	private Date startCreateTime;
	private Date endCreateTime;
	private String productName;
	private Date startReservationDate;
	private Date endReservationDate;
	private String customerName;
	private String mobile;
	private String advisorName;
	private String advisorMobile;
	private Integer status;
	private List<Integer> statusList;
	private Integer reserveSource;
	private Date startPerformanceDate;
	private Date endPerformanceDate;
	private String contractNo;
	private Date startPayDate;// 打款日期
	private Date endPayDate;
	private Date startValueDate;// 起息日
	private Date endValueDate;
	private Date startExpiryDate;// 到期日
	private Date endExpiryDate;
	private Integer reVisitFunc;
	private Integer reVisitResult;

	private Integer productId;
	private String productNo;
	private String deptCode;
	private Integer deleted;
	private String categoryName;
	private Integer investorId;
	private Integer ifaId;
	private String contractCode;
	private String ownerName;
	private String insuranceCompanyName;
	private Integer customerId;
	private String faName;
	private String ifaName;
	private String faMobile;
	private String ifaMobile;
	private Integer faId;
	private Integer repayPlanStatus;
	private Integer categoryId;
	private Integer thirdCompanyId;
	private String signName;
	private String signPhone;
	private List<String> deptCodeList;

	public Integer getRepayPlanStatus() {
		return repayPlanStatus;
	}

	public void setRepayPlanStatus(Integer repayPlanStatus) {
		this.repayPlanStatus = repayPlanStatus;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public Integer getEntId() {
		return entId;
	}

	public void setEntId(Integer entId) {
		this.entId = entId;
	}

	public String getReservationNo() {
		return reservationNo;
	}

	public void setReservationNo(String reservationNo) {
		this.reservationNo = reservationNo;
	}

	public Date getStartCreateTime() {
		return startCreateTime;
	}

	public void setStartCreateTime(Date startCreateTime) {
		this.startCreateTime = startCreateTime;
	}

	public Date getEndCreateTime() {
		return endCreateTime;
	}

	public void setEndCreateTime(Date endCreateTime) {
		this.endCreateTime = endCreateTime;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getStartReservationDate() {
		return startReservationDate;
	}

	public void setStartReservationDate(Date startReservationDate) {
		this.startReservationDate = startReservationDate;
	}

	public Date getEndReservationDate() {
		return endReservationDate;
	}

	public void setEndReservationDate(Date endReservationDate) {
		this.endReservationDate = endReservationDate;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAdvisorName() {
		return advisorName;
	}

	public void setAdvisorName(String advisorName) {
		this.advisorName = advisorName;
	}

	public String getAdvisorMobile() {
		return advisorMobile;
	}

	public void setAdvisorMobile(String advisorMobile) {
		this.advisorMobile = advisorMobile;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getReserveSource() {
		return reserveSource;
	}

	public void setReserveSource(Integer reserveSource) {
		this.reserveSource = reserveSource;
	}

	public Date getStartPerformanceDate() {
		return startPerformanceDate;
	}

	public void setStartPerformanceDate(Date startPerformanceDate) {
		this.startPerformanceDate = startPerformanceDate;
	}

	public Date getEndPerformanceDate() {
		return endPerformanceDate;
	}

	public void setEndPerformanceDate(Date endPerformanceDate) {
		this.endPerformanceDate = endPerformanceDate;
	}

	public String getContractNo() {
		return contractNo;
	}

	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}

	public Date getStartPayDate() {
		return startPayDate;
	}

	public void setStartPayDate(Date startPayDate) {
		this.startPayDate = startPayDate;
	}

	public Date getEndPayDate() {
		return endPayDate;
	}

	public void setEndPayDate(Date endPayDate) {
		this.endPayDate = endPayDate;
	}

	public Date getStartValueDate() {
		return startValueDate;
	}

	public void setStartValueDate(Date startValueDate) {
		this.startValueDate = startValueDate;
	}

	public Date getEndValueDate() {
		return endValueDate;
	}

	public void setEndValueDate(Date endValueDate) {
		this.endValueDate = endValueDate;
	}

	public Date getStartExpiryDate() {
		return startExpiryDate;
	}

	public void setStartExpiryDate(Date startExpiryDate) {
		this.startExpiryDate = startExpiryDate;
	}

	public Date getEndExpiryDate() {
		return endExpiryDate;
	}

	public void setEndExpiryDate(Date endExpiryDate) {
		this.endExpiryDate = endExpiryDate;
	}

	public Integer getReVisitFunc() {
		return reVisitFunc;
	}

	public void setReVisitFunc(Integer reVisitFunc) {
		this.reVisitFunc = reVisitFunc;
	}

	public Integer getReVisitResult() {
		return reVisitResult;
	}

	public void setReVisitResult(Integer reVisitResult) {
		this.reVisitResult = reVisitResult;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
    public String getProductNo() {
        return productNo;
    }
    
    public void setProductNo(String productNo) {
        this.productNo = productNo;
    }

    public String getDeptCode() {
		return deptCode;
	}

	public void setDeptCode(String deptCode) {
		this.deptCode = deptCode;
	}

	public Integer getDeleted() {
		return deleted;
	}

	public void setDeleted(Integer deleted) {
		this.deleted = deleted;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public Integer getInvestorId() {
		return investorId;
	}

	public void setInvestorId(Integer investorId) {
		this.investorId = investorId;
	}

	public Integer getIfaId() {
		return ifaId;
	}

	public void setIfaId(Integer ifaId) {
		this.ifaId = ifaId;
	}

	public String getContractCode() {
		return contractCode;
	}

	public void setContractCode(String contractCode) {
		this.contractCode = contractCode;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getInsuranceCompanyName() {
		return insuranceCompanyName;
	}

	public void setInsuranceCompanyName(String insuranceCompanyName) {
		this.insuranceCompanyName = insuranceCompanyName;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getFaName() {
		return faName;
	}

	public void setFaName(String faName) {
		this.faName = faName;
	}

	public String getIfaName() {
		return ifaName;
	}

	public void setIfaName(String ifaName) {
		this.ifaName = ifaName;
	}

	public String getFaMobile() {
		return faMobile;
	}

	public void setFaMobile(String faMobile) {
		this.faMobile = faMobile;
	}

	public String getIfaMobile() {
		return ifaMobile;
	}

	public void setIfaMobile(String ifaMobile) {
		this.ifaMobile = ifaMobile;
	}

	public Integer getFaId() {
		return faId;
	}

	public void setFaId(Integer faId) {
		this.faId = faId;
	}

	public Integer getThirdCompanyId() {
		return thirdCompanyId;
	}

	public void setThirdCompanyId(Integer thirdCompanyId) {
		this.thirdCompanyId = thirdCompanyId;
	}

	public String getSignName() {
		return signName;
	}

	public void setSignName(String signName) {
		this.signName = signName;
	}

	public String getSignPhone() {
		return signPhone;
	}

	public void setSignPhone(String signPhone) {
		this.signPhone = signPhone;
	}

	public List<String> getDeptCodeList() {
		return deptCodeList;
	}

	public void setDeptCodeList(List<String> deptCodeList) {
		this.deptCodeList = deptCodeList;
	}

	public List<Integer> getStatusList() {
		return statusList;
	}

	public void setStatusList(List<Integer> statusList) {
		this.statusList = statusList;
	}
}
