package bina.com.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import bina.com.model.Position;

@Repository
public class PositionDAOImpl implements PositionDAO{

	@Autowired
	private SessionFactory sessionFactory;



	public void addPosition(Position position) {
		sessionFactory.getCurrentSession().saveOrUpdate(position);

	}

	public List<Position> getAllPosition() {
		return sessionFactory.getCurrentSession().createQuery("from Position").list();
	}

	public void deletePosition(Integer positionId) {
		Position position = (Position) sessionFactory.getCurrentSession().load(
				Position.class, positionId);
		if (null != position) {
			this.sessionFactory.getCurrentSession().delete(position);
		}

	}

	public Position updatePosition(Position position) {
		sessionFactory.getCurrentSession().update(position);
		return position;
	}

	public Position getPosition(int positionId) {
		return (Position) sessionFactory.getCurrentSession().get(
				Position.class, positionId);
	}

}
