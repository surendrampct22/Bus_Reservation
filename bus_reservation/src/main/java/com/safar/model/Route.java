package com.safar.model;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Data
@Entity
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer routeID;

    @NotNull(message = "Start point cannot be null !")
	@NotBlank(message = "Start point cannot be blank !")
	@NotEmpty(message = "Start point cannot be empty !")
    private String routeFrom;

	@NotNull(message = "Destination point cannot be null !")
	@NotBlank(message = "Destination point cannot be blank !")
	@NotEmpty(message = "Destination point cannot be empty !")
    private String routeTo;
    private Integer distance;

    @JsonIgnore
    @OneToMany(mappedBy = "route", cascade = CascadeType.ALL)
    private List<Bus> busList = new ArrayList<>();


    public Route(String routeFrom, String routeTo, Integer distance) {
        this.routeFrom = routeFrom;
        this.routeTo = routeTo;
        this.distance = distance;
        
        
    }


	public Integer getRouteID() {
		return routeID;
	}


	public void setRouteID(Integer routeID) {
		this.routeID = routeID;
	}


	public String getRouteFrom() {
		return routeFrom;
	}


	public void setRouteFrom(String routeFrom) {
		this.routeFrom = routeFrom;
	}


	public String getRouteTo() {
		return routeTo;
	}


	public void setRouteTo(String routeTo) {
		this.routeTo = routeTo;
	}


	public Integer getDistance() {
		return distance;
	}


	public void setDistance(Integer distance) {
		this.distance = distance;
	}


	public List<Bus> getBusList() {
		return busList;
	}


	public void setBusList(List<Bus> busList) {
		this.busList = busList;
	}
}
