package vo;

import java.util.ArrayList;

public class Maps {
	private int mapId;
	private String mapName;
	private String mapType;
	private int requiredLevel;
	private ArrayList<Enemy> enemies;
	
	public Maps() {}
	
	//데이터를 받아서 생성하는 용
	public Maps(String mapName, String mapType, int requriedLevel, ArrayList<Enemy> enemies) {
		super();
		this.mapName = mapName;
		this.mapType = mapType;
		this.requiredLevel = requriedLevel;
		this.enemies = enemies;
	}
	
	//db에서 가져오는 생성자
	public Maps(int mapId, String mapName, String mapType, int requiredLevel) {
		super();
		this.mapName = mapName;
		this.mapType = mapType;
		this.requiredLevel = requiredLevel;
	}

	public int getMapId() {
		return mapId;
	}

	public void setMapId(int mapId) {
		this.mapId = mapId;
	}

	public String getMapName() {
		return mapName;
	}

	public void setMapName(String mapName) {
		this.mapName = mapName;
	}

	public String getMapType() {
		return mapType;
	}

	public void setMapType(String mapType) {
		this.mapType = mapType;
	}

	public int getRequiredLevel() {
		return requiredLevel;
	}

	public void setRequiredLevel(int requiredLevel) {
		this.requiredLevel = requiredLevel;
	}
	
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public void setEnemies(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}

	@Override
	public String toString() {
		return "맵 번호 : " + mapId + 
				"\n 맵 이름 : " + mapName + 
				"\n 맵 타입 : " + mapType + 
				"\n 최소 요구 레벨 : " + requiredLevel;
	}
	
	
	
	/*
	 * 

    // 던전 타입의 맵에 적을 추가하는 메서드
    public void addEnemy(Enemy enemy) {
        if (enemies != null) {
            enemies.add(enemy);
        } else {
            System.out.println("이 맵은 적을 포함할 수 없는 타입입니다.");
        }
    }
	 * 
	 */
	
	/*
	 * public class MapEnemyDAO {
    private static final String URL = "jdbc:mysql://localhost:3306/game_db";
    private static final String USERNAME = "username";
    private static final String PASSWORD = "password";

    public List<Map> getMapsForEnemy(int enemyId) {
        List<Map> maps = new ArrayList<>();
        String query = "SELECT maps.map_id, maps.map_name, maps.map_type, maps.required_level " +
                       "FROM maps " +
                       "JOIN map_enemies ON maps.map_id = map_enemies.map_id " +
                       "WHERE map_enemies.enemy_id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setInt(1, enemyId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int mapId = resultSet.getInt("map_id");
                String mapName = resultSet.getString("map_name");
                String mapType = resultSet.getString("map_type");
                int requiredLevel = resultSet.getInt("required_level");

                Map map = new Map(mapId, mapName, mapType, requiredLevel);
                maps.add(map);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return maps;
    }

    public List<Enemy> getEnemiesForMap(int mapId) {
        List<Enemy> enemies = new ArrayList<>();
        String query = "SELECT enemies.enemy_id, enemies.enemy_name, enemies.health, " +
                       "enemies.strength, enemies.agility, enemies.experience, enemies.money " +
                       "FROM enemies " +
                       "JOIN map_enemies ON enemies.enemy_id = map_enemies.enemy_id " +
                       "WHERE map_enemies.map_id = ?";

        try (Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
             PreparedStatement statement = conn.prepareStatement(query)) {

            statement.setInt(1, mapId);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int enemyId = resultSet.getInt("enemy_id");
                String enemyName = resultSet.getString("enemy_name");
                int health = resultSet.getInt("health");
                int strength = resultSet.getInt("strength");
                int agility = resultSet.getInt("agility");
                int experience = resultSet.getInt("experience");
                int money = resultSet.getInt("money");

                Enemy enemy = new Enemy(enemyId, enemyName, health, strength, agility, experience, money);
                enemies.add(enemy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return enemies;
    }
}
	 */
	
}
