package main.java.com.wbc.core.classes;

import java.util.Date;
import java.util.UUID;

public class FileClasse {

	/**
	 * Identifiant unique du document
	 */
	private UUID uuid;

	/**
	 * Type de fichier (énumération dans wbc-core)
	 */
	private String fileType;

	/**
	 * Date de sauvegarde du fichier en base de données)
	 */
	private Date createdAt;

	/**
	 * Date de dernière modifiction du fichier
	 */
	private Date updatedAt;

	/**
	 * Est ce que le fichier est stocké dans S3 ?
	 */
	private Boolean available = false;

	/**
	 * Empreinte du fichier pour vérifier l'intégralité avec le fichier stocké sur s3
	 */
	private String hash;

	/**
	 * MIME du fichier
	 */
	private String mime;

	/**
	 * Taille du fichier
	 */
	private Long filesize;

	/**
	 * Nom du bucketname S3 où le fichier est stocké
	 */
	private String s3Bucketname;

	/**
	 * Nom du fichier
	 */
	private String fileName;

	/**
	 * Emplacement du fichier dans le bucketname S3
	 */
	private String s3Path;

	/**
	 * Clé vers un objet lié (par exemple si file_type = EMAIL_HTML, cette valeur est l'identifiant du mail)
	 */
	private String foreignKeyObject;
	
	/**
	 * ULR pour accéder au fichier (si il est public)
	 */
	private String completeUrlAccess;
	

	/**
	 * COntenu du fichier
	 */
	private byte[] content;


	public String getCompleteUrlAccess() {
		return completeUrlAccess;
	}

	public void setCompleteUrlAccess(String completeUrlAccess) {
		this.completeUrlAccess = completeUrlAccess;
	}

	public byte[] getContent() {
		return content;
	}

	public String getMime() {
		return mime;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	public UUID getUuid() {
		return uuid;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	/**
	 * Constructeur pour insérer le fichier en base de données (pas encore stocké dans s3)
	 * @param file_type
	 * @param hash
	 * @param mime
	 * @param filesize
	 */
	public FileClasse(String file_name, String file_type, String hash, String mime, Long filesize, String foreign_key_object) {
		super();
		this.fileName = file_name;
		this.fileType = file_type;
		this.hash = hash;
		this.mime = mime;
		this.filesize = filesize;
		this.available = false;
		this.foreignKeyObject = foreign_key_object;
	}

	/**
	 * Enregistre dans l'objet les informations liés au stockage du fichier sur le s3
	 * @param s3_bucketname
	 * @param s3_path
	 */
	public void saveS3Upload(String s3_bucketname, String s3_path, String complete_url_access) {
		this.s3Bucketname = s3_bucketname;
		this.s3Path = s3_path;
		this.available = true;
		this.completeUrlAccess = complete_url_access;
	}

	/**
	 * @deprecated ne pas utiliser ce constructeur
	 */
	public FileClasse() {
		super();
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Boolean getAvailable() {
		return available;
	}

	public void setAvailable(Boolean available) {
		this.available = available;
	}

	public Long getFilesize() {
		return filesize;
	}

	public void setFilesize(Long filesize) {
		this.filesize = filesize;
	}

	public String getS3Bucketname() {
		return s3Bucketname;
	}

	public void setS3Bucketname(String s3Bucketname) {
		this.s3Bucketname = s3Bucketname;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getS3Path() {
		return s3Path;
	}

	public void setS3Path(String s3Path) {
		this.s3Path = s3Path;
	}

	public String getForeignKeyObject() {
		return foreignKeyObject;
	}

	public void setForeignKeyObject(String foreignKeyObject) {
		this.foreignKeyObject = foreignKeyObject;
	}

	public void setUuid(UUID uuid) {
		this.uuid = uuid;
	}

	public void setMime(String mime) {
		this.mime = mime;
	}



}
