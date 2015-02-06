package com.chs.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;



@Entity
@Table(name="topic")
public class Topic {
	
 

    @Id
    @Column(name="T_Id")
    @GeneratedValue
    private Integer id;
    
    @Column(name="topic_name")
    private String topicname;
    
    //@OneToOne(cascade = CascadeType.ALL)
    @Column(name="concept_id")
    private Integer concept_id;
    
    //@OneToOne(cascade = CascadeType.ALL)
    @Column(name="dissag_id")
    private Integer dissag_id;

    public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTopicName() {
		return topicname;
	}
	public void setTopicname(String topicname) {
		this.topicname = topicname;
	}
    
}
