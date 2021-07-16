package main.java.com.wbc.core.classes;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class UserClasse {

	/**
	 * Clé primaire de 36 caractères g"énéré par Cognito
	 */
	private UUID id;

	/**
	 * Login
	 */
	private String login;

	/**
	 * 255 caractères
	 */
	private String email;

	/**
	 * Nom du provider qui gère les utilisateurs (ex : cognito)
	 * 255 caractères
	 */
	@JsonIgnore
	private String provider_name;

	private Boolean newsletter;

	/**
	 * 255 caractères
	 */
	private String firstname;

	/**
	 * 255 caractères
	 */
	private String name;

	private Date date_creation;

	private Date date_last_update;

	/**
	 * Type de compte
	 */
	@JsonIgnore
	private String type;

	/**
	 * 10 caractères
	 */
	private String locale;

	/**
	 * Code de parrainage (unique)
	 * 10 caractères
	 */
	private String membership_code; 
	
	/**
	 * Pas sauvegardé en bdd, c'est simplement pour stocker le tocken à la création d'un user
	 */
	@JsonIgnore
	private String token;

	/**
	 * Mot de passe
	 * 
	 */
	@JsonIgnore
	private String password; 
	
	
	
	public void setToken(String token) {
		this.token = token;
	}
	public String getMembership_code() {
		return membership_code;
	}
	public void setMembership_code(String membership_code) {
		this.membership_code = membership_code;
	}

	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}

	public Date getDate_creation() {
		return date_creation;
	}
	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}

	public Date getDate_last_update() {
		return date_last_update;
	}
	public void setDate_last_update(Date date_last_update) {
		this.date_last_update = date_last_update;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	public Boolean getNewsletter() {
		return newsletter;
	}
	public void setNewsletter(Boolean newsletter) {
		this.newsletter = newsletter;
	}


	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public UserClasse(UUID id, String email, String login, Boolean newsletter, String locale, String membership_code, String type, String provider_name, String password) {
		super();
		this.id = id;
		this.email = email;
		this.newsletter = newsletter;
		this.locale = locale;
		this.membership_code = membership_code;
		this.date_creation = new Date();
		this.date_last_update = new Date();
		this.type = type;
		this.login = login;
		this.provider_name = provider_name;
		this.password = password;
	}
	public UserClasse() {
		super();
	}
	public UUID getId() {
		return id;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getToken() {
		return token;
	}
	public UserClasse(UUID id, String name, String login, String email, String password) {
		super();
		this.id = id;
		this.email = email;
		this.date_creation = new Date();
		this.date_last_update = new Date();
		this.login = login;
		this.password = password;
	}

}