package bina.com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


	
	@Entity
	@Table(name = "POS_TBL")
	public class Position implements Serializable {

		private static final long serialVersionUID = -3465813074586302847L;

		
		@Id
		@Column(name="pos_id")
		@GeneratedValue(strategy = GenerationType.AUTO)
		private String pos_id;
		
		@Column
		private String panel_name;

		@Column
		private Integer pos_xo;

		@Column
		private Integer pos_yo;

		@Column
		private Integer pos_x1;

		@Column
		private Integer pos_y1;

		public String getPanel_name() {
			return panel_name;
		}

		public void setPanel_name(String panel_name) {
			this.panel_name = panel_name;
		}

		public Integer getPos_xo() {
			return pos_xo;
		}

		public void setPos_xo(Integer pos_xo) {
			this.pos_xo = pos_xo;
		}

		public Integer getPos_yo() {
			return pos_yo;
		}

		public void setPos_yo(Integer pos_yo) {
			this.pos_yo = pos_yo;
		}

		public Integer getPos_x1() {
			return pos_x1;
		}

		public void setPos_x1(Integer pos_x1) {
			this.pos_x1 = pos_x1;
		}

		public Integer getPos_y1() {
			return pos_y1;
		}

		public void setPos_y1(Integer pos_y1) {
			this.pos_y1 = pos_y1;
		}

		


}
