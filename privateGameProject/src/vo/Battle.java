package vo;

import java.util.ArrayList;
import java.util.Random;

public class Battle {
	private ArrayList<Enemy> enemies = new ArrayList<>();
	private Player player =  new Player();
	
	public Battle() {}
	
	public Battle(ArrayList<Enemy> enemies, Player player) {
		super();
		this.enemies = enemies;
		this.player = player;
	}

	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}

	public void setEnemies(ArrayList<Enemy> enemies) {
		this.enemies = enemies;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	/**
	 * 플레이어와 적이 싸우는 메소드
	 */
	public void startBattle() {
        System.out.println("전투가 시작되었습니다!");
        
        for (Enemy enemy : enemies) {
        	while (enemy.getHealth() > 0 && player.getHp() > 0) {
        		// 플레이어와 적이 서로 공격
        		this.playerAttack(enemy);
        		
        		if(enemy.getHealth() > 0) {
        			this.enemyAttack(enemy);
        		}
        	}
        	if(player.getHp() <= 0) {
        		System.out.println("플레이어가 전투에서 패배했습니다!");
        		break;
        	}else {
            	System.out.println(enemy.getName() + "를 처치했습니다!");
                player.setExperience(player.getExperience() + enemy.getExperience());
                player.setMoney(player.getMoney() + enemy.getMoney());
        	}
        }
        if(player.getHp() > 0) {
        	 System.out.println("모든 적을 처치했습니다. 전투에서 승리하셨습니다!");
        }
	}
	
	/**
	 * 플레이어가 적을 공격하는 메소드
	 * @param enemy
	 */
	public void playerAttack(Enemy enemy) {
		Random random = new Random();
		double damageMultiplier = 0.8 + (random.nextDouble() * 0.4); // 0.8에서 1.2 사이의 난수를 생성하여 배수값을 구합니다.
	    int damage = (int) Math.round((player.getStrength() * damageMultiplier)); // 힘에 데미지 배수를 곱하고 반올림합니다.
        System.out.println("플레이어가 " + enemy.getName() + "에게 " + damage + "의 데미지를 입혔습니다!");
        enemy.setHealth(enemy.getHealth() - damage);
	}
	
	/**
	 * 적이 플레이어를 공격하는 메소드
	 * @param enemy
	 */
	public void enemyAttack(Enemy enemy) {
		Random random = new Random();
		double damageMultiplier = 0.8 + (random.nextDouble() * 0.4); // 0.8에서 1.2 사이의 난수를 생성하여 배수값을 구합니다.
	    int damage = (int) Math.round((enemy.getStrength() * damageMultiplier)); // 힘에 데미지 배수를 곱하고 반올림합니다.
        System.out.println("플레이어가 " + player.getpName() + "에게 " + damage + "의 데미지를 입혔습니다!");
        player.setHp(player.getHp() - damage);
	}
	
	
}
