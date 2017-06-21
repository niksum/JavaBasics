package com.niksum.java.designPattern.behavioral;

enum APPROVAL_LEVEL {
	TECHNICAL_LEAD(5), PROJECT_LEAD(6), PROJECT_MANAGER(7);
	private int value;
	APPROVAL_LEVEL(int p) {
		value = p;
	}
	
	public int getValue(){
		return this.value;
	}
	
}

abstract class ApprovableRequest {
	protected APPROVAL_LEVEL defaultLevel = APPROVAL_LEVEL.TECHNICAL_LEAD;

	public abstract void whoCanDo();
}

class BroadBandBill extends ApprovableRequest {

	BroadBandBill(){
		whoCanDo();
	}
	@Override
	public void whoCanDo() {
		System.out.println("Setting up level for Broadband bill ");
		defaultLevel = APPROVAL_LEVEL.PROJECT_LEAD;
	}

}

class LunchBill extends ApprovableRequest {
	LunchBill(){
		whoCanDo();
	}
	@Override
	public void whoCanDo() {
		System.out.println("Setting up level for LunchBill bill ");
		defaultLevel = APPROVAL_LEVEL.TECHNICAL_LEAD;
	}

}

class TravelBill extends ApprovableRequest {
	TravelBill(){
		whoCanDo();
	}
	@Override
	public void whoCanDo() {
		System.out.println("Setting up level for TravelBill bill ");
		defaultLevel = APPROVAL_LEVEL.PROJECT_MANAGER;
	}

}

class TechnicalLeadApproval extends Approver {
	TechnicalLeadApproval() {
		System.out.println("TechnicalLeadApproval constructor");
		level = APPROVAL_LEVEL.TECHNICAL_LEAD;
	}

	@Override
	public void approve(ApprovableRequest re) {
		System.out.println("TechnicalLeadApproval approving this");
	}
}

class ProjectLeadApproval extends Approver {
	ProjectLeadApproval() {
		System.out.println("ProjectLeadApproval constructor");
		level = APPROVAL_LEVEL.PROJECT_LEAD;
	}

	@Override
	public void approve(ApprovableRequest re) {
		System.out.println("ProjectLeadApproval approving this");
	}
}

class MangerApproval extends Approver {
	MangerApproval() {
		System.out.println("MangerApproval constructor");
		level = APPROVAL_LEVEL.PROJECT_MANAGER;
	}

	@Override
	public void approve(ApprovableRequest re) {
		System.out.println("MangerApproval approving this");
	}
}

abstract class Approver {
	protected Approver nextApprover;
	public APPROVAL_LEVEL level;

	public Approver getNextApprover() {
		return nextApprover;
	}

	public void setNextApprover(Approver nextApprover) {
		this.nextApprover = nextApprover;
	}

	public void handler(ApprovableRequest re) {
		if (this.level.getValue() >= re.defaultLevel.getValue())
			approve(re);
		if(this.nextApprover!=null)
			this.nextApprover.handler(re);

	}

	public abstract void approve(ApprovableRequest re);
}

public class ChainOfResponsibilityPattern {
	public static void main(String[] args) {
		Approver plApproval = new ProjectLeadApproval();
		Approver tlApproval = new TechnicalLeadApproval();
		Approver pmApprover = new MangerApproval();
		tlApproval.setNextApprover(plApproval);
		plApproval.setNextApprover(pmApprover);
		
		BroadBandBill bbBill = new BroadBandBill();
		TravelBill ttBill = new TravelBill();
		LunchBill lBill = new LunchBill();
		System.out.println();
		tlApproval.handler(bbBill);
		System.out.println();
		tlApproval.handler(lBill);
		System.out.println();
		tlApproval.handler(ttBill);
		
	}
}
