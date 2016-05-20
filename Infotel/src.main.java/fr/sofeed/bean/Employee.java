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
import javax.persistence.CascadeType;


@Entity
@Table(name="employees")
// base function for infotel employee
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
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable( name="employees_tickets", catalog="sofeeddb", joinColumns = {
			@JoinColumn(name = "id_employee")},
			inverseJoinColumns = { @JoinColumn(name="id_ticket")})
	private Set<Ticket> tickets;
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable( name="employees_projects", catalog="sofeeddb", joinColumns = {
			@JoinColumn(name = "id_employee")},
			inverseJoinColumns = { @JoinColumn(name="id_project")})
	private Set<Project> projects;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable( name="employees_events", catalog="sofeeddb", joinColumns = {
			@JoinColumn(name = "id_employee")},
			inverseJoinColumns = { @JoinColumn(name="id_event")})
	private Set<Event> events;
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
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
	
	public Set<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}
	
	public Set<Project> getProjects() {
		return projects;
	}
	public void setProjects(Set<Project> projects) {
		this.projects = projects;
	}
	public Date getBirthDate() {
		return birthDate;
	}
	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}
	public Set<Event> getEvents() {
		return events;
	}
	public void setEvents(Set<Event> events) {
		this.events = events;
	}
}
