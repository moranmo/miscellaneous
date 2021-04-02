package bina.com.dao;

import java.util.List;

import bina.com.model.Position;;

public interface PositionDAO {
	
	public void addPosition(Position position);

	public List<Position> getAllPosition();

	public void deletePosition(Integer positionId);

	public Position updatePosition(Position position);

	public Position getPosition(int positionId);

}
