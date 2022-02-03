package member.model.vo;

import java.sql.Date;
import java.time.LocalDate;

public class MemberLoginedVO {
	private int mem_num;
	private String mem_name;
	private String mem_email;
	private int loan_num;
	private int rsr_num;
	private Date due_date;
	private Date mtl_loan_date;
	
	public MemberLoginedVO(int mem_num, String mem_name, String mem_email, int loan_num, int rsr_num,
			Date due_date, Date mtl_loan_date) {
		this.mem_num = mem_num;
		this.mem_name = mem_name;
		this.mem_email = mem_email;
		this.loan_num = loan_num;
		this.rsr_num = rsr_num;
		this.due_date = due_date;
		this.mtl_loan_date = mtl_loan_date;
	}
	
	public int getMem_num() {
		return mem_num;
	}
	public String getMem_name() {
		return mem_name;
	}
	public String getMem_email() {
		return mem_email;
	}
	public int getLoan_num() {
		return loan_num;
	}
	public int getRsr_num() {
		return rsr_num;
	}
	public Date getDue_date() {
		return due_date;
	}
	public Date getMtl_loan_date() {
		return mtl_loan_date;
	}

	
	
}
