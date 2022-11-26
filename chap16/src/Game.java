import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.util.ArrayList;

import javax.swing.ImageIcon;
// 각각의 스레드를 만들지 않고 이곳 하나에 전부 넣어둔다
// 실제 구현 되는 곳(GameMain(실행되는 곳),GamePanel(그림 그릴 곳),Player(게임플레이어),Game(스레드 구현할 곳))
// 하나씩 그림을 프레임처럼 불러내어 사용 - 기존처럼 하나의 패널에 레이블을 앉히면 화면에 너무 많은 객체가 생성이 되기 때문에 
public class Game extends Thread {//스레드 상속
	public int threadDelay = 20; // 전체 화면 랜더링 속도 0.02초 마다 그리는 것(변수로 설정)
	public Player player = new Player(600, 700, 100); // player 정의/생성 (좌표x,y,hp-100)	
	// 아래 설정에서 참이여야지만 이동을 하고 조건이 만족이 되니까 기본 설정을 false로 해둬서 못 움직이 해준다
	// 기본 설정
	public boolean isLeft = false;
	public boolean isRight = false;
	public boolean isUp = false;
	public boolean isDown = false;
	public boolean isShoot = false;

	private int count = 0; // 카운트 되는 횟수로 
	private int bulletDelay = 2; // 총알 딜레이 (속도)
	private int enemyDelay = 20; // 적 딜레이

	public PlayerBullet playerBullet; // 생성 / 스페이스를 누를때 마다 생성 - playerBulletList에 들어갈 예정
	public int playerBulletDamage = 10; // 총알 데미지 / 생성할떄 넣을 변수

	public Enemy enemy;//Enemy 생성
	private String enemyImageList[] = { "ufo01", "ufo02", "ufo03" }; // 이미지 3개를 리스트에 넣어둔다
	
	public Boom02 boom; // Boom02 정의 
	private ArrayList<Boom02> boomList = new ArrayList<>();

	public Heart heart; // hert 변수 정의
	private ArrayList<Heart> heartList = new ArrayList<>();
	
	public ArrayList<PlayerBullet> playerBulletList = new ArrayList<>(); 
	//PlayerBullet을 넣을 수 있는 ArrayList를 만들 수 있다(여러개 넣어야 할때 용이)
	public ArrayList<Enemy> enemyList = new ArrayList<>();
	// 위에 Bullet와 같은 용도

	//끝났을때 사용할 변수 생성
	public boolean isOver = false;

	//게임 이미지 불러오기 (사용 하는 곳에 두기)
	private Image gameImage = new ImageIcon("images/game_page.jpg").getImage();
	private Image endingImage = new ImageIcon("images/ending_page.jpg").getImage();

	// space를 누르면 총알 생성해서 playerBulletList에 집어 넣기

	//게임 생성자 - 시작할때 세팅
	public Game() {
		//게임이 시작될 때 isOver 변수를 우선 입력 
		isOver = false;
		//리스트 배열들 비워두기
		playerBulletList.clear();
		enemyList.clear();
		count = 0;
		start(); // start라는 메서드(기본메서드)를 통해 run실행(스레드 시작)
	}
	
