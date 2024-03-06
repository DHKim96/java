package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.GameController;


public class GameMenu {
	private Scanner sc = new Scanner(System.in);
	private GameController gc = new GameController();
	
	
	
	// ============================== 시작 메뉴 ==========================
	public void mainMenu() {
		while (true) {
            System.out.println("========== 시작 메뉴 ============");
            System.out.println("1. 관리자 모드");
            System.out.println("2. 플레이어 모드");
            System.out.println("0. 종료");
            System.out.print("메뉴 입력 : ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    this.adminMenu();
                    break;
                case 2:
                    this.playerMenu();
                    break;
                case 0:
                    System.out.println("이용해주셔서 감사합니다. 다음에 또 방문해주세요.");
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
            }
        }
	}
	
	
	// ==============================관리자 모드================================
	public void adminMenu() {
		while(true) {
	    	System.out.println("======== 관리자 모드 =========");
	        System.out.println("1. 생성 모드");
	        System.out.println("2. 수정 모드");
	        System.out.println("3. 삭제 모드");
	        System.out.println("0. 시작 메뉴로 돌아가기");
	        System.out.print("메뉴 입력 : ");
	        int menu = sc.nextInt();
	        sc.nextLine();
	        switch(menu) {
	        case 1:
	        	this.adminInsertMenu();
	        	break;
	        case 2:
	        	this.adminUpdateMenu();
	        	break;
	        case 3:
	        	this.adminDeleteMenu();
	        	break;
	        case 0:
	        	System.out.println("메인 메뉴로 돌아갑니다.");
	        	return;
	        default:
	        	System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
	        }
    	}
	}

	public void adminDeleteMenu() {
		while (true) {
            System.out.println("======== 삭제 모드 =========");
            System.out.println("1. 플레이어 삭제");
            System.out.println("2. 적 삭제");
            System.out.println("3. 맵 삭제");
            System.out.println("0. 뒤로 가기");
            System.out.print("메뉴 입력 : ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    gc.DeletePlayer(this.inputName());
                    break;
                case 2:
                    gc.DeleteEnemy(this.inputName());
                    break;
                case 3:
                    gc.DeleteMap(this.inputName());
                    break;
                case 0:
                	System.out.println("관리자 메뉴로 돌아갑니다.");
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
            }
        }
	}

	public void adminUpdateMenu() {
		while (true) {
            System.out.println("======== 수정 모드 =========");
            System.out.println("1. 플레이어 수정");
            System.out.println("2. 적 수정");
            System.out.println("3. 맵 수정");
            System.out.println("0. 뒤로 가기");
            System.out.print("메뉴 입력 : ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    this.updatePlayer();
                    break;
                case 2:
                    this.updateEnemy();
                    break;
                case 3:
                    this.updateMap();
                    break;
                case 0:
                	System.out.println("관리자 메뉴로 돌아갑니다.");
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
            }
        }
	}

	public void adminInsertMenu() {
		while (true) {
            System.out.println("======== 생성 모드 =========");
            System.out.println("1. 플레이어 생성");
            System.out.println("2. 적 생성");
            System.out.println("3. 맵 생성");
            System.out.println("0. 뒤로 가기");
            System.out.print("메뉴 입력 : ");
            int menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {
                case 1:
                    this.createPlayer();
                    break;
                case 2:
                    this.createEnemy();
                    break;
                case 3:
                    this.createMap();
                    break;
                case 0:
                	System.out.println("관리자 메뉴로 돌아갑니다.");
                    return;
                default:
                    System.out.println("잘못 입력하셨습니다. 다시 입력해주세요");
            }
        }
	}
	
	// ===============================플레이어 모드 ===========================
	
	private void playerMenu() {
		 System.out.println("=========== 플레이어 모드 ==============");
	        System.out.println("1. 게임 시작");
	        System.out.println("2. 전체 플레이어 정보 보기");
	        System.out.println("0. 게임 종료");
	        System.out.print("메뉴 입력 : ");
	        int menu = sc.nextInt();
	        sc.nextLine();

	        switch (menu) {
	            case 1:
	                gc.startGame();
	                break;
	            case 2:
	                gc.selectPlayers();
	                break;
	            case 0:
	                System.out.println("이용해주셔서 감사합니다. 다음에 또 방문해주세요.");
	                return;
	            default:
	                System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
	        }
	}
	
	
	
	public void createPlayer() {
		System.out.println("======= 플레이어 생성 =========");
		System.out.print("캐릭터의 이름을 입력하세요:");
        String name = sc.nextLine();

        System.out.print("캐릭터의 직업을 입력하세요:");
        String job = sc.nextLine();

        System.out.print("캐릭터의 초기 레벨을 입력하세요:");
        int level = sc.nextInt();

        System.out.print("캐릭터의 최대 경험치를 입력하세요:");
        int maxExperience = sc.nextInt();

        System.out.print("캐릭터의 초기 경험치를 입력하세요:");
        int experience = sc.nextInt();

        System.out.print("캐릭터의 최대 체력을 입력하세요:");
        int maxHp = sc.nextInt();

        System.out.print("캐릭터의 초기 체력을 입력하세요:");
        int hp = sc.nextInt();

        System.out.print("캐릭터의 최대 마나를 입력하세요:");
        int maxMp = sc.nextInt();

        System.out.print("캐릭터의 초기 마나를 입력하세요:");
        int mp = sc.nextInt();

        System.out.print("캐릭터의 힘을 입력하세요:");
        int strength = sc.nextInt();

        System.out.print("캐릭터의 지능을 입력하세요:");
        int intelligence = sc.nextInt();

        System.out.print("캐릭터의 민첩성을 입력하세요:");
        int agility = sc.nextInt();

        System.out.print("캐릭터의 초기 소지금을 입력하세요:");
        int money = sc.nextInt();
        
        gc.insertPlayer(name, job, level, maxExperience, experience, maxHp, hp, maxMp, mp, strength, intelligence, agility, money);
	}
	
