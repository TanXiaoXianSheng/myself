package enums;

public enum ReservationStatus {
	TOBEACCEPTED(0, "待咨询顾问受理"),
	ACCEPTING(1, "受理中(待审核)"),
	AUDITED(2, "受理中(待签约)"),
	SIGNED(3, "已签约"),
	RECEIVING(4,"回款中"),//类固收产品
	EXPIRED(5, "已结束"),//类固收产品
	FAILED(-1, "预约服务不成功"),

	CONFIRMACCOUNT(6, "受理中(到账待确认)"),
	GETACCOUNT(7, "已到账(待签约)")
	;
	public Integer key;
	public String value;

	ReservationStatus(Integer key, String value) {
		this.key = key;
		this.value = value;
	}
}
