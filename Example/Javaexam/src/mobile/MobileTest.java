package mobile;
	abstract class Mobile {
		private String mobileName;
		private int batterySize;
		private String osType;
		abstract void operate(int time);
		abstract void charge(int time);
		
		public Mobile() {	}
		public Mobile(String mobileName, int batterySize, String osType) {
			this.mobileName=mobileName;
			this.batterySize=batterySize;
			this.osType=osType;
		
		}
		public String getMobileName() {
			return mobileName;
		}
		public void setMobileName(String mobileName) {
			this.mobileName = mobileName;
		}
		public int getBatterySize() {
			return batterySize;
		}
		public void setBatterySize(int batterySize) {
			this.batterySize = batterySize;
		}
		public String getOsType() {
			return osType;
		}
		public void setOsType(String osType) {
			this.osType = osType;
		}

	}

	class Ltab extends Mobile {
		public Ltab() {	}
		public Ltab(String mobileName, int batterySize, String osType) {
			super(mobileName, batterySize, osType);
		}
		public void operate(int time) {
			super.setBatterySize(super.getBatterySize()-(time*10));
		}
		public void charge(int time) {
			super.setBatterySize(super.getBatterySize()+(time*10));
		}
	}
	class Otab extends Mobile {
		public Otab() {	}
		public Otab(String mobileName, int batterySize, String osType) {
			super(mobileName, batterySize, osType);
		}
		public void operate(int time) {
			super.setBatterySize(super.getBatterySize()-(time*12));
		}
		public void charge(int time) {
			super.setBatterySize(super.getBatterySize()+(time*8));
		}
	}

public class MobileTest {

	public static void main(String[] args) {
	
		
		Ltab lt = new Ltab("Ltob", 500, "ABC-01");
		Otab ot = new Otab("Otab", 1000, "XYZ-20");
		
		printTitle();
		printMobile(lt);
		printMobile(ot);
		System.out.println();
		
		System.out.println("[ 10분 충전 ]");
		printTitle();
		lt.charge(10);
		ot.charge(10);
		printMobile(lt);
		printMobile(ot);
		System.out.println();
		
		System.out.println("[ 5분 통화 ]");
		printTitle();
		lt.operate(5);
		ot.operate(5);
		printMobile(lt);
		printMobile(ot);
		System.out.println();
	}
	
	public static void printMobile(Mobile mobile) {			//이부분이 이해가 안됨
		System.out.println(mobile.getMobileName()+"\t"+mobile.getBatterySize()+"\t"+mobile.getOsType());
		
		
	}
	public static void printTitle() {
		System.out.println("Mobile"+"\t"+"Battery"+"\t"+"OS");
		System.out.println("--------------------------");
	}

}
