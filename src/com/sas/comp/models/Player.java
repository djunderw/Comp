package com.sas.comp.models;

// Generated Mar 30, 2013 1:36:42 PM by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * Players generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity(name = "players")
public class Player implements Serializable {

	@Id
	private Integer id;
	private String name;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "playerId")
	private Set<TeamPlayer> teamPlayers = new HashSet<TeamPlayer>(0);
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "playerId")
	private Set<Goal> goals = new HashSet<Goal>(0);

	public Integer getId() {
		return this.id;
	}

	public void setId(final Integer id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Set<TeamPlayer> getTeamPlayers() {
		return this.teamPlayers;
	}

	public void setTeamPlayers(final Set<TeamPlayer> teamPlayers) {
		this.teamPlayers = teamPlayers;
	}

	public Set<Goal> getGoals() {
		return this.goals;
	}

	public void setGoals(final Set<Goal> goals) {
		this.goals = goals;
	}

}