	//// 스레드 상속시 run을 꼭 오버라이드 해주어야 한다
	@Override
	public void run() {
		while (true) {//무한 루트 만들어 두고
			try {
				Thread.sleep(threadDelay);//반복하여 스레드 랜더링 만드는 법
			} catch (InterruptedException e) {// InterruptedException : 예외시 중단
				// e.printStackTrace(); - 쌓여 있는 것을 추적하여 나타내는 것
				return;
			}
			// 이곳에 움직임 제어하는 곳을 넣는다
			// 키를 누르면 player이 움직이게 만들기
			//   반복 되는 것
			count++; // 반복시 마다 카운트 횟수 생성 / 스레드 랜더링 속도에 의해 값이 정해짐
			keyProcess(); // player 움직이기
			playerBulletProcess();// 불릿 움직이기
			makeEnemy();
			enemyProcess();
			boomProcess();
			
			//makeHeart(); // 이곳에서 사용하면 실행하면 알아서 나오게 된다
			heartProcess();
		}
	}

	
//////////////사용할 메서드	
	private void makeHeart() { // 가만히 랜덤으로 나오게
		if (Math.random() < 0.1) {// 확률 0.1 보다 작아지는 확률(10분의 1)
			int randomX = (int) (Math.random() * 800 + 200);
			heart = new Heart(randomX, -64, 10);
			heartList.add(heart);
		}
	}
	private void makeHeart02(int x,int y) { // 죽였을때 확률적으로 나오게
		if (Math.random() < 0.1) {
			heart = new Heart(x, y, 10);
			//조건이 만족되면  0.05의 확률로 x,y 좌표로 생성
			heartList.add(heart);
		}
	}
	public void heartProcess() {
		for (int i = 0; i < heartList.size(); i++) {
			heart = heartList.get(i);
			heart.moveDown();
			if (hitEnemy(new Rectangle(player.x, player.y, player.width, player.height),
					new Rectangle(heart.x, heart.y, heart.width, heart.height))) {
				heartList.remove(heart);
				player.hp += heart.hp;
				if(player.hp>100) player.hp=100; // 100보다 hp가 크다면 hp는 100이다 (100이상 증가 막아주는 법)
			}
			if (heart.y > 800 + 64) {
				heartList.remove(heart); // 제거만
			}
		}
	}
	//외계인 생성
	private void makeEnemy() {
		if (count % enemyDelay == 0) {// 나머지가 0이 나올때에만 동작하는 조건
			String enemyImage = enemyImageList[(int) (Math.random() * 3)];
			// 위에 정의 한 이미지가 랜덤으로 하나씩 뽑혀 나오게
			int randomX = (int) (Math.random() * 800 + 200);//200~1000사이
			enemy = new Enemy(randomX, -64, 30, enemyImage);
			// 처음 생성될 때 위치 (randomX(내려올때 위치 값/생성되는 곳), -64(생성될때 크기 때문에), 30, enemyImage);
			enemyList.add(enemy); // 리스트에 추가
		}
		// enemy.moveDown();
	}

	public void enemyProcess() {// 적 처리과정
		for (int i = 0; i < enemyList.size(); i++) {
			enemy = enemyList.get(i);//enemyList에 있는것 을 가져오기
			enemy.moveDown(); // 아래로 움직이는 것(불러온다 enemy에서)

			if (hitEnemy(new Rectangle(player.x, player.y, player.width, player.height),
					new Rectangle(enemy.x, enemy.y, enemy.width, enemy.height))) {
				//적과 플레이어 충돌
				enemyList.remove(enemy); // 충돌시 외계인 제거
				player.hp -= enemy.damage;//외계인 데미지 만큼 hp 감소
				if (player.hp <= 0) {//플렝이어의 hp가 0보다 작을 경우(조건)
					isOver= true; // 끝나는 순간 다른 변수 이용을 위해 정의(ending이미지)
					interrupt(); // Thread 종료하는 방법 중 하나
				}
			}
			if (enemy.y > 800 + 64) { //적정 위치 이상이 되면(바닥에 충돌) enemy 제거
				player.hp -= enemy.damage; // 바닥 충돌시 외계인 데미지 만큼 플레이어 hp감소
				enemyList.remove(enemy); // enemy 제거
				if (player.hp <= 0) {
					isOver= true;
					interrupt(); // Thread 종료
				}
			}
		}
	}

