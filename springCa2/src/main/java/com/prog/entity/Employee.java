package com.prog.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "EMP_SYSTEM")

public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int Row_ID;
	private String game_id;
	private String minute;
	private String name;
	private String team1;
	private String team2;
	
	
	
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getRow_ID() {
		return Row_ID;
	}
	public void setRow_ID(int Row_ID) {
		this.Row_ID = Row_ID;
	}
	public String getgame_id() {
		return game_id;
	}
	public void setgame_id(String game_id) {
		this.game_id = game_id;
	}
	public String getminute() {
		return minute;
	}
	public void setminute(String minute) {
		this.minute =minute;
	}
	public String getname() {
		return name;
	}
	public void setname(String name) {
		this.name = name;
	}
	public String getteam1() {
		return team1;
	}
	public void setteam1(String team1) {
		this.team1 = team1;
	}
	public String getteam2() {
		return team2;
	}
	public void setteam2(String team2) {
		this.team2 = team2;
	}
	@Override
	public String toString() {
		return "Emplpoyee [Row_ID=" + Row_ID + ", game_id=" + game_id + ", minute=" + minute + ", name=" + name + ", team1=" + team1
				+ ", team2=" + team2 + "]";
	}
	

}
