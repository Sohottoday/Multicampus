package work;

	abstract class Plane {
		private String planeName;
		private int fuelSize;
		
		public Plane() { 	}
		public Plane(String planeName, int fuelSize) {
			this.planeName=planeName;
			this.fuelSize=fuelSize;
		}
		public String getPlaneName() {
			return planeName;
		}
		public void setPlaneName(String planeName) {
			this.planeName = planeName;
		}
		public int getFuelSize() {
			return fuelSize;
		}
		public void setFuelSize(int fuelSize) {
			this.fuelSize = fuelSize;
		}
		public abstract void flight(int distance);
		public void refuel(int fuel) {
			//setFuelSize(getFuelSize()+fuel);
			fuelSize+=fuel;
		}
		
	}
	class Airplane extends Plane {
		public Airplane() {	}
		public Airplane(String planeName, int fuelSize) {
			super(planeName, fuelSize);
		}
		public void flight(int distance) {
			super.setFuelSize(super.getFuelSize()-(distance*3));
		}
	}
	class Cargoplane extends Plane {
		public Cargoplane() {	}
		public Cargoplane(String planeName, int fuelSize) {
			super(planeName, fuelSize);
		}
		public void flight(int distance) {
			//super.setFuelSize(super.getFuelSize()-(distance*5));
			setFuelSize(getFuelSize()-(distance*5));
		}
	}
public class PlaneTest {

	public static void main(String[] args) {
		Plane [ ] pl = new Plane[2];
		pl[0] = new Airplane("L747", 1000);
		pl[1] = new Cargoplane("C40", 1000);
		
		printInfo(pl);
		System.out.println();
		
		System.out.println("[ 100 운항 ]");
		pl[0].flight(100);
		pl[1].flight(100);
		printInfo(pl);
		System.out.println();
		
		System.out.println("[ 200 주유 ]");
		pl[0].refuel(200);
		pl[1].refuel(200);
		printInfo(pl);
		System.out.println();
		
	}
	public static void printInfo(Plane [] list) {
		System.out.println("Plane"+"\t"+"fuelSize");
		System.out.println("----------------------");
		
		for(Plane data : list) {		//이부분에서 너무 막힘 머리가 안돌아감
			System.out.println(data.getPlaneName()+"\t"+data.getFuelSize());
		}
	}
}
