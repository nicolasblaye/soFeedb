package fr.sofeed.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="projects")
// a project at Infotel
public class Project {
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="startDate")
	private Date startDate;
	@Column(name="information")
	private String information;
	private List<Document> documents;
	private List<Employee> team;
	private List<Ticket> tickets;
	
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
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public String getInformation() {
		return information;
	}
	public void setInformation(String information) {
		this.information = information;
	}
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable( name="projects_employees", catalog="sofeeddb", joinColumns = {
			@JoinColumn(name = "id_project")},
			inverseJoinColumns = { @JoinColumn(name="id_employee")})
	public List<Employee> getTeam() {
		return team;
	}
	public void setTeam(List<Employee> team) {
		this.team = team;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
	public List<Document> getDocuments() {
		return documents;
	}
	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "project")
	public List<Ticket> getTickets() {
		return tickets;
	}
	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}
}
