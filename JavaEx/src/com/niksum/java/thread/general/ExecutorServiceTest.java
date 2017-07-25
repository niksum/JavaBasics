package com.niksum.java.thread.general;

import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Truck {
	private int plates;
	private boolean inprogress;

	public Truck() {
	}

	public Truck(int plates) {
		this.plates = plates;
	}

	public int getPlates() {
		return plates;
	}

	public void setPlates(int plates) {
		this.plates = plates;
	}

	public boolean isInprogress() {
		return inprogress;
	}

	public void setInprogress(boolean inprogress) {
		this.inprogress = inprogress;
	}

	// It is VERY IMPORTANT to implement hasCode() and equals() on classes
	// that will be "stored" in a HashMap
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + plates;
		result = prime * result + (inprogress ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Truck other = (Truck) obj;
		if (plates != other.plates)
			return false;
		if (inprogress != other.inprogress)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Truck [plates=" + plates + "]";
	}
}

class DistributionCenterTruckQueue implements Callable<Truck> {
	public static enum OPERATION {
		ARRIVAL, DEPARTURE, INPROGRESS
	}

	private IDistribuitionCenterVehicleService<Truck> truckService;

	private Truck vehicle;
	private OPERATION operation;

	public DistributionCenterTruckQueue() {
	}

	public DistributionCenterTruckQueue(Truck vehicle, OPERATION operation) {
		this.vehicle = vehicle;
		this.operation = operation;

		this.truckService = new DistribuitionCenterTruckService();
	}

	@Override
	public Truck call() throws Exception {

		switch (this.operation) {
		case ARRIVAL:
			System.out.print("Arriving: ");
			this.truckService.arrivalQueue(this.vehicle);
			break;
		case DEPARTURE:
			System.out.print("Departing: ");
			this.truckService.departureQueue(this.vehicle);
			break;
		case INPROGRESS:
			System.out.print("In Progress: ");
			this.vehicle.setInprogress(this.truckService.unloadInProgress(this.vehicle));
			break;
		}

		return this.vehicle;
	}
}

interface IDistribuitionCenterVehicleService<T> {
	public void arrivalQueue(T vehicle);

	public boolean unloadInProgress(T vehicle);

	public void departureQueue(T vehicle);
}

class DistribuitionCenterTruckService implements IDistribuitionCenterVehicleService<Truck> {
	// Ensure that ONLY ONE ConcurrentHashMap is used for every thread
	private static final ConcurrentMap<Truck, Long> vehicleQueue = new ConcurrentHashMap();

	@Override
	public void arrivalQueue(Truck vehicle) {
		long currentTime = System.currentTimeMillis();
		DistribuitionCenterTruckService.vehicleQueue.putIfAbsent(vehicle, currentTime);
	}

	@Override
	public boolean unloadInProgress(Truck vehicle) {
		return DistribuitionCenterTruckService.vehicleQueue.get(vehicle) != null;
	}

	@Override
	public void departureQueue(Truck vehicle) {
		DistribuitionCenterTruckService.vehicleQueue.remove(vehicle);
	}
}

public class ExecutorServiceTest {
	// I tested it with up to 10,000 Trucks (threads) without any problems
	private static final int NUM_OF_TRUCKS = 15;
	private static final Truck[] truckList = new Truck[ExecutorServiceTest.NUM_OF_TRUCKS];

	private static int random(int m, int n) {
		return (int) (Math.random() * (n - m + 1)) + m;
	}

	public static void main(String[] args) {
		// Create NUM_OF_TRUCKS Trucks
		for (int i = 0; i < ExecutorServiceTest.NUM_OF_TRUCKS; i++) {
			ExecutorServiceTest.truckList[i] = new Truck(ExecutorServiceTest.random(1000, 5000));
		}

		// Create NUM_OF_TRUCKS Threads
		ExecutorService executorService = Executors.newFixedThreadPool(ExecutorServiceTest.NUM_OF_TRUCKS);
		// Create NUM_OF_TRUCKS Callables with random operations (ARRIVAL or
		// DEPARTURE)
		DistributionCenterTruckQueue[] distributionCenterTruckQueue = new DistributionCenterTruckQueue[ExecutorServiceTest.NUM_OF_TRUCKS];
		for (int i = 0; i < ExecutorServiceTest.NUM_OF_TRUCKS; i++) {
			distributionCenterTruckQueue[i] = new DistributionCenterTruckQueue(ExecutorServiceTest.truckList[i],
					DistributionCenterTruckQueue.OPERATION.values()[ExecutorServiceTest.random(0, 1)]);
		}
		// Execute the Callables and get the result of each operation
		for (int i = 0; i < ExecutorServiceTest.NUM_OF_TRUCKS; i++) {
			try {
				ExecutorServiceTest.truckList[i] = executorService.submit(distributionCenterTruckQueue[i]).get();
				System.out.println(ExecutorServiceTest.truckList[i]);
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace(System.err);
			}
		}

		// Those trucks that have not been removed (DEPARTURE), are still "in
		// progress" (INPROGRESS)
		for (int i = 0; i < ExecutorServiceTest.NUM_OF_TRUCKS; i++) {
			try {
				distributionCenterTruckQueue[i] = new DistributionCenterTruckQueue(ExecutorServiceTest.truckList[i],
						DistributionCenterTruckQueue.OPERATION.INPROGRESS);
				Truck truck = executorService.submit(distributionCenterTruckQueue[i]).get();
				System.out.println(truck.isInprogress() ? truck + ": True" : truck + ": False");
			} catch (InterruptedException | ExecutionException e) {
				e.printStackTrace(System.err);
			}
		}

		// Don't forget to shutdown the ExecutionService
		executorService.shutdown();
	}
}