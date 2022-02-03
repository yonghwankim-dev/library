package member.model.vo;

public class MemberLoginVO {
	private String mem_email;	// 이메일
	private String pwd;			// 비밀번호
	
	public MemberLoginVO(String mem_email, String pwd) {
		this.mem_email = mem_email;
		this.pwd = pwd;
	}
	
	public String getMem_email() {
		return mem_email;
	}
	public String getPwd() {
		return pwd;
	}	
}
