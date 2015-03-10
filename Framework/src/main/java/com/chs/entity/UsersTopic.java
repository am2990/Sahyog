package com.chs.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;



@Entity
@Table(name="Users_Topic")
public class UsersTopic {
	
 

    @Id
    @Column(name="id")
    @GeneratedValue
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id")
    private UserEntity user;
    
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="topic_id")
    private Topic topic;
    

    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public UserEntity getUser() {
		return user;
	}
	public void setUser(UserEntity user) {
		this.user = user;
	}
	
    public void setTopic(Topic topic){
    	this.topic = topic;
    }
    
    public Topic getTopic(){
    	return this.topic;
    }
 
}
