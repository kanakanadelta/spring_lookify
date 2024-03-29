package com.wos.lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="songs")
public class Song {
	// generate primary ID:
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	// Generate title  - min 5 chars:
	@Size(min=2, max=20)
	private String title;
	
	// Generate artist name - min 5 chars:
	@Size(min=5, max=20)
	private String artist;
	
	// Generate rating - num from 1 to 10:
	@Min(1)
	@Max(10)
	private Integer rating;
	
	// Generate dates:
	
    // This will not allow the createdAt column to be updated after creation
    @Column(updatable=false)
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createdAt;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date updatedAt;
    
    // Constructor:
    
    public Song(
    	String title,
    	String artist,
    	Integer rating
    	) {
    	this.title = title;
    	this.artist = artist;
    	this.rating = rating;
    }
    
    public Song() {
    	//empty constructor for intialization
    }
    
    // GENERATE GETTERS AND SETTERS

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public Integer getRating() {
		return rating;
	}

	public void setRating(Integer rating) {
		this.rating = rating;
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
    
    //
    
	// // runs the method right before the object is created
    @PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    // // runs a method when the object is modified
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
    
	
}
