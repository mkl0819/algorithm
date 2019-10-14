import java.util.Comparator;
import java.util.PriorityQueue;

public class mobis01 {

	public static void main(String[] args) throws Exception {
		
	}
	public String solution(int n, String[] plates, int[] odo, int k, int[] drives) {        
        PriorityQueue<Car> carQueue = new PriorityQueue<>(new compCar());
        
        for(int i=0; i<n; i++) {
        	carQueue.add(new Car(plates[i], odo[i]));
        }
        
        Car firstCar;
        
        for(int i=0, size=drives.length; i<size; i++) {
        	firstCar = carQueue.poll();
        	firstCar.odo += drives[i];
        	carQueue.offer(firstCar);
        }
        
        return carQueue.poll().plate;
    }
}
class Car {
	String plate;
	int odo;
	public Car() {
	}
	public Car(String plate, int odo) {
		super();
		this.plate = plate;
		this.odo = odo;
	}
	
}
class compCar implements Comparator<Car>{

	@Override
	public int compare(Car o1, Car o2) {
		if(o1.odo == o2.odo) {
			return o1.plate.compareTo(o2.plate);
		}
		return o1.odo - o2.odo;
	}
	
}