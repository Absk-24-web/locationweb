package com.absk.location.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.absk.location.entites.Location;
import com.absk.location.service.LocationService;

@Controller
public class LocationController {

	@Autowired
	LocationService service;

	@RequestMapping(value = "/showCreate", method = RequestMethod.GET)
	public String showCreate() {
		return "createLocation";

	}

	@RequestMapping("/saveLoc")
	public String saveLocation(@ModelAttribute("location") Location location, ModelMap modelmap ) {
		Location locationsaved = service.saveLocation(location);
		String msg = "Location saved with id:" + locationsaved.getId();
		modelmap.addAttribute("msg",msg);
		return "createLocation";
	}
	
	@RequestMapping("/displayLocations")
	public String displayLocation(ModelMap modelmap) {
		List<Location> locations = service.getAllLocation();
		modelmap.addAttribute("locations",locations);
		return "displayLocations";
	} 
	
	@RequestMapping("/deleteLocation")
	public String deleteLocation(@RequestParam("id")int id, ModelMap modelMap) {
//		Location location = service.getLocationById(id);
		Location location = new Location();
		location.setId(id);
		service.deleteLocation(location);
		List<Location> locations = service.getAllLocation();
		modelMap.addAttribute("locations",locations);
		return "displayLocations";	
		}
	
	@RequestMapping("/showUpdate")
	public String showUpdate(@RequestParam("id")int id, ModelMap modelMap) {
		Location location = service.getLocationById(id);
		modelMap.addAttribute("location", location);
		return "updateLocation";
	}
	
	@RequestMapping("/updateLoc")
	public String updateLocation(@ModelAttribute("location") Location location, ModelMap modelMap) {
		service.updateLocation(location);
		List<Location> locations = service.getAllLocation();
		modelMap.addAttribute("locations",locations);
		return "displayLocations";
	}
	
	
	 

}
