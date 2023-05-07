package net.javaguides.springboot.model;

import jakarta.persistence.*;


// this is going to be our  data base, where a table called "chicago_data_crimes" will be created
@Entity
@Table(name = "chicago_data_crimes")
public class Chicago_data_crime {
	
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private long id;
	
	
	//What we have bellow are the attribute that we select for our data set
	@Column(name = "Crime_ID")
	private String crimeID;
	
	@Column(name = "Case_number")
	private String caseNumber;
	
	@Column(name = "Crime_date")
	private String date;
	
	@Column(name = "Crime_block")
	private String block;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getCrimeID() {
		return crimeID;
	}
	public void setCrimeID(String crimeID) {
		this.crimeID= crimeID;
	}
	public String getCaseNumber() {
		return caseNumber;
	}
	public void setCaseNumber(String caseNumber) {
		this.caseNumber = caseNumber;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public String getBlock() {
		return block;
	}
	public void setBlock(String block) {
		this.block = block;
	}
}
