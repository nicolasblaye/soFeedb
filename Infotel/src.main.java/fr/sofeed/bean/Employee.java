package fr.sofeed.bean;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import javax.persistence.CascadeType;


@Entity
@Table(name="employees")
// base function for infotel employee
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Employee{
	
	private int id;
	@Column (name="name")
	private String name;
	@Column (name="surname")
	private String surname;
	@Column (name="birthDate")
	private Date birthDate;
	@Column (name="email")
	private String email;
	@Column (name="telephone")
	private String telephone;
	@Column (name="adresse")
	private String adresse;
	@Column (name="profilPicture")
	private String profilPicture;
	@Column (name="agency")
	private String agency;
	private List<Ticket> tickets;	
	private List<Project> projects;
	private List<Event> events;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public String getProfilPicture() {
		return profilPicture;
	}
	public void setProfilPicture(String profilPicture) {
		this.profilPicture = profilPicture;
	}
	public String getAgency() {
		return agency;
	}
	public void setAgency(String agency) {
		this.agency = agency;
	}
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "employees")
	public List<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "team")
	public List<Project> getProjects() {
		return projects;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	@JsonIgnore
	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "participants")
	public List<Event> getEvents() {
		return events;
	}
	public void setEvents(List<Event> events) {
		this.events = events;
	}
}
