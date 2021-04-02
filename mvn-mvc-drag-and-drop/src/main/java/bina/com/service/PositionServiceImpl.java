package bina.com.service;

import java.util.List;




import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import bina.com.dao.PositionDAO;
import bina.com.model.Position;

@Service
@Transactional
public class PositionServiceImpl implements PositionService{

	@Autowired
	private PositionDAO positionDAO;

	public void addPosition(Position position) {
		positionDAO.addPosition(position);
	
		
	}

	public List<Position> getAllPosition() {
		return positionDAO.getAllPosition();
	}

	public void deletePosition(Integer positionId) {
		positionDAO.deletePosition(positionId);
		
	}

	public Position getPosition(int positionid) {
		return positionDAO.getPosition(positionid); 
	}

	public Position updatePostion(Position position) {
		return positionDAO.updatePosition(position);
	}

	
	
}