	public void playerBulletProcess() { //총알 처리 과정
		for (int i = 0; i < playerBulletList.size(); i++) {
			playerBullet = playerBulletList.get(i);
			playerBullet.shoot();// 위로 발사를 시켜줘 중첩되는 것을 바꿔줄 수 있다
			
			// 총알과 ufo 충돌 조건
			for (int j = 0; j < enemyList.size(); j++) {
				enemy = enemyList.get(j); // enemy 값 받아오고
				if (hitEnemy(new Rectangle(playerBullet.x, playerBullet.y, playerBullet.width, playerBullet.height),
						new Rectangle(enemy.x, enemy.y, enemy.width, enemy.height))) {
					//hitEnemy 아래에 정의 해둔 충돌 감지 총알과 ufo / 각자 직사각형 크기 (충돌 값을 얻어와야해서)
					playerBulletList.remove(playerBullet);//조건이 만족되면 총알 제거					
					enemy.hp -= playerBullet.damage;//충돌시 enemy의 hp 가 총알의 데미지 만큼 감소
					
					 
				}
				
				if (enemy.hp <= 0) {// 체력이 0보다 작아지면(조건)
					enemyList.remove(enemy); // 외계인을 제거
					boom = new Boom02(enemy.x,enemy.y); // 붐 생성(좌표는 외계인 좌표)
					boomList.add(boom);// 붐리스트에 붐 추가
					makeHeart02(enemy.x,enemy.y); // 죽으면 그 위치에서 확률계산하여 나타남
					
				}
			}
			//불필요한 용량(arrayList)이 쌓이지 않게 총알 제거(창 넘어갈때)
			if (playerBullet.y < -17) {//만약에  playerBullet에 y가 총 높이 17보다 낮다면 
				playerBulletList.remove(playerBullet);//playerBulletList에서 playerBullet을 제거 해준다
				
			}
		}
	}
	public void boomProcess() { //붐 과정(돌아갈때)
		for(int i=0;i<boomList.size();i++) {
			boom = boomList.get(i); //뽑아오고
			boom.explosion();
			//System.out.println(boom.count);
			if(boom.count>10) { // 붐 카운트가 낮을수록 빨리 사라짐
				boomList.remove(boom);
			}
			
		}
	}
	
	//키 메서드 // player에서 만들어둔 메서드 불러와서 사용 / key누를때의 처리과정
	public void keyProcess() {
		if (isLeft)//조건을 걸어준다 왼쪽으로 갔을때만 할 수 있다는 조건 / player에 키 이벤트를 걸어둔 상태에서
			//그래서 처음엔 멈춰야 하기 때문에 false설정(전역변수 boolean으로)
			player.moveLeft();//player에서 moveLeft()를 가져와 실행 시켜준다
			if(player.x<=0) {// 패널 창 넘어가지 않게 하는 법
				player.x=0;
			}
		if (isRight)
			player.moveRight();
			if(player.x>=1200-64) {
				player.x=1200-64;
			}		
		if (isUp)
			player.moveUp();
			if(player.y<=0) {
				player.y=0;
			}	
		if (isDown)
			player.moveDown();
			if(player.y>=800-64) {
				player.y=800-64;
			}	
		if (isShoot && count % bulletDelay == 0) { // count(반복문에 설정해둔상태)가 증가 될때마다 발사 bulletDelay(변수 설정)-> 이걸로 나눴을때 나머지가 0일경우에만 증가(발사)한다
			playerBullet = new PlayerBullet(player.x + 27, player.y - 17, playerBulletDamage);
			// PlayerBullet 선언 PlayerBullet(player.x + 27(이미지 절반 - 총알 절반), player.y - 17(총알 높이), playerBulletDamage(정의한 위의 데미지))
			playerBulletList.add(playerBullet);//playerBulletList에 넣어두기(한꺼번에 제어하기 위해)
		}
	}
	// 총알 ufo  충돌 
	public boolean hitEnemy(Rectangle rect01, Rectangle rect02) { 
		return rect01.intersects(rect02);//intersects 충돌 감지
		//Rectangle 임폴트 - 직사각형
	}
	
	/////그림 그리기
	
