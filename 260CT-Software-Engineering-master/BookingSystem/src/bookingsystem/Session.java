/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bookingsystem;

//
//
//  Generated by StarUML(tm) Java Add-In
//
//  @ Project : Untitled
//  @ File Name : Session.java
//  @ Date : 16/02/2017
//  @ Author : 
//
//

public class Session {
	private Integer id = -1;
	private String sessionType = "";
	private String date = "";
	private String time = "";
	private Double price = 0.00;

	public int getId() {
            return id;
	}
	
	public String getSessionType() {
            return sessionType;
	}
	
	public String getDate() {
            return date;
	}
	
	public String getTime() {
            return time;
	}
	
	public double getPrice() {
            return price;
	}
	
	public void setId(Integer aId) {
            id = aId;
	}
	
	public void setSessionType(String seshType) {
            sessionType = seshType;
	}
	
	public void setDate(String aDate) {
            date = aDate;
	}
	
	public void setTime(String aTime) {
            time = aTime;
	}
	
	public void setPrice(double aPrice) {
            price = aPrice;
	}
}