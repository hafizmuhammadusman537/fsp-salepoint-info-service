package com.fsp.salepoint.controller;

import com.fsp.salepoint.model.SalePoint;
import com.fsp.salepoint.repository.AddressRepository;
import com.fsp.salepoint.repository.SalePointRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@CrossOrigin
//@RequestMapping("/api/salepoints")
public class SalePointController {

	@Autowired
	private SalePointRepository salepointrepository;

	@Autowired
	private AddressRepository addressRepository;

	@GetMapping("/all")
	private List<SalePoint> getAllSalePoints()
	{
		return salepointrepository.findAll();
	}

//	@GetMapping("")
//	private ItemCatalog getAllSalePoints()
//	{
////		System.out.println("List of Items" + restTemplate.getForObject("http://localhost:8082/api/items/1",Item.class));
//
//		return restTemplate.getForObject("http://localhost:8082/api/salepoints/9/items", ItemCatalog.class);
//	}

	@GetMapping("/{id}")
	private SalePoint getSalePoint(@PathVariable Long id)
	{
		return salepointrepository.findById(id).get();
	}

	@GetMapping("/users/{ownerId}")
	private SalePoint getSalePointByUser(@PathVariable Long ownerId)
	{
		return salepointrepository.findBySalePointOwner(ownerId);
	}

	// returns all salepoints by getting city
	@GetMapping("/city/{city}")
	private List<SalePoint> getSalePointByCity(@PathVariable String city)
	{
		System.out.println("getSalePointByCity(): is working");
		return salepointrepository.findByAddressCity(city);
	}

	@PostMapping("")
	private SalePoint addSalePoint(@RequestBody SalePoint newSalePoint)
	{
		//addressRepository.save(newSalePoint.getAddress());
		newSalePoint.setAddress(addressRepository.save(newSalePoint.getAddress()));
		return salepointrepository.save(newSalePoint);
//		return restTemplate.getForObject("http://localhost:8083/api/salepoints/"+newSalePoint.getId(), SalePoint.class);
	}

	@DeleteMapping("/{id}")
	void deleteSalePoint(@PathVariable Long id)
	{
		addressRepository.deleteById(salepointrepository.getOne(id).getAddress().getId());
		salepointrepository.deleteById(id);
	}

	@PutMapping("/{id}/rating")
	private void setRating(@RequestBody Float rating, @PathVariable Long id){
		salepointrepository.getOne(id).setRating(rating);
		salepointrepository.saveAndFlush(salepointrepository.getOne(id));
	}

	@PutMapping("/{id}")
	private ResponseEntity<SalePoint> updateSalePoint(@RequestBody SalePoint newSalePoint, @PathVariable Long id) {

		return salepointrepository.findById(id)
				.map(salepoint -> {

					JSONObject jsonObj = new JSONObject(newSalePoint);

					if (jsonObj.has("name")){
						salepoint.setName(jsonObj.getString("name"));
					}

					if (jsonObj.has("ranking"))
						salepoint.setRating(jsonObj.getFloat("ranking"));

					if (jsonObj.has("photo"))
						salepoint.setPhoto(jsonObj.getString("photo"));

					if (jsonObj.has("description"))
						salepoint.setDescription(jsonObj.getString("description"));

					if (jsonObj.has("isActive"))
						salepoint.setIsActive(jsonObj.get("isActive").toString().charAt(0));

					if (jsonObj.has("deliveryAreaDistance"))
						salepoint.setDeliveryAreaDistance(jsonObj.getFloat("deliveryAreaDistance"));

//					if (jsonObj.has("longitude"))
//						salepoint.setLongitude(jsonObj.getFloat("longitude"));
//
//					if (jsonObj.has("lattitude"))
//						salepoint.setLattitude(jsonObj.getFloat("lattitude"));
//
//					if (jsonObj.has("postelAddress"))
//						salepoint.setPostelAddress(jsonObj.getString("postelAddress"));
//
//					if (jsonObj.has("city"))
//						salepoint.setCity(jsonObj.getString("city"));

					if (jsonObj.has("registeredAt"))
						salepoint.setRegisteredAt(Timestamp.valueOf(jsonObj.getString("registeredAt")));

					if (jsonObj.has("confirmedAt"))
						salepoint.setConfirmedAt(Timestamp.valueOf(jsonObj.getString("confirmedAt")));

					if (jsonObj.has("salePointOwner"))
						salepoint.setSalePointOwner(jsonObj.getLong("salePointOwner"));

//					if (jsonObj.has("items")){
//
//						List<Item> items = new ArrayList<>();
//
//						JSONArray jsonArray = jsonObj.getJSONArray("items");
//
//						for (int i = 0; i < jsonArray.length(); i++) {
//
//							Integer itemId = ((JSONObject)jsonArray.get(i)).getInt("id");
//							items.add((new Item()).setId(itemId));
//						}
//
//						salepoint.setItems(items);
//						salepointrepository.save(salepoint);
//					}
					if (jsonObj.has("address"))
					{
						salepoint.setAddress(newSalePoint.getAddress());
					}

					salepointrepository.save(salepoint);

					return ResponseEntity.ok(salepointrepository.findById(id).get());

				}).orElseThrow(()-> new ResourceNotFoundException("SalePoint Not found for this id:: " + id));
	}
}