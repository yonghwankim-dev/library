package member.model.vo;

public class MemberSignUpVO {
	private String mem_name;		// ȸ�� �̸�
	private String mem_email;		// ȸ�� �̸���
	private String pwd;				// ��й�ȣ
	private String confirm_pwd;		// ��й�ȣ Ȯ��
	private String lib_regi_name;	// ������ ��� �̸�

	public MemberSignUpVO(String mem_name, String mem_email, String pwd, String confirm_pwd, String lib_regi_name) {
		this.mem_name = mem_name;
		this.mem_email = mem_email;
		this.pwd = pwd;
		this.confirm_pwd = confirm_pwd;
		this.lib_regi_name = lib_regi_name;
	}
	
	public String getMem_name() {
		return mem_name;
	}
	public String getMem_email() {
		return mem_email;
	}
	public String getPwd() {
		return pwd;
	}
	public String getConfirm_pwd() {
		return confirm_pwd;
	}
	public String getLib_regi_name() {
		return lib_regi_name;
	}
	
	
}