	// 비행기 그리기
	public void drawPlayer(Graphics g) { // 그리다
		//그림 하나 그려주기(Graphics - 그릴때 필요 / 임폴트 필요)
		//비행기 그리기(Player을 가져와야 한다-전역변수로 설정해두기)
		g.drawImage(player.image, player.x, player.y, null);
		//이미지 그리기(이미지 넣기, 좌표 x, 좌표 y, 넓이 높이(따로 없이 null처리) this)
	}
	// 총알 그리기
	public void drawPlayerBullet(Graphics g) { 

		for (int i = 0; i < playerBulletList.size(); i++) {// arrayList 경우 length가 아닌 size로 확인 시킨다
			playerBullet = playerBulletList.get(i); 
			g.drawImage(playerBullet.image, playerBullet.x, playerBullet.y, null);
		}// 계속 겹쳐지며 만들어진다
	}
	// 외계인 그리기
	public void drawEnemy(Graphics g) {
		for (int i = 0; i < enemyList.size(); i++) {
			enemy = enemyList.get(i);
			g.drawImage(enemy.image, enemy.x, enemy.y, null);
		}
	}
	public void drawHeart(Graphics g) {
		for (int i = 0; i < heartList.size(); i++) {
			heart = heartList.get(i);
			g.drawImage(heart.image, heart.x, heart.y, null);
		}
	}
	// 체력바 그리기 
	public void drawInfo(Graphics g) {
		// player 정보
		g.setColor(Color.WHITE);// 색상
		g.setFont(new Font("Arial", Font.BOLD, 24));//글자  new Font(글꼴, 굵기, 크기)	
		g.drawString("HP : " + player.hp, 30, 30); // 그려주기(문자+플레이어hp(수치),좌표x,좌표y)

		g.setColor(Color.WHITE);
		g.fillRect(130, 17, 300, 5);
		g.setColor(Color.RED);
		g.fillRect(130, 17, 300 * player.hp / 100, 5);
		
		g.setFont(new Font("Arial", Font.BOLD, 18));
		for (int i = 0; i < enemyList.size(); i++) {// enemyList 사이즈 만큼 계속 반복
			enemy = enemyList.get(i);// 리스트 불러오고
			// g.draw(""+enemy.hp,enemy.x+20,enemy.y-20); -- 외계인 좌표에 그리기 - 숫자 표현시 사용
			g.setColor(Color.WHITE);// 색상 흰색(바탕)
			g.fillRect(enemy.x, enemy.y - 20, 64, 4); // 체력 바 기존 고정
			g.setColor(Color.RED);//색상 빨강(체력 나타내기)
			g.fillRect(enemy.x, enemy.y - 20, enemy.width * enemy.hp / 30, 4);
			// 채우기(x좌표,y좌표에서 위로,채우기의 넓이, 높이)
			//enemy.width * enemy.hp / 30 넓이 만큼 hp 값을 나타내는데 3번(30데미지) 맞으면 hp가 없어진다
		}
	}
	// 배경 이미지 그리기
	public void drawEnding(Graphics g) {
		g.drawImage(endingImage,0,0,null);
	}
	public void drawGaming(Graphics g) {
		g.drawImage(gameImage,0,0,null);
	}
	// 폭탄 그리기
	public void drawBoom(Graphics g) {
		for (int i = 0; i < boomList.size(); i++) {
			boom = boomList.get(i);
			g.drawImage(boom.image, boom.x, boom.y, null);
		}
	}
	// 그린 그림 전체 담아주기
	public void drawAll(Graphics g) {// 여기 있는 것을 GamePanel에서 돌려준다
		// GamePanel에 drawAll을 이용하여 전체 구현을 하였고 그 구현으로 인한 메서드가 자동적으로 이곳에 생성되게 만듦
		if(isOver) drawEnding(g); // isOver가 참이면 엔딩 이미지를 그리고 그렇지 않으면 아래 진행
		else {
			drawGaming(g);
			drawPlayer(g);
			drawPlayerBullet(g);
			drawEnemy(g);
			drawInfo(g);
			drawBoom(g);
			drawHeart(g);
		}
	}
}
