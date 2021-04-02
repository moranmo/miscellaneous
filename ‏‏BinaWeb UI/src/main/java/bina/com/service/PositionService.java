package bina.com.service;

import java.util.List;

import bina.com.model.Position;

public interface PositionService {
	
	public void addPosition(Position position);

	public List<Position> getAllPosition();

	public void deletePosition(Integer position);

	public Position getPosition(int positionid);

	public Position updatePostion(Position position);
	

}
