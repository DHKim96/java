package com.kh.model.vo;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Dungeon extends Map{
	// 입장 가능 레벨
	private ArrayList<Enemy> enemies = new ArrayList<>(); // 던전에 존재하는 몬스터 리스트
	private Player character; // 캐릭터
	private Scanner sc = new Scanner(System.in);
	
    // 생성자
	public Dungeon(int mapId, String mapName, String mapType, int requiredLevel, String mapInfo, ArrayList<Enemy> enemies, Player character) {
		super(mapId, mapName, mapType, requiredLevel, mapInfo);
		this.enemies = enemies;
		this.character = character;
	}
	
	public Dungeon(String mapName, String mapType, int requiredLevel, String mapInfo, ArrayList<Enemy> enemies, Player character) {
		super(mapName, mapType, requiredLevel, mapInfo);
		this.enemies = enemies;
		this.character = character;
	}
	
	// getter, setter
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public void setEnemies(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}

	public Player getCharacter() {
		return character;
	}

	public void setCharacter(Player character) {
		this.character = character;
	}
	
	// 캐릭터가 던전에 입장하는 메소드
    public void enter(Player character) {
        this.character = character;
        explore(); // 던전 탐험 시작
    }

	// 캐릭터와 적이 전투하는 메소드
	public void battle(Player c, Enemy e) {
    	
    	int cdamage = c.attack(e);
    	System.out.println("가한 데미지 : " + cdamage);
    	e.decreaseHealth(cdamage);
    	
    	int edamage = e.attack(c);
    	System.out.println("hp가 " + edamage + "만큼 닳았습니다.");
    	c.decreaseHealth(edamage);
    	
	   if (e.isDefeated()) {
           System.out.println(e.getName() + "를 물리쳤습니다!");
       } else {
           System.out.println("당신은 전투에서 패배했습니다...");
           return; // 전투에 패배하면 탐험을 중단
       }
    }

    // 던전 탐험 메소드
    private void explore() {
        Random random = new Random();
        // 만약 던전에 몬스터를 추가했다면 해당 던전에는 
        
        while (!enemies.isEmpty()) { // 던전에 몬스터가 남아있는 동안 반복
            int index = random.nextInt(enemies.size()); // 랜덤하게 몬스터 선택
            enemy = enemies.get(index);
            System.out.println("당신은 " + enemy.getName() + "를 만났습니다!");
            
            // 싸울 것인지 도망칠 것인지 선택
            System.out.println("전투(1) / 도주(2) 선택 : ");
            int select = sc.nextInt();
            switch(select) {
                case 1:
                    battle(character, enemy);
                    break;
                case 2:
                    System.out.println("적을 보고 기겁하여 도망쳤습니다.");
                    // 도망칠 경우 해당 적을 리스트에서 제거하지 않고 다음 루프로 넘어감
                    break;
                default:
                    System.out.println("잘못 입력하였습니다. 다시 입력해주세요.");
            }
            
            if (!character.isDefeated() && !enemies.isEmpty()) {
                printBattleResult(character, enemy);
                battleEndMenu(character, enemy);
            }
        }
        System.out.println("던전 탐험이 종료되었습니다.");
    }
    // 전투 결과를 보여주는 메소드
    private void printBattleResult(Player c, Enemy e) {
    	System.out.println("===== 전투 결과 ======");
    	c.defeatEnemy(e);
        enemies.remove(e); // 죽은 몬스터는 리스트에서 제거
    	System.out.println("=== 전리품 ===");
    	System.out.println("획득한 경험치 : ");
    	System.out.println("획득한 돈 : ");
    	System.out.println("획득한 아이템 : ");
    	System.out.println("=== 현재" + c.getName() + "의 상태 ===");
    	System.out.println(c.showinfo());
    }
    // 전투 종료 후 메뉴창을 보여주는 메소드
    private void battleEndMenu(Player character, Enemy enemy) {
    	while(true) {
	        System.out.println("전투가 종료되었습니다.");
	        System.out.println("다음 동작을 선택하세요:");
	        System.out.println("1. 계속해서 던전 탐험하기");
	        System.out.println("2. 캐릭터 정보 확인하기");
	        System.out.println("3. 던전에서 나가기");
	        int choice = sc.nextInt();
	        switch (choice) {
	            case 1:
	                return; // 던전 탐험을 계속
	            case 2:
	                character.showinfo(); // 캐릭터 정보 출력
	                break;
	            case 3:
	                System.out.println("던전을 나갑니다.");
	                enemies.clear(); // 나가면 모든 적 제거
	                return;
	            default:
	                System.out.println("잘못된 입력입니다. 다시 선택하세요.");
	               // 잘못된 입력일 경우 다시 메뉴 보여주기
	        }
	    }
    }
    
}
