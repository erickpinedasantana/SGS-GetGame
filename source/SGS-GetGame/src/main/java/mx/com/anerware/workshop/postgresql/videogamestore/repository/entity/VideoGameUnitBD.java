package mx.com.anerware.workshop.postgresql.videogamestore.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="video_games", schema = "public")
public class VideoGameUnitBD {
	@Id
	@Column(name="video_game_idx")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer videoGameIdx;
	@Column(name="title")
	private String title;
	@Column(name="description")
	private String description;
	@Column(name="developed_by")
	private String developedBy;
	@Column(name="years")
	private Integer year;
	@Column(name="players")
	private Integer players;
}