package controller;

import java.util.ArrayList;

import service.GameService;
import view.GameMenu;
import vo.Enemy;
import vo.Maps;
import vo.Player;

public class GameController {
	
	public GameController() {}

	
	
	
	// 전투 시작
	
	public void startGame() {
		
	}
	
	// 맵에 추가하고 싶은 몬스터들을 골라
	// MAPS_ENEMIES 테이블에 넣는 메소드
	public void insertMaps_Enemies() {
		System.out.println("========== 맵에 추가하고 싶은 몬스터 선택 =========");
		// -- 몬스터 조회 메소드
		System.out.println("몬스터의 번호 입력 : ");
	}

	

	
	//========================입력 메소드==========================	
		
		
	public void insertPlayer(String name, String job, int level,  int maxExperience,
			int experience, int maxHp, int hp, int maxMp, int mp, int strength, int intelligence,
			int agility, int money) {

        Player player = new Player(name, job, level, maxExperience, experience, maxHp, hp, maxMp, mp,
                strength, intelligence, agility, money);
        
        int result = new GameService().insertPlayer(player);
        
    	if (result > 0 ) { // 성공 화면
			new GameMenu().displaySuccess("성공적으로 캐릭터가 추가됐습니다.");
		}
		else { // 실패 화면
			new GameMenu().displayFail("캐릭터 추가에 실패했습니다.");
		}
	}

	public void insertEnemy(String name, int health, int strength, int agility
			, int experience, int money) {
        Enemy enemy = new Enemy(name, health, strength, agility, experience, money);
        
        int result = new GameService().insertEnemy(enemy);
        
        if(result > 0) {
        	new GameMenu().displaySuccess("성공적으로 적을 추가됐습니다.");
        } else {
        	new GameMenu().displayFail("적 추가에 실패했습니다.");
        }
	}

	public void insertMap(String mapName, String mapType, int requiredLevel) {
        // 맵 생성
       // 적 객체를 추가해서 만들기 전까지는 일단 적 리스트에 null값 입력
        Maps map = new Maps(mapName, mapType, requiredLevel, null);
    
        int result = new GameService().insertMap(map);
        
        if (result > 0 ) { // 성공 화면
			new GameMenu().displaySuccess("성공적으로 맵이 추가됐습니다.");
		}
		else { // 실패 화면
			new GameMenu().displayFail("맵 추가에 실패했습니다.");
			
		}
	}
	
	//========================수정 메소드==========================
	public void updatePlayer(String name, String job, int level,  int maxExperience,
			int experience, int maxHp, int hp, int maxMp, int mp, int strength, int intelligence,
			int agility, int money) {
		
		 Player player = new Player(name, job, level, maxExperience, experience, maxHp, hp, maxMp, mp,
	                strength, intelligence, agility, money);
		 
		 int result = new GameService().updatePlayer(player);
	        
	    	if (result > 0 ) { // 성공 화면
				new GameMenu().displaySuccess("성공적으로 캐릭터가 수정됐습니다.");
			}
			else { // 실패 화면
				new GameMenu().displayFail("캐릭터 수정에 실패했습니다.");
			}
	}


	public void updateEnemy(String name, int health, int strength, int agility
			, int experience, int money) {
		 Enemy enemy = new Enemy(name, health, strength, agility, experience, money);
	        
	        int result = new GameService().updateEnemy(enemy);
	        
	        if(result > 0) {
	        	new GameMenu().displaySuccess("성공적으로 적을 수정했습니다.");
	        } else {
	        	new GameMenu().displayFail("적 수정에 실패했습니다.");
	        }
		
	}


	public void updateMap(String mapName, String mapType, int requiredLevel) {
		Maps map = new Maps(mapName, mapType, requiredLevel, null);
	    
        int result = new GameService().updateMap(map);
        
        if (result > 0 ) { // 성공 화면
			new GameMenu().displaySuccess("성공적으로 맵이 수정됐습니다.");
		}
		else { // 실패 화면
			new GameMenu().displayFail("맵 수정에 실패했습니다.");
			
		}
	}
	
	//=========================조회 메소드============================
	
	public ArrayList<Player> selectPlayers() {
		ArrayList<Player> list = new GameService().selectPlayers();
		if(list.isEmpty()) { // list 비어있을 경우
			new GameMenu().displayNoData("조회 결과가 없습니다.");
		}
		else { // 조회된 데이터가 있을 경우
			new GameMenu().displayList(list);
		}
    	return list;
	}
	
	public ArrayList<Maps> selectMaps() {
		ArrayList<Maps> list = new GameService().selectMaps();
		if(list.isEmpty()) { // list 비어있을 경우
			new GameMenu().displayNoData("조회 결과가 없습니다.");
		}
		else { // 조회된 데이터가 있을 경우
			new GameMenu().displayList(list);
		}
    	return list;
	}
	
	public ArrayList<Enemy> selectEnemies() {
		ArrayList<Enemy> list = new GameService().selectEnemies();
		if(list.isEmpty()) { // list 비어있을 경우
			new GameMenu().displayNoData("조회 결과가 없습니다.");
		}
		else { // 조회된 데이터가 있을 경우
			new GameMenu().displayList(list);
		}
		return list;
	}
	
	
	//=========================삭제 메소드==========================
	
	public void DeletePlayer(String name) {
		int result = new GameService().deletePlayer(name);
		
		if(result > 0) {
			new GameMenu().displaySuccess("플레이어 삭제에 성공했습니다");
		}
		else {
			new GameMenu().displayFail("삭제 실패했습니다");
		}
	}


	public void DeleteEnemy(String name) {
		int result = new GameService().deleteEnemy(name);
		
		if(result > 0) {
			new GameMenu().displaySuccess("적 삭제에 성공했습니다");
		}
		else {
			new GameMenu().displayFail("삭제 실패했습니다");
		}
	}


	public void DeleteMap(String name) {
		int result = new GameService().deleteMap(name);
		
		if(result > 0) {
			new GameMenu().displaySuccess("맵 삭제에 성공했습니다");
		}
		else {
			new GameMenu().displayFail("삭제 실패했습니다");
		}
	}

	
}