	public void createEnemy() {
		System.out.println("============ 적 생성 ============");
		System.out.print("몬스터 이름: ");
        String name = sc.nextLine();
        System.out.print("몬스터 체력: ");
        int health = sc.nextInt();
        sc.nextLine();
        System.out.print("몬스터 힘: ");
        int strength = sc.nextInt();
        sc.nextLine();
        System.out.print("몬스터 민첩성: ");
        int agility = sc.nextInt();
        sc.nextLine();
        System.out.print("몬스터 경험치: ");
        int experience = sc.nextInt();
        sc.nextLine();
        System.out.print("몬스터 보상 돈: ");
        int money = sc.nextInt();
        sc.nextLine();
        
        gc.insertEnemy(name, health, strength, agility, experience, money);
	}

	public void createMap() {
		System.out.println("======== 맵 생성 =========");
		System.out.print("맵 이름 : ");
        String mapName = sc.nextLine();
        System.out.print("맵 타입 : ");
        String mapType = sc.nextLine();
        System.out.print("입장 가능 레벨 : ");
        int requiredLevel = sc.nextInt();
        sc.nextLine();
        
        gc.insertMap(mapName, mapType, requiredLevel);
	}
	
	
	public void updatePlayer() {
		System.out.println("======= 플레이어 수정 =========");
		System.out.print("캐릭터의 이름을 입력하세요:");
        String name = sc.nextLine();
        // 있는 이름인지 처리할 것
        System.out.print("캐릭터의 직업을 입력하세요:");
        String job = sc.nextLine();

        System.out.print("캐릭터의 초기 레벨을 입력하세요:");
        int level = sc.nextInt();

        System.out.print("캐릭터의 최대 경험치를 입력하세요:");
        int maxExperience = sc.nextInt();

        System.out.print("캐릭터의 초기 경험치를 입력하세요:");
        int experience = sc.nextInt();

        System.out.print("캐릭터의 최대 체력을 입력하세요:");
        int maxHp = sc.nextInt();

        System.out.print("캐릭터의 초기 체력을 입력하세요:");
        int hp = sc.nextInt();

        System.out.print("캐릭터의 최대 마나를 입력하세요:");
        int maxMp = sc.nextInt();

        System.out.print("캐릭터의 초기 마나를 입력하세요:");
        int mp = sc.nextInt();

        System.out.print("캐릭터의 힘을 입력하세요:");
        int strength = sc.nextInt();

        System.out.print("캐릭터의 지능을 입력하세요:");
        int intelligence = sc.nextInt();

        System.out.print("캐릭터의 민첩성을 입력하세요:");
        int agility = sc.nextInt();

        System.out.print("캐릭터의 초기 소지금을 입력하세요:");
        int money = sc.nextInt();
        
        gc.updatePlayer(name, job, level, maxExperience, experience, maxHp, hp, maxMp, mp, strength, intelligence, agility, money);
	}
	
	public void updateEnemy() {
		System.out.println("============ 적 수정 ============");
		System.out.print("몬스터 이름: ");
        String name = sc.nextLine();
        //예외처리
        System.out.print("몬스터 체력: ");
        int health = sc.nextInt();
        sc.nextLine();
        System.out.print("몬스터 힘: ");
        int strength = sc.nextInt();
        sc.nextLine();
        System.out.print("몬스터 민첩성: ");
        int agility = sc.nextInt();
        sc.nextLine();
        System.out.print("몬스터 경험치: ");
        int experience = sc.nextInt();
        sc.nextLine();
        System.out.print("몬스터 보상 돈: ");
        int money = sc.nextInt();
        sc.nextLine();
        
        gc.updateEnemy(name, health, strength, agility, experience, money);
	}
	
	public void updateMap() {
		System.out.println("======== 맵 수정 =========");
		System.out.print("맵 이름 : ");
        String mapName = sc.nextLine();
        System.out.print("맵 타입 : ");
        String mapType = sc.nextLine();
        System.out.print("입장 가능 레벨 : ");
        int requiredLevel = sc.nextInt();
        sc.nextLine();
        
        gc.updateMap(mapName, mapType, requiredLevel);
	}
	
	public void displaySuccess(String message) {
		System.out.println("\n서비스 요청 성공 : " + message);
	}


	public void displayFail(String message) {
		System.out.println("\n서비스 요청 실패 : " + message);
	}

	public void displayNoData(String message) {
 		System.out.println("\n" + message);
 	}
	
	public void displayList(ArrayList<? extends Object> list) {
 	    for (Object obj : list) {
 	        System.out.println(obj);
 	    }
 	}
	
	public void displayOne(Object o) {
 		System.out.println("\n조회된 데이터는 다음과 같습니다.");
 		System.out.println(o);
 	}
	
	public String inputName() {
		System.out.println("조회/수정/삭제 하고자 하는 이름을 입력해주세요 : ");
		String name = sc.nextLine();
		return name;
	}
	
	
	
	
	
	
	
}
