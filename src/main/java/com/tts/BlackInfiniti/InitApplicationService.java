package com.tts.BlackInfiniti;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import com.tts.BlackInfiniti.Vehicle;

@Service
public class InitApplicationService {

	private static final Logger LOGGER = LoggerFactory.getLogger(InitApplicationService.class);

	@Autowired
	VehicleService vehicleService;

	@Autowired
	ClientService clientService;

	@Autowired
    SaleRequestService saleRequestService;

	@EventListener(ApplicationReadyEvent.class)
	public void initializeTestData() {
		LOGGER.info("Initialize test data");
		
		vehicleService.saveVehicle(new Vehicle(37450, 39660, 2019, "Infiniti", "Q50", "Black", "JN8AY4ND7G3DS9CH2", "CAR", false, 0, 0));
		vehicleService.saveVehicle(new Vehicle(37450, 39660, 2019, "Infiniti", "Q60", "Silver", "JN8C8865712F6VH21", "CAR", false, 0, 0));
		vehicleService.saveVehicle(new Vehicle(39200, 42350, 2020, "Infiniti", "Q50", "Blue", "JN8AY4N297238GG23", "CAR", true, 36, 12000));
		vehicleService.saveVehicle(new Vehicle(59320, 62667, 2019, "Infiniti", "Q60", "Red", "JN8A888SN66C279CF", "CAR", false, 0, 0));
		vehicleService.saveVehicle(new Vehicle(59320, 62667, 2019, "Infiniti", "Q60", "Purple", "JN8AY4HH333LJLK23", "CAR", true, 36, 12000));
		vehicleService.saveVehicle(new Vehicle(61420, 64200, 2020, "Infiniti", "Q60", "Grey", "JN8AY4NJD774DHJ232", "CAR", true, 36, 12000));

		clientService.saveClient(new Client("Abraham", "Lincoln", "555-867-5309", "HonestAbe@wh.gov", "1600 Pennsylvania Avenue"));
		clientService.saveClient(new Client("George", "Washington", "555-704-1776", "Georgie@wh.gov", "1 Delaware Crossing"));
		clientService.saveClient(new Client("Alexander", "Hamilton", "555-987-6543", "Broadway@treasury.gov", "100 42nd St"));

		saleRequestService.saveSaleRequest(new SaleRequest(1L, "FullSale", 4L));
		saleRequestService.saveSaleRequest(new SaleRequest(2L, "Lease", 6L));
		saleRequestService.saveSaleRequest(new SaleRequest(3L, "Finance", 3L));
		saleRequestService.saveSaleRequest(new SaleRequest(3L, "FullSale", 1L));
		
		LOGGER.info("Initialization completed");
	}

}