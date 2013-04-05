package com.sas.comp.models;

// Generated Mar 30, 2013 1:36:42 PM by Hibernate Tools 3.4.0.CR1

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * Players generated by hbm2java
 */
@SuppressWarnings("serial")
@Entity(name = "players")
public class Player implements Serializable {

	@Id
	private Integer id;
	private String name;
	@JsonIgnore
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "playerId")
	private Set<TeamPlayer> teamPlayers = new HashSet<TeamPlayer>(0);
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "playerId")
	private Set<Goal> goals = new HashSet<Goal>(0);

	@Transient
	private Integer shutouts = 0;
	@Transient
	private Integer leagueTitles = 0;
	@Transient
	private Integer playoffTitles = 0;

	public void processStats() {
		this.shutouts = 0;
		this.leagueTitles = 0;
		this.playoffTitles = 0;
		for (TeamPlayer teamPlayer : this.teamPlayers) {
			teamPlayer.setGoals(0); // reset
			for (Goal goal : this.goals) {
				if (goal.getGame().getSeason().getId() == teamPlayer.getTeam().getSeason().getId()) {
					teamPlayer.setGoals(teamPlayer.getGoals() + 1);
				}
			}
			this.shutouts += teamPlayer.getShutouts();
			this.leagueTitles += teamPlayer.getTeam().getLeagueWinner();
			this.playoffTitles += teamPlayer.getTeam().getPlayoffWinner();
		}
	}

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

	public Integer getShutouts() {
		return shutouts;
	}

	public void setShutouts(final Integer shutouts) {
		this.shutouts = shutouts;
	}

	public Integer getLeagueTitles() {
		return leagueTitles;
	}

	public void setLeagueTitles(final Integer leagueTitles) {
		this.leagueTitles = leagueTitles;
	}

	public Integer getPlayoffTitles() {
		return playoffTitles;
	}

	public void setPlayoffTitles(final Integer playoffTitles) {
		this.playoffTitles = playoffTitles;
	}
}
