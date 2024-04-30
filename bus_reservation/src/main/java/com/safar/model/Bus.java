package com.safar.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer busId;

    @NotBlank(message = "Bus name can't be null/blank, Please provide a valid name first!")
    private String busName;

    @NotBlank(message = "Driver name can't be null/blank, Please provide a valid name first!")
    private String driverName;

    @NotBlank(message = "Bus Type can't be null/blank, Please provide a valid bus type")
    private String busType;

    @NotBlank(message = "Choose a valid starting point.")
    private String routeFrom;

    @NotBlank(message = "Choose a valid destination.")
    private String routeTo;

    @NotNull(message = "Bus Journey Date can't be null, Please provide correct date")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate busJourneyDate;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime arrivalTime;

    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime departureTime;

    @Column(name = "total_seats")
    private Integer seats;

    private Integer availableSeats;

    @NotNull(message = "fare can't be null")
    private Integer fare;

    @ManyToOne(cascade = CascadeType.ALL)
    private Route route;

    @JsonIgnore
    @OneToMany(mappedBy = "bus",cascade = CascadeType.ALL)
    private List<Reservation> reservationList = new ArrayList<>();

	public Bus(Integer busId,
			@NotBlank(message = "Bus name can't be null/blank, Please provide a valid name first!") String busName,
			@NotBlank(message = "Driver name can't be null/blank, Please provide a valid name first!") String driverName,
			@NotBlank(message = "Bus Type can't be null/blank, Please provide a valid bus type") String busType,
			@NotBlank(message = "Choose a valid starting point.") String routeFrom,
			@NotBlank(message = "Choose a valid destination.") String routeTo,
			@NotNull(message = "Bus Journey Date can't be null, Please provide correct date") LocalDate busJourneyDate,
			LocalTime arrivalTime, LocalTime departureTime, Integer seats, Integer availableSeats,
			@NotNull(message = "fare can't be null") Integer fare, Route route, List<Reservation> reservationList) {
		super();
		this.busId = busId;
		this.busName = busName;
		this.driverName = driverName;
		this.busType = busType;
		this.routeFrom = routeFrom;
		this.routeTo = routeTo;
		this.busJourneyDate = busJourneyDate;
		this.arrivalTime = arrivalTime;
		this.departureTime = departureTime;
		this.seats = seats;
		this.availableSeats = availableSeats;
		this.fare = fare;
		this.route = route;
		this.reservationList = reservationList;
	}

	public Integer getBusId() {
		return busId;
	}

	public void setBusId(Integer busId) {
		this.busId = busId;
	}

	public String getBusName() {
		return busName;
	}

	public void setBusName(String busName) {
		this.busName = busName;
	}

	public String getDriverName() {
		return driverName;
	}

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
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

	public LocalDate getBusJourneyDate() {
		return busJourneyDate;
	}

	public void setBusJourneyDate(LocalDate busJourneyDate) {
		this.busJourneyDate = busJourneyDate;
	}

	public LocalTime getArrivalTime() {
		return arrivalTime;
	}

	public void setArrivalTime(LocalTime arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public LocalTime getDepartureTime() {
		return departureTime;
	}

	public void setDepartureTime(LocalTime departureTime) {
		this.departureTime = departureTime;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	public Integer getAvailableSeats() {
		return availableSeats;
	}

	public void setAvailableSeats(Integer availableSeats) {
		this.availableSeats = availableSeats;
	}

	public Integer getFare() {
		return fare;
	}

	public void setFare(Integer fare) {
		this.fare = fare;
	}

	public Route getRoute() {
		return route;
	}

	public void setRoute(Route route) {
		this.route = route;
	}

	public List<Reservation> getReservationList() {
		return reservationList;
	}

	public void setReservationList(List<Reservation> reservationList) {
		this.reservationList = reservationList;
	}
    
    
    
}

