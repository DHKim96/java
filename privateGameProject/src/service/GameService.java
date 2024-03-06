package service;

import java.sql.Connection;
import java.util.ArrayList;

import common.JDBCTemplate;
import dao.GameDao;
import vo.Enemy;
import vo.Maps;
import vo.Player;

public class GameService {

	public int insertPlayer(Player p) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new GameDao().insertPlayer(conn, p);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public int insertEnemy(Enemy enemy) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new GameDao().insertEnemy(conn, enemy);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}
	
	public int insertMap(Maps m) {
		Connection conn = JDBCTemplate.getConnection();
		int result = new GameDao().insertMap(conn, m);
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		JDBCTemplate.close(conn);
		return result;
	}

	public ArrayList<Player> selectPlayers() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Player> list = new GameDao().selectPlayers(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public ArrayList<Maps> selectMaps() {
		Connection conn = JDBCTemplate.getConnection();
		
		ArrayList<Maps> list = new GameDao().selectMaps(conn);
		
		JDBCTemplate.close(conn);
		
		return list;
	}

	public ArrayList<Enemy> selectEnemies() {
		Connection conn = JDBCTemplate.getConnection();

		ArrayList<Enemy> list = new GameDao().selectEnemies(conn);

		JDBCTemplate.close(conn);
		
		return list;
	}

	public int deletePlayer(String name) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new GameDao().deletePlayer(conn, name);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}

	public int deleteEnemy(String name) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new GameDao().deleteEnemy(conn, name);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public int deleteMap(String name) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new GameDao().deleteMap(conn, name);
		
		if (result > 0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public int updatePlayer(Player p) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new GameDao().updatePlayer(conn, p);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public int updateEnemy(Enemy e) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new GameDao().updateEnemy(conn, e);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
	
	public int updateMap(Maps m) {
		Connection conn = JDBCTemplate.getConnection();
		
		int result = new GameDao().updateMap(conn, m);
		
		if(result > 0) {
			JDBCTemplate.commit(conn);
		}
		else {
			JDBCTemplate.rollback(conn);
		}
		
		JDBCTemplate.close(conn);
		
		return result;
	}
}
