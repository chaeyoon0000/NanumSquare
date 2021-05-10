# 나눔스퀘어: NanumSquare
README.md of Database Programming in DongDuk.W.Univ by Chaeyoon Kim.

## OutLine
*당신의 일상을 공유하는 '나눔스퀘어'*

매일매일이 똑같은 일상, 지루하고 피곤한 요즘 내 일상을 다이나믹하게 바꿔줄 수 있는 생활에 들어가봅니다.
누구든 자신이 혼자 놀았던 기록이나 함께 놀았던 일상을 일기장에 적는 것처럼 기록을 하고 공유할 수 있습니다.

1. Customize Service
사용자의 취미나 성향을 바탕으로 작성된 게시글과 순위로 작성된 게시글과 순위로 사용자 맞춤 서비스를 제공합니다.

2. Reliability
사용자들이 직접 경험하고 작성한 글로 신뢰성을 높입니다.

3. Meeting
성별과 나이 상관없이 누구나 이용 가능한 서비스이며, 원한다면 오프라인 미팅을 통해 새로운 친구를 만듦

## Main Features
* Ranking
	- 검색 순위 ’, 조회수 순위 ’, 좋아요 순위 를 통해 사용자들의 최근 공통 관심사 파악

* 좋아요^_^b
	- ‘좋아요’ 기능을 통해 다른 사용자들이 추천한 놀이 문화 공유

* 파티원 구하기
	- 함께 놀이 문화를 즐기고 싶은 사람들끼리 오프라인 미팅을 통해 친목 도모

* Friends
	- 친구 등록 및 삭제 기능을 통해 친구의 게시글 모아보기

* Game
	- 서비스를 이용하기 위한 포인트를 게임을 통해 획득

## Use Case Diagram
#### 친구하기
<img src="https://user-images.githubusercontent.com/79551041/117678772-aa25ce00-b1ea-11eb-89c6-d6dfe1eafc22.png" width="700" height="500">

#### Ranking
<img src="https://user-images.githubusercontent.com/79551041/117678825-b742bd00-b1ea-11eb-8b18-a6b9a67e6f75.png" width="700" height="500">

#### Game
<img src="https://user-images.githubusercontent.com/79551041/117678883-c4f84280-b1ea-11eb-994a-ef8ba0415c3c.png" width="700" 

## System Configuration Map
<img src="https://user-images.githubusercontent.com/79551041/117679139-f6710e00-b1ea-11eb-939c-8b3bb9916c25.png" width="700" height="500">

## E-R Diagram
<img src="https://user-images.githubusercontent.com/79551041/117679256-130d4600-b1eb-11eb-9dd1-c7932ebd7127.png" width="700" height="500">

## Domain Class Design
<img src="https://user-images.githubusercontent.com/79551041/117679329-23252580-b1eb-11eb-8088-29bcc09db1db.png" width="700" height="500">


### Code Line
* Game_particiate game
```java
	public class ParticipateGameController implements Controller{
	private UserDAO userDAO = new UserDAO();
	private GameDAO gameDAO = new GameDAO();
	private BettingDAO bettingDAO = new BettingDAO();
	
	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		System.out.println(Integer.parseInt(request.getParameter("gameNo")));
		Integer gameNo = Integer.parseInt(request.getParameter("gameNo"));
		Integer bPoint = Integer.parseInt(request.getParameter("bPoint"));
		
		System.out.println("No: " + gameNo);
		
		System.out.println("gameNo: " + gameNo + " bPoint: " + bPoint);
		
		HttpSession session = request.getSession();
		String userId = (String) session.getAttribute("userId");
		User user = userDAO.findUser(userId);
		
		if(user.getPoint() < bPoint) {	
			 response.setCharacterEncoding("EUC-KR");
		     PrintWriter writer = response.getWriter();
		     writer.println("<script type='text/javascript'>");
		     writer.println("alert('Not enough points');");
		     writer.println("history.back();");
		     writer.println("</script>");
		     writer.flush();
		}
		
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlCurrDate = new java.sql.Date(utilDate.getTime());
		
		int betNo = bettingDAO.getSeq();

		Betting betting = new Betting(betNo, bPoint, gameNo, sqlCurrDate, user.getUserNo());
		
		bettingDAO.insertBetting(betting);
		bettingDAO.redeemPoint(user.getUserNo(), bPoint);

		if(gameDAO.getMaxPoint(gameNo) < bPoint) {
			gameDAO.updateMaxPoint(gameNo, bPoint);
		}
		
		request.setAttribute("betting", betting);
		
		return "redirect:/views/game/detail?gameNo=" + gameNo;
	}
}
```

* Circle_파티원 모집 마감 스케쥴러 실행
```java
public class JobScheduler {
    String cronExp;                    
    Class<? extends Job> clazz;
    static int i = 0;

    public JobScheduler(Class<? extends Job> clazz, String cronExp) {
        this.clazz = clazz;
        this.cronExp = cronExp;
    }

	public void triggerJob() {      
        Scheduler sch = null;
        SchedulerFactory schFactory = null;
        
        // schedule the job
        // JobExecuter
        JobDetail job = JobBuilder.newJob(this.clazz)
                .withIdentity(this.clazz.getName()+i).build();
        
        // batch.properties
        CronTrigger cronTrigger = TriggerBuilder.newTrigger()
                .withIdentity("crontrigger"+i, "crontriggergroup1"+i)
                .withSchedule(CronScheduleBuilder.cronSchedule(this.cronExp))
                .build();
        
        System.out.println(cronTrigger);
        
        try {
            schFactory = new StdSchedulerFactory();
            sch = schFactory.getScheduler();
            sch.start();    //    JobExecuter.class Start
            sch.scheduleJob(job, cronTrigger);
            i++;
        } catch (SchedulerException e) {
        	e.printStackTrace();
        }
    }
}
  ```
  
### Human Resources
* 개발 투입 인력
	- 4인
* 개발 기간
	- 2019.08~2019.12
* 담당 역할
	- Full-Stack Development
